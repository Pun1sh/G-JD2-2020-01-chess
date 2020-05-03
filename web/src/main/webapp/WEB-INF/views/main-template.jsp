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
<c:set var="pagesLiveChess" value="${contextPath}/play/live_chess"
	scope="request" />
<c:set var="pagesBoardEditor" value="${contextPath}/play/board_editor"
	scope="request" />
<c:set var="pagesRandomComputer"
	value="${contextPath}/play/random_computer" scope="request" />
<c:set var="pagesLogin" value="${contextPath}/login" scope="request" />
<c:set var="pagesSignUp" value="${contextPath}/sign_up" scope="request" />


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><tiles:insertAttribute name="title" /></title>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- font awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
	integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
	crossorigin="anonymous">

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link rel="stylesheet" href="${contextPath}/resources/css/custom.css">


<link rel="stylesheet"
	href="https://unpkg.com/@chrisoakman/chessboardjs@1.0.0/dist/chessboard-1.0.0.min.css"
	integrity="sha384-q94+BZtLrkL1/ohfjR8c6L+A6qzNH9R2hBLwyoAfu3i/WCvQjzL2RQJ3uNHDISdU"
	crossorigin="anonymous">
<script
	src="https://unpkg.com/@chrisoakman/chessboardjs@1.0.0/dist/chessboard-1.0.0.min.js"
	integrity="sha384-8Vi8VHwn3vjQ9eUHUxex3JSN/NFqUg3QbPyX8kWyb93+8AC/pPWTzj+nHtbC5bxD"
	crossorigin="anonymous"></script>

<script src="${contextPath}/resources/chess.js"></script>
<script src="${contextPath}/resources/js/init-materialize-forms.js"></script>

<script type="text/javascript">
	CONTEXT_PATH = "${contextPath}";
</script>

</head>
<body>
	<tiles:insertAttribute name="header" />
	<main>
		<div class="container">
			<tiles:insertAttribute name="body" />
		</div>
	</main>
	<%--<tiles:insertAttribute name="footer" />--%>
	<%-- <tiles:insertAttribute name="sidenav" /> --%>
</body>
</html>