<div class="container">
	<br> <br>
	<div class="row">
		<div class="col s12 l6 pull-l3 ">
			<div id="myBoard" style="width: 600px"></div>
		</div>
	</div>

</div>


<script>
	var board = Chessboard('myBoard', 'start')
	var chess = new Chess()
	chess.move('e4')
	chess.move('e5')
	chess.move('f4')
	console.log(chess.ascii())
</script>
		var callback = function(data) {
			
		};
		$.get(CONTEXT_PATH + "/play/live_chess?fen="+game.fen(), callback);
