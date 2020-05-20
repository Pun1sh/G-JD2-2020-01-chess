<br>
<br>
<br>
<div class="row">
	<div class="col s6 m6 push-l3">
		<div class="card">
			<div class="card-image">
				<img
					src="https://images.wallpaperscraft.ru/image/shahmaty_peshka_koroleva_125673_1920x1080.jpg">
				<span class="card-title">Please wait.</span>

			</div>
			<div class="card-content">
				<p>You are in a queue. Waiting till someone choose you to play
					with. Please don't leave this page.</p>
				<br>
				<div class="row center-align">
					<div class="preloader-wrapper big active">
						<div class="spinner-layer spinner-blue-only">
							<div class="circle-clipper left">
								<div class="circle"></div>
							</div>
							<div class="gap-patch">
								<div class="circle"></div>
							</div>
							<div class="circle-clipper right">
								<div class="circle"></div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>

<script type="text/javascript">
	LOGGED_USER_ID = "${loggedUserId}"
</script>

<script>
	var latestId = "${gameId}";
	var periodicFunction = function() {
		$.get("${pagesQueue}/stay_in_queue?player_id=" + LOGGED_USER_ID);

		$.get("${pagesQueue}/check_id?player_id=" + LOGGED_USER_ID, function(lastIdFromServer) {

			if (latestId < lastIdFromServer) {
				
				$.get("${pagesQueue}/get_game?game_id=" + lastIdFromServer, function(game) {
					window.location = CONTEXT_PATH+"/play/live_chess?white_player_id=" 
							+ game.whitePlayerId + "&black_player_id=" 
							+game.blackPlayerId
					+ "&game_id=" + game.id+"&mode="+game.mode;

				})
			
			}

		})

	};
	var timer = setInterval(periodicFunction, 1 * 1000);
</script>