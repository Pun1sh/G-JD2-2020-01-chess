<style type="text/css">
.highlight-white {
	box-shadow: inset 0 0 3px 3px yellow;
}

.highlight-black {
	box-shadow: inset 0 0 3px 3px blue;
}
</style>


<div class="container">
	<br> <br>
	<div class="row">
		<div class="col s12 l6 pull-l3 ">
			<div id="myBoard" style="width: 600px"></div>
		</div>
		<div class="col s12 l6 push-l3 ">
			<label>Status:</label>
			<div id="status"></div>
			<label>FEN:</label>
			<div id="fen"></div>
			<label>PGN:</label>
			<div id="pgn"></div>
		</div>
	</div>

</div>

<script type="text/javascript">
	GAME_ID = "${gameId}"
	WHITE_PLAYER_ID = "${whitePlayerId}"
	BLACK_PLAYER_ID = "${blackPlayerId}"
	WAIT = $
	{
		userId == blackPlayerId
	}
</script>

<script>
	var board = null
	var $board = $('#myBoard')
	var game = new Chess()
	var $status = $('#status')
	var $fen = $('#fen')
	var $pgn = $('#pgn')
	var whiteSquareGrey = '#a9a9a9'
	var blackSquareGrey = '#696969'
	var squareToHighlight = null
	var squareClass = 'square-55d63'

	function removeHighlights(color) {
		$board.find('.' + squareClass).removeClass('highlight-' + color)
	}

	function removeGreySquares() {
		$('#myBoard .square-55d63').css('background', '')
	}

	function greySquare(square) {
		var $square = $('#myBoard .square-' + square)

		var background = whiteSquareGrey
		if ($square.hasClass('black-3c85d')) {
			background = blackSquareGrey
		}

		$square.css('background', background)
	}

	function onDragStart(source, piece, position, orientation) {
		if (WAIT) {
			return false;
		}

		// do not pick up pieces if the game is over
		if (game.game_over())
			return false

			// only pick up pieces for the side to move
		if ((game.turn() === 'w' && piece.search(/^b/) !== -1)
				|| (game.turn() === 'b' && piece.search(/^w/) !== -1)) {
			return false
		}
	}

	function onDrop(source, target, piece, newPos, oldPos, orientation) {
		console.log('Source: ' + source)
		console.log('Target: ' + target)
		console.log('Piece: ' + piece)
		console.log('New position: ' + Chessboard.objToFen(newPos))
		console.log('Old position: ' + Chessboard.objToFen(oldPos))
		console.log('Orientation: ' + orientation)
		console.log('~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~')

		removeGreySquares()

		// see if the move is legal
		var move = game.move({
			from : source,
			to : target,
			promotion : 'q' // NOTE: always promote to a queen for example simplicity
		})

		// illegal move
		if (move === null)
			return 'snapback'

			// highlight moves
		removeHighlights('white')
		$board.find('.square-' + source).addClass('highlight-white')
		$board.find('.square-' + target).addClass('highlight-white')

		updateStatus()

	}

	function onMouseoverSquare(square, piece) {
		// get list of possible moves for this square
		var moves = game.moves({
			square : square,
			verbose : true
		})

		// exit if there are no moves available for this square
		if (moves.length === 0)
			return
			
 // highlight the square they moused over
		greySquare(square)

		// highlight the possible squares for this piece
		for (var i = 0; i < moves.length; i++) {
			greySquare(moves[i].to)
		}
	}

	function onMouseoutSquare(square, piece) {
		removeGreySquares()
	}

	// update the board position after the piece snap
	// for castling, en passant, pawn promotion
	function onSnapEnd(source, target, piece) {

		console.log(piece + " Hello")

		var boardPosition = {
			fen : game.fen()
		}

		$.ajax({
			url : CONTEXT_PATH + "/play/live_chess/board_insert" + "?game_id="
					+ GAME_ID,
			type : "POST",
			data : JSON.stringify(boardPosition),
			dataType : "json",
			contentType : "application/json; charset=utf-8",
			success : function(data) {
			}
		});

		var move = {
			moveNotationFrom : source,
			moveNotationTo : target,
			piece : piece
		}

		if (game.turn() === "b") {

			$.ajax({
				url : CONTEXT_PATH + "/play/live_chess/move_insert"
						+ "?game_id=" + GAME_ID + "&player_id="
						+ WHITE_PLAYER_ID,
				type : "POST",
				data : JSON.stringify(move),
				dataType : "json",
				contentType : "application/json; charset=utf-8",
				success : function(data) {

				}
			});

		} else {
			$.ajax({
				url : CONTEXT_PATH + "/play/live_chess/move_insert"
						+ "?game_id=" + GAME_ID + "&player_id="
						+ BLACK_PLAYER_ID,
				type : "POST",
				data : JSON.stringify(move),
				dataType : "json",
				contentType : "application/json; charset=utf-8",
				success : function(data) {

				}
			});
		}

		board.position(game.fen())

	}

	function onMoveEnd() {
		$board.find('.square-' + squareToHighlight).addClass('highlight-white')
	}

	function updateStatus() {
		var status = ''

		var moveColor = 'White'
		if (game.turn() === 'b') {
			moveColor = 'Black'
		}

		// checkmate?
		if (game.in_checkmate()) {
			status = 'Game over, ' + moveColor + ' is in checkmate.'
		}

		// draw?
		else if (game.in_draw()) {
			status = 'Game over, drawn position'
		}

		// game still on
		else {
			status = moveColor + ' to move'

			// check?
			if (game.in_check()) {
				status += ', ' + moveColor + ' is in check'
			}
		}

		$status.html(status)
		$fen.html(game.fen())
		$pgn.html(game.pgn())

	}

	var config = {
		draggable : true,
		position : 'start',
		pieceTheme : '${contextPath}/resources/img/chesspieces/wikipedia/{piece}.png',
		onDragStart : onDragStart,
		onDrop : onDrop,
		onMoveEnd : onMoveEnd,
		onMouseoutSquare : onMouseoutSquare,
		onMouseoverSquare : onMouseoverSquare,
		onSnapEnd : onSnapEnd
	}

	board = Chessboard('myBoard', config)

	updateStatus()
</script>

<script>
	var latestId = '${newestBoardId}'; //null
	var periodicFunction = function() {
		$.get("${pagesLiveChess}/lastId?game_id=" + GAME_ID, function(
				lastIdFromServer) {

			if (latestId < lastIdFromServer) {
				$.get("${pagesLiveChess}/lastFen?game_id=" + GAME_ID, function(
						lastFenFromServer) {
					game.load(lastFenFromServer); // fen from latest board here
					board.position(game.fen());
					game.setTurn(game.turn());
					updateStatus();

				})
				latestId = lastIdFromServer;

			}

		})

	};
	var timer = setInterval(periodicFunction, 2 * 1000);
</script>
