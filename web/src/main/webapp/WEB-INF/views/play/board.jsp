<div id="myBoard" style="width: 600px"></div>


<script>
var board = Chessboard('myBoard', 'start')
var chess = new Chess()
chess.move('e4')
chess.move('e5')
chess.move('f4')
console.log(chess.ascii())


</script>
