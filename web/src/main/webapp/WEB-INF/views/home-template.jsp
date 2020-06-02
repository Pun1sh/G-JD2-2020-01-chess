<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
<c:set var="pagesLiveChess" value="${contextPath}/play/live_chess"
	scope="request" />
<c:set var="pagesBoardEditor" value="${contextPath}/play/board_editor"
	scope="request" />
<c:set var="pagesLogin" value="${contextPath}/login" scope="request" />
<c:set var="pagesSignUp" value="${contextPath}/sign_up" scope="request" />
<c:set var="pagesQueue" value="${contextPath}/play/queue"
	scope="request" />
<c:set var="pagesWaitingPlayer"
	value="${contextPath}/player/waiting_players" scope="request" />

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
	background-position: left;
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
.tap-target{
border-radius: 200px;
}
nav .brand-logo{
margin-left: 2em;
}
</style>
</head>
<body>

<!-- Tap Target -->
  	<sec:authorize access="!isAnonymous()">
	  <c:if test="${not empty game.id}">
	  		<div class = "fixed-action-btn">
		<a id="warning" class="waves-effect waves-light btn btn-floating red pulse" onclick="$('.tap-target').tapTarget('open')"><i class="material-icons">warning</i></a>
			</div>
	  </c:if>
	</sec:authorize>
	
  <!-- Tap Target Structure -->
  	<div class="tap-target" data-target="warning">
    	<div class="tap-target-content">
    		<div class="row">
    		 	<h5><spring:message code="warning" /></h5>
      			<p><spring:message code="warning.description1" /></p>
      			<p><spring:message code="warning.description2" /></p>
      		</div>
      		<div class="row">
      		<ul>
      		
      		<div class="col s12 l6">
      		<li><a class="btn" href="${contextPath}/play/live_chess?white_player_id=${game.whitePlayerId}&black_player_id=${game.blackPlayerId}&game_id=${game.id}&mode=${game.mode}"><spring:message code="yes" /></a></li>
			</div>
			
			<div class="col s12 l6">
        			<li><a class="btn" id='giveup'><spring:message code="no" /></a></li> 
			</div>		
			</ul>
			</div>
    	</div>
  	</div>
  
	<!-- navbar -->
	<header>
		<nav class="nav-wrapper transparent">
			<!-- <div class="container"> -->
			
				<a href="${contextPath}" class="brand-logo">Pure Chess</a> <a
					href="#" class="sidenav-trigger" data-target="mobile-menu"> <i
					class="material-icons">menu</i>
				</a>

				<ul class="right hide-on-med-and-down">
					<li><a class='dropdown-trigger btn transparent' href='#'
						data-target='mydropdown'><i class="material-icons left">play_circle_outline</i>
							<spring:message code="play" /></a></li>
					<sec:authorize access="!isAnonymous()">
						<li><a class="white-text" href="${pagesWaitingPlayer}"><i
								class="material-icons left white-text">group</i> <spring:message
									code="waiting.players" /></a></li>
					</sec:authorize>
					<li><a class="white-text" href="${pagesPlayer}"><i
							class="material-icons left white-text">people_outline</i> <spring:message
								code="players" /></a></li>
					<li><a class="white-text" href="${pagesGame}"><i
							class="material-icons left white-text">storage</i> <spring:message
								code="games" /></a></li>
					<li><a class="white-text" href="#modes"><i
							class="material-icons left white-text">extension</i> <spring:message
								code="modes" /></a></li>

					<sec:authorize access="isAnonymous()">
						<li><a class="white-text" href="#sign-up"><i
								class="material-icons left white-text">assignment_ind</i> <spring:message
									code="sign.up" /></a></li>
						<li><a class="white-text" href="${pagesLogin}"><i
								class="material-icons left white-text">forward</i> <spring:message
									code="log.in" /></a></li>
					</sec:authorize>

					<sec:authorize access="!isAnonymous()">
						<a class="right" href="${contextPath}/execute_logout"
							title="logout"><i class="material-icons">arrow_forward</i></a>
					</sec:authorize>

					<li><a class='dropdown-trigger btn transparent' href='#'
						data-target='mydropdownlng'><i
							class="material-icons center-align">language</i></a></li>
				</ul>
				<ul class="sidenav grey lighten-2" id="mobile-menu">
					<li><a class="white-text" href="${pagesQueue}"><i
							class="material-icons left white-text">play_circle_outline</i> <spring:message
								code="get.in.line.short" /></a></li>
					<sec:authorize access="!isAnonymous()">
						<li><a class="white-text" href="${pagesWaitingPlayer}"><i
								class="material-icons left white-text">group</i> <spring:message
									code="waiting.players" /></a></li>
					</sec:authorize>
					<li><a class="white-text" href="${pagesPlayer}"><i
							class="material-icons left white-text ">people_outline</i> <spring:message
								code="players" /></a></li>
					<li><a class="white-text" href="${pagesGame}"><i
							class="material-icons left white-text ">storage</i> <spring:message
								code="games" /></a></li>
					<li><a class="white-text" href="#modes"><i
							class="material-icons left white-text">extension</i> <spring:message
								code="modes" /></a></li>

					<sec:authorize access="isAnonymous()">
						<li><a class="white-text" href="#sign-up"><i
								class="material-icons left white-text">assignment_ind</i> <spring:message
									code="sign.up" /></a></li>
						<li><a class="white-text" href="${pagesLogin}"><i
								class="material-icons left white-text">forward</i> <spring:message
									code="log.in" /></a></li>
					</sec:authorize>



					<li><a class="white-text" href="?lang=ru">Ru</a></li>
					<li><a class="white-text" href="?lang=en">En</a></li>

					<sec:authorize access="!isAnonymous()">
						<a class="right" href="${contextPath}/execute_logout"
							title="logout"><i class="material-icons">arrow_forward</i></a>
					</sec:authorize>

				</ul>

			<!-- </div> -->
			<ul class='dropdown-content brown lighten-2' id='mydropdown'>
				<li><a class="white-text" href="${pagesQueue}"><i
						class="fas fa-chess"></i> <spring:message code="get.in.line" /></a></li>
				<li><a class="white-text" href="${pagesBoardEditor}"><i
						class="fas fa-chess-board"></i> <spring:message
							code="board.editor" /></a></li>
			</ul>

			<ul class='dropdown-content brown lighten-2' id='mydropdownlng'>
				<li><a class="white-text" href="?lang=ru">Ru</a></li>
				<li><a class="white-text" href="?lang=en">En</a></li>
			</ul>
		</nav>
		
	<sec:authorize access="!isAnonymous()">
	<div class="row">
		<div class="col s2 offset-s8">
 			<div class="container">
					<div class="card transparent">
   			 			<div class="card-content center-align white-text">
          					<div id="name"><strong><spring:message code="hello"/>, ${loggedUserNickname}</strong></div>
       					</div>
       				</div>
          	</div>
         </div>
     </div>
     </sec:authorize>
          	
	</header>
	<!-- photo / grid -->
	<section class="container section scrollspy" id="modes">

		<div class="row">
			<div class="col s12 l4">
				<img src="https://www.newsli.ru/up_img/jpg_1895.jpg" alt=""
					class="responsive-img">
			</div>
			<div class="col s12 l6 offset-l1">
				<h2 class="indigo-text text-darken-4"><spring:message code="blitz" /></h2>
				<p><spring:message code="blitz.description" /></p>
			</div>
		</div>
		<div class="row">
			<div class="col s12 l4 push-l7 ofsset-l1">
				<img
					src="https://cdn.pixabay.com/photo/2014/09/01/19/39/chess-433071_1280.jpg"
					alt="" class="responsive-img">
			</div>
			<div class="col s12 l6 offset-l1 pull-l5 right-align">
				<h2 class="indigo-text text-darken-4"><spring:message code="10min" /></h2>
				<p><spring:message code="10min.description" /></p>
			</div>
		</div>
		<div class="row">
			<div class="col s12 l4">
				<img
					src="https://www.azerisport.com/images/articles/2019/04/08/thumb700_20190408200801853.jpg"
					alt="" class="responsive-img">
			</div>
			<div class="col s12 l6 offset-l1">
				<h2 class="indigo-text text-darken-4"><spring:message code="30min" />, <spring:message code="60min" /></h2>
				<p><spring:message code="30min.60min.description" /></p>
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
				<h2 class="indigo-text text-darken-4">
					<spring:message code="sign.up" />
				</h2>
				<p>
					<spring:message code="sign.up.description1" />
				</p>
				<p>
					<spring:message code="sign.up.description2" />
				</p>
				<ul>
					<li><a class="btn" href="${pagesLogin}"><i
							class="material-icons left white-text">forward</i> <spring:message
								code="log.in" /></a></li>
				</ul>
			</div>

			<form:form class="col s12 l5 offset-l2" method="POST"
				action="${pagesSignUp}" modelAttribute="formModel">

				<div class="input-field">
					<i class="material-icons prefix">email</i>
					<form:input path="email" type="email" />
					<form:errors path="email" cssClass="red-text" />
					<label for="email"><spring:message code="email" /></label>
				</div>

				<div class="input-field">
					<i class="material-icons prefix">lock</i>
					<form:input path="password" type="password" />
					<form:errors path="password" cssClass="red-text" />
					<label for="password"><spring:message code="password" /></label>
				</div>


				<div class="input-field">
					<i class="material-icons prefix">person_add</i>
					<form:input path="nickname" type="text" />
					<form:errors path="nickname" cssClass="red-text" />
					<label for="nickname"><spring:message code="nickname" /></label>
				</div>

				<div class="input-field">
					<i class="material-icons prefix">date_range</i>
					<form:input path="birthDate" type="text" class="datepicker" />
					<form:errors path="birthDate" cssClass="red-text" />
					<label for="birthDate"><spring:message code="birthdate" /></label>
				</div>


				<div class="col s12 offset-l4">
					<button class="btn waves-effect waves-light" type="submit">
						<spring:message code="sign.up" />
					</button>
				</div>



			</form:form>

		</div>
	</section>
		
	<!-- footer -->
	<footer class="page-footer grey darken-3">
		<div class="container">
			<div class="row">
				<div class="col l6 s12">
					<h5>
						<spring:message code="about.site" />
					</h5>
					<p>
						<spring:message code="here.u.can.play" />
					</p>
				</div>
				<div class="col l4 offset-l2 s12">
					<h5 class="white-text">
						<spring:message code="links" />
					</h5>
					<ul>
						<li><a class="grey-text text-lighten-3" target="_blank" href="${contextPath}/resources/footer_links/db.png"><spring:message
									code="database" /></a></li>
						<li><a class="grey-text text-lighten-3" target="_blank"
							href="${contextPath}/resources/footer_links/players.txt"><spring:message
									code="all.players" /></a></li>
						<li><a class="grey-text text-lighten-3" target="_blank" href="${contextPath}/resources/footer_links/mindmup.png"><spring:message
									code="mindmup" /></a></li>
						<li><a class="grey-text text-lighten-3" target="_blank" href="${contextPath}/resources/footer_links/jmeter-threads.png">JMeter Threads</a></li>
						<li><a class="grey-text text-lighten-3" target="_blank" href="${contextPath}/resources/footer_links/jmeter-summary.png">JMeter Summary</a></li>
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
			$('.dropdown-trigger').dropdown();
			$('.tap-target').tapTarget();
		});
		$('#giveup').on('click', function() {
			if ("${loggedUserId}" === "${game.whitePlayerId}") {
				$.ajax({
					url : "${contextPath}/play/game_over_with_result?game_id=${game.id}&winner_id=${game.blackPlayerId}&loser_id=${loggedUserId}",
					type : "POST",
					success : function() {
						window.location = "${pagesGame}";
					}
				});				
			} else {
				$.ajax({
					url : "${contextPath}/play/game_over_with_result?game_id=${game.id}&winner_id=${game.whitePlayerId}&loser_id=${loggedUserId}",
					type : "POST",
					success : function() {
						window.location = "${pagesGame}";
					}
				});
			}


		})
		</script>
</body>
</html>