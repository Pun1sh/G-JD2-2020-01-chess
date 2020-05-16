<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
				<sec:authorize access="!isAnonymous()">
					<li><a class="white-text" href="${pagesWaitingPlayer}"><i
							class="material-icons left white-text">group</i>Waiting players</a></li>
				</sec:authorize>
				<li><a class="white-text" href="${pagesPlayer}"><i
						class="material-icons left white-text">people_outline</i>Players</a></li>
				<li><a class="white-text" href="${pagesGame}"><i
						class="material-icons left white-text">storage</i>Games</a></li>
				<%-- <li><a class="white-text" href="${pagesCountry}">Countries</a></li>
				<li><a class="white-text" href="${pagesClub}">Clubs</a></li>
				<li><a class="white-text" href="${pagesTournament}">Tournaments</a></li>
				<li><a class="white-text" href="${pagesParticipation}">Tournament
						results</a></li> --%>
				<sec:authorize access="isAnonymous()">
					<li><a class="white-text" href="${pagesLogin}"><i
							class="material-icons left white-text">forward</i>Log In</a></li>
				</sec:authorize>

				<sec:authorize access="!isAnonymous()">
					<a class="right" href="${contextPath}/execute_logout"
						title="logout"><i class="material-icons">arrow_forward</i></a>
				</sec:authorize>

				<li><a href="?lang=ru">RU</a></li>
				<li><a href="?lang=en">EN</a></li>

			</ul>


			<ul class="sidenav grey lighten-2" id="mobile-menu">
				<li><a class="white-text" href="${pagesQueue}"><i
						class="material-icons left white-text">play_circle_outline</i>Get
						in Line</a></li>
				<sec:authorize access="!isAnonymous()">
					<li><a class="white-text" href="${pagesWaitingPlayer}"><i
							class="material-icons left white-text">group</i>Waiting players</a></li>
				</sec:authorize>
				<li><a class="white-text" href="${pagesPlayer}"><i
						class="material-icons left white-text ">people_outline</i>Players</a></li>
				<li><a class="white-text" href="${pagesGame}"><i
						class="material-icons left white-text ">storage</i>Games</a></li>
				<%-- <li><a class="white-text" href="${pagesCountry}">Countries</a></li>
				<li><a class="white-text" href="${pagesClub}">Clubs</a></li>
				<li><a class="white-text" href="${pagesTournament}">Tournaments</a></li>
				<li><a class="white-text" href="${pagesParticipation}">Tournament
						results</a></li> --%>
			</ul>

		</div>
		<ul class='dropdown-content brown lighten-2' id='mydropdown'>
			<li><a class="white-text" href="${pageQueue}"><i
					class="fas fa-chess"></i>Get In Line to Play Live Chess</a></li>
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