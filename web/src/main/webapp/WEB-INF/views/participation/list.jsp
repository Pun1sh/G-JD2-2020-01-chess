<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h4 class="header">Tournament results</h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<th>id</th>
			<th>player_id</th>
			<th>tournament_id</th>
			<th>tournament_points</th>
			<th></th>
		</tr>
		<c:forEach var="participation" items="${gridItems}"
			varStatus="loopCounter">
			<tr>
				<td><c:out value="${participation.id}" /></td>
				<td><c:out value="${participation.playerId}" /></td>
				<td><c:out value="${participation.tournamentId}" /></td>
				<td><c:out value="${participation.tournamentPoints}" /></td>
				<td class="right"><a class="btn-floating"
					href="${pagesParticipation}/${participation.id}"><i
						class="material-icons">info</i></a> <a class="btn-floating"
					href="${pagesParticipation}/${participation.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="${pagesParticipation}/${participation.id}/delete"><i
						class="material-icons">delete</i></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a class="waves-effect waves-light btn right"
	href="${participationMode}/add"><i class="material-icons">add</i></a>