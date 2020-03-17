<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Edit mode</h4>
<div class="row">

	<form:form class="col s12" method="POST" action="${pagesMode}"
		modelAttribute="formModel">
		<form:input path="id" type="hidden" />


		<div class="row">
			<div class="input-field col s12">
				<form:input path="name" type="text" disabled="${readonly}" />
				<form:errors path="name" cssClass="red-text" />
				<label for="name">Mode name</label>
			</div>
		</div>


		<div class="row">
			<div class="input-field col s12">
				<form:input path="timeMinutes" type="text" disabled="${readonly}" />
				<form:errors path="timeMinutes" cssClass="red-text" />
				<label for="timeMinutes">Mode time</label>
			</div>
		</div>




		<div class="row">
			<div class="col s6"></div>
			<div class="col s3">
				<c:if test="${!readonly}">
					<button class="btn waves-effect waves-light right" type="submit">Save</button>
				</c:if>
			</div>
			<div class="col s3">
				<a class="btn waves-effect waves-light right" href="${pagesBrand}">Cancel</a>
			</div>
		</div>
	</form:form>
</div>