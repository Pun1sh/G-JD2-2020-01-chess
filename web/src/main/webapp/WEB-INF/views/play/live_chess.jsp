<div class="container">
	<br> <br>
	<div class="row">
		<div class="col s12 l6 pull-l3 ">
			<div id="myBoard" style="width: 600px"></div>
		</div>
	</div>

</div>


<script>
	var config = {
		pieceTheme: '${contextPath}/resources/img/chesspieces/wikipedia/{piece}.png',
		position : 'start'
	}
	var board = Chessboard('myBoard', config)
</script>
