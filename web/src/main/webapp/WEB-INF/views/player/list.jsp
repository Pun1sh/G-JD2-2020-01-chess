<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h4 class="header">Players</h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<th><spring:message code="table.column.id" /></th>
			<th>nickname</th>
			<th>countryId</th>
			<th>registrated</th>
			<th>clubId</th>
			<th>gamesPlayed</th>
			<th>birthDate</th>
			<th>email</th>
			<th>eloPoints</th>
			<th>rank</th>
			<th></th>
		</tr>
		<c:forEach var="player" items="${gridItems}" varStatus="loopCounter">
			<tr>
				<td><c:out value="${player.id}" /></td>
				<td><c:out value="${player.nickname}" /></td>
				<td><c:out value="${player.countryId}" /></td>
				<td><c:out value="${player.registrated}" /></td>
				<td><c:out value="${player.clubId}" /></td>
				<td><c:out value="${player.gamesPlayed}" /></td>
				<td><c:out value="${player.birthDate}" /></td>
				<td><c:out value="${player.email}" /></td>
				<td><c:out value="${player.eloPoints}" /></td>
				<td><c:out value="${player.rank}" /></td>
				<td class="right"><a class="btn-floating"
					href="${pagesPlayer}/${player.id}"><i class="material-icons">info</i></a>
					<a class="btn-floating" href="${pagesPlayer}/${player.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="${pagesPlayer}/${player.id}/delete"><i
						class="material-icons">delete</i></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a class="waves-effect waves-light btn right" href="${pagesPlayer}/add"><i
	class="material-icons">add</i></a>