<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>

<h4 class="header">Games</h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<th><mytaglib:sort-link pageUrl="${pagesGame}" column="id"><spring:message code="table.column.id" /></mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesGame}" column="whitePlayerName">White player</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesGame}" column="blackPlayerName">Black player</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesGame}" column="tournamentName">Tournament</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesGame}" column="winnerName">Winner</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesGame}" column="loserName">Loser</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesGame}" column="mode">Mode</mytaglib:sort-link></th>
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
<jspFragments:paging />
