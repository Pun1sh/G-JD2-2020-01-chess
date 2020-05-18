<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<h4 class="header"><spring:message code="waiting.players" /></h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<th><mytaglib:sort-link pageUrl="${pagesPlayer}" column="id">
					<spring:message code="table.column.id" />
				</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesPlayer}"
					column="nickname"><spring:message code="nickname.list" /></mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesPlayer}"
					column="gamesPlayed"><spring:message code="games.played" /></mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesPlayer}"
					column="eloPoints"><spring:message code="elo.points" /></mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesPlayer}" column="rank"><spring:message code="rank" /></mytaglib:sort-link></th>
			<th></th>
		</tr>
		<c:forEach var="player" items="${gridItems}" varStatus="loopCounter">
			<tr>
				<td><c:out value="${player.id}" /></td>
				<td><c:out value="${player.nickname}" /></td>
				<td><c:out value="${player.gamesPlayed}" /></td>
				<td><c:out value="${player.eloPoints}" /></td>
				<td><c:out value="${player.rank}" /></td>
				<td class="right"><a class="btn-floating"
					href="${pagesPlayer}/${player.id}"><i class="material-icons">info</i></a>
					<a class="btn-floating green tooltipped" data-position="bottom"
					data-tooltip="<spring:message code="play.against" />"
					href="${contextPath}/play/make_game/?white_player_id=${loggedUserId}&black_player_id=${player.id}"><i
						class="material-icons">play_circle_filled</i></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jspFragments:paging />

<script>
	$(document).ready(function() {
		$('.tooltipped').tooltip();
	});
</script>



