<style type="text/css">
.highlight-white {
	box-shadow: inset 0 0 3px 3px yellow;
}

.highlight-black {
	box-shadow: inset 0 0 3px 3px blue;
}
</style>


<div class="container">
	<br><br>
	<div class="row">
		<div class="col s12 l6 pull-l4 ">
			<div id="myBoard" style="width: 600px"></div>
		</div>
			<div class="col s12 l3">
		  		<div class="card">
   			 	<div class="card-content">
          			<div id="clock-black"></div>
       		</div>
          	</div>
          	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
          	<div class="card">
   			 	<div class="card-content">
         			 <div id="clock-white"></div>
       		</div>
          	</div>
          	</div>
        
		<div class="col s12 l3 push-l1 ">
			<label>Status:</label>
			<div id="status"></div>
			<label>PGN:</label>
			<div id="pgn"></div>
		</div>

	</div>

</div>

<script type="text/javascript">
	GAME_ID = "${gameId}"
	WHITE_PLAYER_ID = "${whitePlayerId}"
	BLACK_PLAYER_ID = "${blackPlayerId}"
	LOGGED_USER_ID="${userId}"
	MODE = "${mode}"
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
	var time = new Date().getTime() + MODE*1000*60;

	/* function removeHighlights(color) {
		$board.find('.' + squareClass).removeClass('highlight-' + color)
	} */
	
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
		
		if ((game.turn()==="b" && LOGGED_USER_ID === WHITE_PLAYER_ID)
		|| (game.turn()==="w" && LOGGED_USER_ID === BLACK_PLAYER_ID)){
			return false
	
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

		/* 	// highlight moves
		removeHighlights('white')
		$board.find('.square-' + source).addClass('highlight-white')
		$board.find('.square-' + target).addClass('highlight-white') */
		
		
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
			
			if ((game.turn()==="w" && LOGGED_USER_ID === WHITE_PLAYER_ID)
					|| (game.turn()==="b" && LOGGED_USER_ID === BLACK_PLAYER_ID)){
				 // highlight the square they moused over
				greySquare(square)

				// highlight the possible squares for this piece
				for (var i = 0; i < moves.length; i++) {
					greySquare(moves[i].to)
				}		
				
						}
			
	}

	function onMouseoutSquare(square, piece) {
		removeGreySquares()
	}

	// update the board position after the piece snap
	// for castling, en passant, pawn promotion
	function onSnapEnd(source, target, piece) {

		var boardPosition = {
			fen : game.fen()
		}

		$.ajax({
			url : CONTEXT_PATH + "/play/live_chess/board_insert" + "?game_id="+ GAME_ID,
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
				url : CONTEXT_PATH + "/play/live_chess/move_insert" + "?game_id=" + GAME_ID + "&player_id="+ WHITE_PLAYER_ID,
				type : "POST",
				data : JSON.stringify(move),
				dataType : "json",
				contentType : "application/json; charset=utf-8",
				success : function(data) {

				}
			});

		} else {
			$.ajax({
				url : CONTEXT_PATH + "/play/live_chess/move_insert" + "?game_id=" + GAME_ID + "&player_id="+ BLACK_PLAYER_ID,
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
		
		if (game.in_checkmate()){
			alert("Game over. You are checkmated.");
			window.location = CONTEXT_PATH+"/game";
		}
		 if (game.in_draw()){
			alert("Game over. Draw position.");
			window.location = CONTEXT_PATH+"/game";
		 }
		
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

		if(game.turn()==="b") {
			$('#clock-black').countdown('resume');
			$('#clock-white').countdown('pause');
		}
		if (game.turn()==="w") {
			$('#clock-white').countdown('resume');
			$('#clock-black').countdown('pause');
		}
		
		$status.html(status)
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
	
	$('#clock-white').countdown(time).on('update.countdown', function(event) {
			  var $this = $(this).html(event.strftime('To end: <span>%H:%M:%S</span>'));
					}).on('finish.countdown',function(){
				$.ajax({
					url : CONTEXT_PATH + "/play/game_over_with_result" + "?game_id=" + GAME_ID + "&winner_id="+ BLACK_PLAYER_ID
							+"&loser_id="+WHITE_PLAYER_ID,
					type : "POST",
					success : function() {
						if(LOGGED_USER_ID===WHITE_PLAYER_ID){
							alert("Game over. You lost by time.");
							window.location = CONTEXT_PATH+"/game";
						} else {
							alert("Game over. You win by time.");
							window.location = CONTEXT_PATH+"/game";
						}
					}
				});
			}).countdown('pause');
			

		$('#clock-black').countdown(time).on('update.countdown', function(event) {
			  	var $this = $(this).html(event.strftime('To end: <span>%H:%M:%S</span>'));
					}).on('finish.countdown',function(){
				$.ajax({
					url : CONTEXT_PATH + "/play/game_over_with_result" + "?game_id=" + GAME_ID + "&winner_id="+ WHITE_PLAYER_ID
							+"&loser_id="+BLACK_PLAYER_ID,
					type : "POST",
					success : function() {
						if(LOGGED_USER_ID === BLACK_PLAYER_ID){
							alert("Game over. You lost by time.");
							window.location = CONTEXT_PATH+"/game";	
						} else {
							alert("Game over. You win by time.");
							window.location = CONTEXT_PATH+"/game";
						}
					}
				});
			}).countdown('pause').countdown('resume');

		
	updateStatus()

</script>

<script>
	var latestId = '${newestBoardId}'; //null
/* 	var foo = function(){
		$.get("${pagesLiveChess}/last_board?game_id=" + GAME_ID,function(currentBoardPos){
			if(!board.fen().equals(currentBoardPos.fen)){
				game.load(currentBoardPos.fen);
				board.position(currentBoardPos.fen);
			}
		})
	}	 */
	
	var periodicFunction = function() {
		$.get("${pagesLiveChess}/last_id?game_id=" + GAME_ID, function(lastIdFromServer) {

			if (latestId < lastIdFromServer) {
				$.get("${pagesLiveChess}/last_move?game_id=" + GAME_ID, function(lastMoveFromServer) {
					game.move({
						from : lastMoveFromServer.moveNotationFrom,
						to : lastMoveFromServer.moveNotationTo,
						promotion : 'q' // NOTE: always promote to a queen for example simplicity
					})
					board.position(game.fen());
					updateStatus();				
					
					
				})
				
				latestId = lastIdFromServer;

				if (game.in_checkmate()) {
					if(game.turn()==="b"){
						$.ajax({
							url : CONTEXT_PATH + "/play/game_over_with_result" + "?game_id=" + GAME_ID + "&winner_id="+ WHITE_PLAYER_ID
									+"&loser_id="+BLACK_PLAYER_ID,
							type : "POST",
							success : function() {
								alert("Game over. You win.");
								window.location = CONTEXT_PATH+"/game";
							}
						});	
					} else {
						$.ajax({
							url : CONTEXT_PATH + "/play/game_over_with_result" + "?game_id=" + GAME_ID + "&winner_id="+ BLACK_PLAYER_ID
									+"&loser_id="+WHITE_PLAYER_ID,
							type : "POST",
							success : function() {
								alert("Game over. You win.");
								window.location = CONTEXT_PATH+"/game";
							}
						});
					}
				}

				// draw?
				 if (game.in_draw()) {
						$.ajax({
							url : CONTEXT_PATH + "/play/game_over_without_result" + "?game_id=" + GAME_ID + "&white_player_id="+ WHITE_PLAYER_ID
							+"&black_player_id="+BLACK_PLAYER_ID,
							type : "POST",
							success : function() {
								alert("Game over. Draw Position.");
								window.location = CONTEXT_PATH+"/game";
							}
						});
				}
				
				

			}

		})

	};
	var timer = setInterval(periodicFunction, 2 * 1000);	
</script>


