<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h4 class="header">Games</h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<th>id</th>
			<th>white_player_id</th>
			<th>black_player_id</th>
			<th>tournament_id</th>
			<th>winner_id</th>
			<th>loser_id</th>
			<th>started</th>
			<th>ended</th>
			<th>mode</th>
			<th></th>
		</tr>
		<c:forEach var="game" items="${gridItems}" varStatus="loopCounter">
			<tr>
				<td><c:out value="${game.id}" /></td>
				<td><c:out value="${game.whitePlayerId}" /></td>
				<td><c:out value="${game.blackPlayerId}" /></td>
				<td><c:out value="${game.tournamentId}" /></td>
				<td><c:out value="${game.winnerId}" /></td>
				<td><c:out value="${game.loserId}" /></td>
				<td><c:out value="${game.started}" /></td>
				<td><c:out value="${game.ended}" /></td>
				<td><c:out value="${game.mode}" /></td>
				<td class="right"><a class="btn-floating"
					href="${pagesGame}/${game.id}"><i class="material-icons">info</i></a>
					<a class="btn-floating" href="${pagesGame}/${game.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="${pagesGame}/${game.id}/delete"><i class="material-icons">delete</i></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a class="waves-effect waves-light btn right" href="${gameMode}/add"><i
	class="material-icons">add</i></a>