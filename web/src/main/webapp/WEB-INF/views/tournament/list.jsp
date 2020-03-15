<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h4 class="header">Tournaments</h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>started</th>
			<th>ended</th>
			<th>country_id</th>
			<th>winner_id</th>
			<th></th>
		</tr>
		<c:forEach var="tournament" items="${gridItems}"
			varStatus="loopCounter">
			<tr>
				<td><c:out value="${tournament.id}" /></td>
				<td><c:out value="${tournament.name}" /></td>
				<td><c:out value="${tournament.started}" /></td>
				<td><c:out value="${tournament.ended}" /></td>
				<td><c:out value="${tournament.countryId}" /></td>
				<td><c:out value="${tournament.winnerId}" /></td>
				<td class="right"><a class="btn-floating"
					href="${pagesTournament}/${tournament.id}"><i
						class="material-icons">info</i></a> <a class="btn-floating"
					href="${pagesTournament}/${tournament.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="${pagesTournament}/${tournament.id}/delete"><i
						class="material-icons">delete</i></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a class="waves-effect waves-light btn right"
	href="${tournamentMode}/add"><i class="material-icons">add</i></a>