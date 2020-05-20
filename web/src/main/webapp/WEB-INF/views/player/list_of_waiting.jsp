<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<h4 class="header">
	<spring:message code="waiting.players" />
</h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<th><spring:message code="table.column.id" /></th>
			<th><spring:message code="nickname.list" /> </th>
			<th><spring:message code="games.played" /></th>
			<th><spring:message code="elo.points" />
				</th>
			<th><spring:message code="rank" /></th>
			<th></th>
		</tr>
		<c:forEach var="player" items="${gridItems}" varStatus="loopCounter">
			<tr>
				<td><c:out value="${player.id}" /></td>
				<td><c:out value="${player.nickname}" /></td>
				<td><c:out value="${player.gamesPlayed}" /></td>
				<td><c:out value="${player.eloPoints}" /></td>
				<td><c:out value="${player.rank}" /></td>
				<td><div class="input-field col s12">
						<select id="mode">
							<option value="" disabled selected>Game mode</option>
							<option value="1">Blitz</option>
							<option value="2">10 minutes</option>
							<option value="3">30 minutes</option>
							<option value="4">60 minutes</option>
						</select> <label>Choose game mode</label>
					</div></td>
				<td class="right"><a class="btn-floating"
					href="${pagesPlayer}/${player.id}"><i class="material-icons">info</i></a>
					<a class="btn-floating green tooltipped disabled" id="test" data-field="${player.id}"
					data-position="bottom" data-tooltip="<spring:message code="play.against" />"><i
						class="material-icons">play_circle_filled</i></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jspFragments:paging />

<script>
	$(document).ready(function() {
		$('.tooltipped').tooltip();
		$('select').formSelect();
	});
		$(document).on('change','#mode',function() {
						var value = $(this).val();
						$('#test').attr('href',"${contextPath}/play/make_game/?white_player_id=${loggedUserId}&black_player_id="
								+$('#test').attr('data-field')+"&mode="+ value);
					});
		$("#mode").on('change',function() {
				$("#test").addClass("floating green tooltipped").removeClass('disabled');
			});
 
</script>



