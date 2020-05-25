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
						<select class="mode">
							<option value="" disabled selected><spring:message
								code="mode" /></option>
							<option value="1"><spring:message
								code="blitz" /></option>
							<option value="2"><spring:message
								code="10min" /></option>
							<option value="3"><spring:message
								code="30min" /></option>
							<option value="4"><spring:message
								code="60min" /></option>
							<option value="5"><spring:message
								code="notime" /></option>
						</select> <label><spring:message
								code="choose.mode" /></label>
					</div></td>
				<td class="right">
					<a class="btn-floating green tooltipped disabled test" data-field="${player.id}"
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
		$(document).on('change','.mode',function() {
						var value = $(this).val();
						var $selector = $(this).closest('tr').find('.test');
						var url = $selector.attr('href', "${contextPath}/play/make_game/?white_player_id=${loggedUserId}&black_player_id=" +
							    $selector.attr('data-field') + "&mode=" + value);
						
					});
		$(".mode").on('change',function() {
			 $(this).closest('tr').find('.test').addClass("floating green tooltipped").removeClass('disabled');
			})
 
</script>



