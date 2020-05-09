<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h4 class="header">Players</h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<th><spring:message code="table.column.id" /></th>
			<th>Nickname</th>
			<th>Games played</th>
			<th>Elo Points</th>
			<th>Rank</th>
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
					<a class="btn-floating green"
					href="${contextPath}/play/make_game/?white_player_id=${loggedUserId}&black_player_id=${player.id}"><i
						class="material-icons">play_circle_filled</i></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
