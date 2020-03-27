<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"
	scope="request" />
<c:set var="pagesCountry" value="${contextPath}/country" scope="request" />
<c:set var="pagesPlayer" value="${contextPath}/player" scope="request" />
<c:set var="pagesClub" value="${contextPath}/club" scope="request" />
<c:set var="pagesGame" value="${contextPath}/game" scope="request" />
<c:set var="pagesTournament" value="${contextPath}/tournament"
	scope="request" />
<c:set var="pagesParticipation" value="${contextPath}/participation"
	scope="request" />
<c:set var="pagesPlay" value="${contextPath}/play" scope="request" />

<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<!-- font awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
	integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
	crossorigin="anonymous">
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
<title>Chess</title>
<style>
header {
	background: url(https://images8.alphacoders.com/460/460230.png);
	background-size: cover;
	background-position: center;
	min-height: 1000px;
}

@media screen and (max-width:670px) {
	header {
		min-height: 500px;
	}
}

.section {
	padding-top: 4vw;
	padding-bottom: 4vw;
}
</style>
</head>
<body>

	<!-- navbar -->
	<header>
		<nav class="nav-wrapper transparent">
			<div class="container">
				<a href="${contextPath}" class="brand-logo">Pure Chess</a> <a
					href="#" class="sidenav-trigger" data-target="mobile-menu"> <i
					class="material-icons">menu</i>
				</a>
				<ul class="right hide-on-med-and-down">

					<li><a class="white-text" href="${pagesPlay}"><i
							class="material-icons left white-text">play_circle_outline</i>Play</a></li>
					<li><a class="white-text" href="${pagesPlayer}"><i
							class="material-icons left white-text">people_outline</i>Players</a></li>
					<li><a class="white-text" href="${pagesGame}"><i
							class="material-icons left white-text">storage</i>Games</a></li>
				</ul>
				<ul class="sidenav grey lighten-2" id="mobile-menu">
					<li><a class="white-text" href="${pagesPlay}"><i
							class="material-icons left white-text ">play_circle_outline</i>Play</a></li>
					<li><a class="white-text" href="${pagesPlayer}"><i
							class="material-icons left white-text ">people_outline</i>Players</a></li>
					<li><a class="white-text" href="${pagesGame}"><i
							class="material-icons left white-text ">storage</i>Games</a></li>
				</ul>


			</div>

		</nav>


	</header>
	<!-- photo / grid -->
	<section class="container section" id="photos">
		<div class="row">
			<div class="col s12 l4">
				<img src="img/portrait.jpg" alt=""
					class="responsive-img materialboxed">
			</div>
			<div class="col s12 l6 offset-l1">
				<h2 class="indigo-text text-darken-4">Bullet</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Vestibulum at lacus congue, suscipit elit nec, tincidunt orci.</p>
			</div>
		</div>
		<div class="row">
			<div class="col s12 l4 push-l7 ofsset-l1">
				<img src="img/city.jpg" alt="" class="responsive-img materialboxed">
			</div>
			<div class="col s12 l6 offset-l1 pull-l5 right-align">
				<h2 class="indigo-text text-darken-4">Blitz</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Vestibulum at lacus congue, suscipit elit nec, tincidunt orci.</p>
			</div>
		</div>
		<div class="row">
			<div class="col s12 l4">
				<img src="img/portrait.jpg" alt=""
					class="responsive-img materialboxed">
			</div>
			<div class="col s12 l6 offset-l1">
				<h2 class="indigo-text text-darken-4">10, 30 and 60 Minutes</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Vestibulum at lacus congue, suscipit elit nec, tincidunt orci.</p>
			</div>
		</div>





	</section>

	<!-- parallax -->

	<!-- services / tabs -->

	<!-- parallax -->

	<!-- contact form -->

	<!-- footer -->

	<!-- Compiled and minified JavaScript -->
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
	<script>
		$(document).ready(function() {
			$('.sidenav').sidenav();
			$('.materialboxed').materialbox();
		});
	</script>
</body>
</html>