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
					<li><a class="white-text" href="#modes"><i
							class="material-icons left white-text">extension</i>Modes</a></li>
					<li><a class="white-text" href="#sign-up"><i
							class="material-icons left white-text">assignment_ind</i>Sign Up</a></li>
					<li><a class="white-text" href="#"><i
							class="material-icons left white-text">forward</i>Log In</a></li>
				</ul>
				<ul class="sidenav grey lighten-2" id="mobile-menu">
					<li><a class="white-text" href="${pagesPlay}"><i
							class="material-icons left white-text ">play_circle_outline</i>Play</a></li>
					<li><a class="white-text" href="${pagesPlayer}"><i
							class="material-icons left white-text ">people_outline</i>Players</a></li>
					<li><a class="white-text" href="${pagesGame}"><i
							class="material-icons left white-text ">storage</i>Games</a></li>
					<li><a class="white-text" href="#modes"><i
							class="material-icons left white-text">extension</i>Modes</a></li>
					<li><a class="white-text" href="#sign-up"><i
							class="material-icons left white-text">assignment_ind</i>Sign Up</a></li>
					<li><a class="white-text" href="#"><i
							class="material-icons left white-text">forward</i>Log In</a></li>
				</ul>


			</div>

		</nav>


	</header>
	<!-- photo / grid -->
	<section class="container section scrollspy" id="modes">

		<div class="row">
			<div class="col s12 l4">
				<img src="https://www.newsli.ru/up_img/jpg_1895.jpg" alt=""
					class="responsive-img">
			</div>
			<div class="col s12 l6 offset-l1">
				<h2 class="indigo-text text-darken-4">Bullet</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Vestibulum at lacus congue, suscipit elit nec, tincidunt orci.</p>
			</div>
		</div>
		<div class="row">
			<div class="col s12 l4 push-l7 ofsset-l1">
				<img
					src="https://cdn.pixabay.com/photo/2014/09/01/19/39/chess-433071_1280.jpg"
					alt="" class="responsive-img">
			</div>
			<div class="col s12 l6 offset-l1 pull-l5 right-align">
				<h2 class="indigo-text text-darken-4">Blitz</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Vestibulum at lacus congue, suscipit elit nec, tincidunt orci.</p>
			</div>
		</div>
		<div class="row">
			<div class="col s12 l4">
				<img
					src="https://www.azerisport.com/images/articles/2019/04/08/thumb700_20190408200801853.jpg"
					alt="" class="responsive-img">
			</div>
			<div class="col s12 l6 offset-l1">
				<h2 class="indigo-text text-darken-4">10, 30 and 60 Minutes</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Vestibulum at lacus congue, suscipit elit nec, tincidunt orci.</p>
			</div>
		</div>

	</section>


	<!-- parallax -->
	<div class="parallax-container">
		<div class="parallax">
			<img src="https://images5.alphacoders.com/381/thumb-1920-381340.jpg"
				alt="" class="responsive-img">
		</div>
	</div>
	<!-- sign up form -->
	<section class="section container scrollspy" id="sign-up">
		<div class="row">
			<div class="col s12 l5">
				<h2 class="indigo-text text-darken-4">Sign up!</h2>
				<p>Join us and enjoy playing chess. Sign up, it's Free!</p>
				<p>If you are already signed up, just Log In.</p>
				<ul>
					<li><a class="btn" href="#"><i
							class="material-icons left white-text">forward</i>Log In</a></li>
				</ul>
			</div>
			<div class="col s12 l5 offset-l2">
				<form>
					<div class="input-field">
						<i class="material-icons prefix">email</i> <input type="email"
							id="email"> <label for="email">Your Email</label>
					</div>
					<div class="input-field">
						<i class="material-icons prefix">lock</i>
						<textarea id="password" class="materialize-textarea"></textarea>
						<label for="password">Your Password</label>
					</div>
					<div class="input-field">
						<i class="material-icons prefix">person_add</i>
						<textarea id="nickname" class="materialize-textarea"></textarea>
						<label for="nickname">Your Nickname</label>
					</div>
					<div class="input-field">
						<i class="material-icons prefix">date_range</i> <input type="text"
							id="date" class="datepicker"> <label for="date">Your
							BirthDate</label>
					</div>
					<div class="input-field center">
						<button class="btn">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</section>
	<!-- footer -->
	<footer class="page-footer grey darken-3">
		<div class="container">
			<div class="row">
				<div class="col l6 s12">
					<h5>About Site</h5>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Vestibulum at lacus congue.</p>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Vestibulum at lacus congue, suscipit elit nec, tincidunt orci.</p>
				</div>
				<div class="col l4 offset-l2 s12">
					<h5 class="white-text">Connect</h5>
					<ul>
						<li><a class="grey-text text-lighten-3" href="#">Facebook</a></li>
						<li><a class="grey-text text-lighten-3" href="#">Twitter</a></li>
						<li><a class="grey-text text-lighten-3" href="#">Linked
								In</a></li>
						<li><a class="grey-text text-lighten-3" href="#">Instagram</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="footer-copyright grey darken-4">
			<div class="container center-align">&copy; 2020 Pure Chess</div>
		</div>
	</footer>

	<!-- Compiled and minified JavaScript -->
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
	<script>
		$(document).ready(function() {
			$('.sidenav').sidenav();
			$('.parallax').parallax();
			$('.datepicker').datepicker();
			$('.scrollspy').scrollSpy();

		});
	</script>
</body>
</html>