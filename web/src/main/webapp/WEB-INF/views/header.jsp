<header>
	<nav class="nav-wrapper brown lighten-2">
		<div class="container">
			<a href="${contextPath}" class="brand-logo">Pure Chess</a> <a
				href="#" class="sidenav-trigger" data-target="mobile-menu"> <i
				class="material-icons">menu</i>
			</a>

			<ul class="right hide-on-med-and-down">
				<li><a class='dropdown-trigger btn transparent' href='#'
					data-target='mydropdown'><i class="material-icons left">play_circle_outline</i>Play</a></li>
				<li><a class="white-text" href="${pagesPlayer}"><i
						class="material-icons left white-text">people_outline</i>Players</a></li>
				<li><a class="white-text" href="${pagesGame}"><i
						class="material-icons left white-text">storage</i>Games</a></li>
				<li><a class="white-text" href="${pagesCountry}">Countries</a></li>
				<li><a class="white-text" href="${pagesClub}">Clubs</a></li>
				<li><a class="white-text" href="${pagesTournament}">Tournaments</a></li>
				<li><a class="white-text" href="${pagesParticipation}">Tournament
						results</a></li>
			</ul>
			<ul class="sidenav grey lighten-2" id="mobile-menu">
				<li><a class="white-text" href="${pagesLiveChess}"><i
						class="material-icons left white-text">play_circle_outline</i>Play</a></li>
				<li><a class="white-text" href="${pagesPlayer}"><i
						class="material-icons left white-text ">people_outline</i>Players</a></li>
				<li><a class="white-text" href="${pagesGame}"><i
						class="material-icons left white-text ">storage</i>Games</a></li>
				<li><a class="white-text" href="${pagesCountry}">Countries</a></li>
				<li><a class="white-text" href="${pagesClub}">Clubs</a></li>
				<li><a class="white-text" href="${pagesTournament}">Tournaments</a></li>
				<li><a class="white-text" href="${pagesParticipation}">Tournament
						results</a></li>
			</ul>

		</div>
		<ul class='dropdown-content brown lighten-2' id='mydropdown'>
			<li><a class="white-text" href="${pagesLiveChess}"><i
					class="fas fa-chess"></i>Live Chess</a></li>
			<li><a class="white-text" href="${pagesBoardEditor}"><i
					class="fas fa-chess-board"></i>Board editor</a></li>
			<li><a class="white-text" href="${pagesRandomComputer}"><i
					class="material-icons left">computer</i>Play against Random
					Computer</a></li>
		</ul>
	</nav>

	<script>
		$(document).ready(function() {
			$('.sidenav').sidenav();
			$('.dropdown-trigger').dropdown();

		});
	</script>
</header>