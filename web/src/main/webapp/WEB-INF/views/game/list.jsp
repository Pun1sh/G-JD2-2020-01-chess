<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h4 class="header">Games</h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<th><spring:message code="table.column.id" /></th>
			<th>White player</th>
			<th>Black player</th>
			<th>Tournament</th>
			<th>Winner</th>
			<th>Loser</th>
			<th>Mode</th>
			<th></th>
		</tr>
		<c:forEach var="game" items="${gridItems}" varStatus="loopCounter">
			<tr>
				<td><c:out value="${game.id}" /></td>
				<td><c:out value="${game.whitePlayerName}" /></td>
				<td><c:out value="${game.blackPlayerName}" /></td>
				<td><c:out value="${game.tournamentName}" /></td>
				<td><c:out value="${game.winnerName}" /></td>
				<td><c:out value="${game.loserName}" /></td>
				<td><c:out value="${game.mode}" /></td>
				<td class="right"><a class="btn-floating"
					href="${pagesGame}/${game.id}"><i class="material-icons">info</i></a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
