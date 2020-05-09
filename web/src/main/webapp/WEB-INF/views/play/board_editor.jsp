
<div class="container">

	<div class="row">
		<div class="col s12 l6 pull-l2">
		<br>
			<div id="board2" style="width: 500px"></div>
		</div>
		<div class="col s12 l6 push-l2">
			<br> <a class="btn" id=startPosition>Start Position</a> <a
				class="btn" id=clear>Clear board</a><br> <br> <a
				class="btn" id=flip>Flip board</a> <br> <br>
			<div class="input-field col s12">
				<select id="list">
					<option value="" disabled selected>Here you can choose popular openings</option>
					<option value="1">B02 Alekhine's Defence</option>
					<option value="2">B04 Alekhine's Defence: Modern Variation</option>
					<option value="3">B10 Caro-Kann Defence</option>
					<option value="4">B12 Caro-Kann Defence: Advance Variation</option>
					<option value="5">B18 Caro-Kann Defence: Classical Variation</option>
					<option value="6">B13 Caro-Kann Defence: Exchange Variation</option>
					<option value="7">B14 Caro-Kann Defence: Panov-Botvinnik Attack</option>
					<option value="8">C46 Four Knights Game</option>
					<option value="9">C47 Four Knights Game: Scotch Variation</option>
					<option value="10">C48 Four Knights Game: Spanish Variation</option>
					<option value="11">C00 French Defence</option>
					<option value="12">C02 French Defence: Advance Variation</option>
					<option value="13">C11 French Defence: Burn Variation</option>
					<option value="14">C11 French Defence: Classical Variation</option>
					<option value="15">C01 French Defence: Exchange Variation</option>
					<option value="16">C10 French Defence: Rubinstein Variation</option>
					<option value="17">C03 French Defence: Tarrasch Variation</option>
					<option value="18">C15 French Defence: Winawer Variation</option>
					<option value="19">C50 Italian Game</option>
					<option value="20">C51 Evans Gambit</option>
					<option value="21">C55 Italian Game: Two Knights Defence</option>
					<option value="22">C30 King's Gambit</option>
					<option value="23">C33 King's Gambit Accepted</option>
					<option value="24">C33 King's Gambit Accepted: Bishop's Gambit</option>
					<option value="25">C36 King's Gambit Accepted: Modern Defence</option>
					<option value="26">C30 King's Gambit Accepted: Classical Variation</option>
					<option value="27">C30 King's Gambit Declined: Classical Variation</option>
					<option value="28">C31 King's Gambit: Falkbeer CounterGambit</option>
				</select> <label>Openings</label>
			</div>
			
			<div class="input-field col s12">
				<textarea id="FEN" class="materialize-textarea"></textarea>
				<label for="FEN">Paste your FEN here</label>
			</div>
			<a class="btn" id=pasteFEN>Change Position using your FEN</a> <br><br>
			<a class="btn" id=getFEN>Get current FEN</a>
			
			<div class="col s12"> <br>
			<div id="fen"></div>
			</div>
			
		</div>
	</div>



</div>


<script>
	var $fen = $('#fen')
	var game = new Chess()
	var board2 = Chessboard(
			'board2',
			{
				pieceTheme : '${contextPath}/resources/img/chesspieces/wikipedia/{piece}.png',
				draggable : true,
				dropOffBoard : 'trash',
				sparePieces : true
			})
	
			
	

	$('select').formSelect();
	$('#startPosition').on('click', board2.start)
	$('#clear').on('click', board2.clear)
	$('#flip').on('click', board2.flip)

	$('#pasteFEN').on('click', function() {
		board2.position(document.getElementById("FEN").value)

	})
	$('#getFEN').on('click', function() {
		$fen.html(board2.fen())

	})
	$('#list')
			.change(
					function() {
						if ($(this).val() === '1') {
							board2
									.position('rnbqkb1r/pppppppp/5n2/8/4P3/8/PPPP1PPP/RNBQKBNR w KQkq - 2 2')
						}
						if ($(this).val() === '2') {
							board2
									.position('rnbqkb1r/ppp1pppp/3p4/3nP3/3P4/5N2/PPP2PPP/RNBQKB1R b KQkq - 1 4')
						}
						if ($(this).val() === '3') {
							board2
									.position('rnbqkbnr/pp1ppppp/2p5/8/4P3/8/PPPP1PPP/RNBQKBNR w KQkq - 1 2')
						}
						if ($(this).val() === '4') {
							board2
									.position('rnbqkbnr/pp2pppp/2p5/3pP3/3P4/8/PPP2PPP/RNBQKBNR b KQkq - 1 3')
						}
						if ($(this).val() === '5') {
							board2
									.position('rn1qkbnr/pp2pppp/2p5/5b2/3PN3/8/PPP2PPP/R1BQKBNR w KQkq - 2 5')
						}
						if ($(this).val() === '6') {
							board2
									.position('rnbqkbnr/pp2pppp/2p5/3P4/3P4/8/PPP2PPP/RNBQKBNR b KQkq - 1 3')
						}
						if ($(this).val() === '7') {
							board2
									.position('rnbqkb1r/pp3ppp/4pn2/3p4/2PP4/2N5/PP3PPP/R1BQKBNR w KQkq - 1 6')
						}
						if ($(this).val() === '8') {
							board2
									.position('r1bqkb1r/pppp1ppp/2n2n2/4p3/4P3/2N2N2/PPPP1PPP/R1BQKB1R w KQkq - 5 4')
						}
						if ($(this).val() === '9') {
							board2
									.position('r1bqkb1r/pppp1ppp/2n2n2/4p3/3PP3/2N2N2/PPP2PPP/R1BQKB1R b KQkq d3 1 4')
						}
						if ($(this).val() === '10') {
							board2
									.position('r1bqkb1r/pppp1ppp/2n2n2/1B2p3/4P3/2N2N2/PPPP1PPP/R1BQK2R b KQkq - 0 4')
						}
						if ($(this).val() === '11') {
							board2
									.position('rnbqkbnr/pppp1ppp/4p3/8/4P3/8/PPPP1PPP/RNBQKBNR w KQkq - 1 2')
						}
						if ($(this).val() === '12') {
							board2
									.position('rnbqkbnr/ppp2ppp/4p3/3pP3/3P4/8/PPP2PPP/RNBQKBNR b KQkq - 1 3')
						}
						if ($(this).val() === '13') {
							board2
									.position('rnbqkb1r/ppp2ppp/4pn2/3p2B1/3PP3/2N5/PPP2PPP/R2QKBNR b KQkq - 1 4')
						}
						if ($(this).val() === '14') {
							board2
									.position('rnbqkb1r/ppp2ppp/4pn2/3p4/3PP3/2N5/PPP2PPP/R1BQKBNR w KQkq - 3 4')
						}
						if ($(this).val() === '15') {
							board2
									.position('rnbqkbnr/ppp2ppp/4p3/3P4/3P4/8/PPP2PPP/RNBQKBNR b KQkq - 1 3')
						}
						if ($(this).val() === '16') {
							board2
									.position('rnbqkbnr/ppp2ppp/4p3/8/3Pp3/2N5/PPP2PPP/R1BQKBNR w KQkq - 1 4')
						}
						if ($(this).val() === '17') {
							board2
									.position('rnbqkbnr/ppp2ppp/4p3/3p4/3PP3/8/PPPN1PPP/R1BQKBNR b KQkq - 2 3')
						}
						if ($(this).val() === '18') {
							board2
									.position('rnbqk1nr/ppp2ppp/4p3/3p4/1b1PP3/2N5/PPP2PPP/R1BQKBNR w KQkq - 3 4')
						}
						if ($(this).val() === '19') {
							board2
									.position('r1bqkbnr/pppp1ppp/2n5/4p3/2B1P3/5N2/PPPP1PPP/RNBQK2R b KQkq - 4 3')
						}
						if ($(this).val() === '20') {
							board2
									.position('r1bqk1nr/pppp1ppp/2n5/2b1p3/1PB1P3/5N2/P1PP1PPP/RNBQK2R b KQkq b3 1 4')
						}
						if ($(this).val() === '21') {
							board2
									.position('r1bqkb1r/pppp1ppp/2n2n2/4p3/2B1P3/5N2/PPPP1PPP/RNBQK2R w KQkq - 5 4')
						}
						if ($(this).val() === '22') {
							board2
									.position('rnbqkbnr/pppp1ppp/8/4p3/4PP2/8/PPPP2PP/RNBQKBNR b KQkq f3 1 2')
						}
						if ($(this).val() === '23') {
							board2
									.position('rnbqkbnr/pppp1ppp/8/8/4Pp2/8/PPPP2PP/RNBQKBNR w KQkq - 1 3')
						}
						if ($(this).val() === '24') {
							board2
									.position('rnbqkbnr/pppp1ppp/8/8/2B1Pp2/8/PPPP2PP/RNBQK1NR b KQkq - 2 3')
						}
						if ($(this).val() === '25') {
							board2
									.position('rnbqkbnr/ppp2ppp/8/3p4/4Pp2/5N2/PPPP2PP/RNBQKB1R w KQkq d6 1 4')
						}
						if ($(this).val() === '26') {
							board2
									.position('rnbqkbnr/pppp1p1p/8/6p1/4Pp2/5N2/PPPP2PP/RNBQKB1R w KQkq - 0 4')
						}
						if ($(this).val() === '27') {
							board2
									.position('rnbqk1nr/pppp1ppp/8/2b1p3/4PP2/8/PPPP2PP/RNBQKBNR w KQkq - 2 3')
						}
						if ($(this).val() === '28') {
							board2
									.position('rnbqkbnr/ppp2ppp/8/3pp3/4PP2/8/PPPP2PP/RNBQKBNR w KQkq d6 1 3')
						}

					});
</script>