<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h4 class="header">Modes</h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>time_minutes</th>
			<th></th>
		</tr>
		<c:forEach var="mode" items="${gridItems}" varStatus="loopCounter">
			<tr>
				<td><c:out value="${mode.id}" /></td>
				<td><c:out value="${mode.name}" /></td>
				<td><c:out value="${mode.timeMinutes}" /></td>
				<td class="right"><a class="btn-floating"
					href="${pagesMode}/${mode.id}"><i class="material-icons">info</i></a>
					<a class="btn-floating" href="${pagesMode}/${mode.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="${pagesMode}/${mode.id}/delete"><i class="material-icons">delete</i></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a class="waves-effect waves-light btn right" href="${pagesMode}/add"><i
	class="material-icons">add</i></a>