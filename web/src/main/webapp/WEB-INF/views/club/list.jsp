<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h4 class="header">Clubs</h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>created</th>
			<th>deleted</th>
			<th>number_of_members</th>
			<th>country_Id</th>
			<th></th>
		</tr>
		<c:forEach var="club" items="${gridItems}" varStatus="loopCounter">
			<tr>
				<td><c:out value="${club.id}" /></td>
				<td><c:out value="${club.name}" /></td>
				<td><c:out value="${club.createdDate}" /></td>
				<td><c:out value="${club.deletedDate}" /></td>
				<td><c:out value="${club.numberOfMembers}" /></td>
				<td><c:out value="${club.countryId}" /></td>
				<td class="right"><a class="btn-floating"
					href="${pagesClub}/${club.id}"><i class="material-icons">info</i></a>
					<a class="btn-floating" href="${pagesClub}/${club.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="${pagesClub}/${club.id}/delete"><i class="material-icons">delete</i></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a class="waves-effect waves-light btn right" href="${clubMode}/add"><i
	class="material-icons">add</i></a>