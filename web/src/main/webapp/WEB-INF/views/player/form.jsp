<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Edit player</h4>
<div class="row">

	<form:form class="col s12" method="POST" action="${pagesPlayer}"
		modelAttribute="formModel">
		<form:input path="id" type="hidden" />


		<div class="row">
			<div class="input-field col s12">
				<form:input path="nickname" type="text" disabled="${readonly}" />
				<form:errors path="nickname" cssClass="red-text" />
				<label for="nickname">Player nickname</label>
			</div>
		</div>


		<div class="row">
			<div class="input-field col s12">
				<form:input path="registrated" type="text" disabled="${readonly}" />
				<form:errors path="registrated" cssClass="red-text" />
				<label for="registrated">Registrated date</label>
			</div>
		</div>


		<div class="row">
			<div class="input-field col s12">
				<form:select path="countryId" disabled="${readonly}">
					<form:options items="${countriesChoices}" />
				</form:select>
				<form:errors path="countryId" cssClass="red-text" />
				<label for="countryId">country</label>
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
				<a class="btn waves-effect waves-light right" href="${pagesPlayer}">Cancel</a>
			</div>
		</div>
	</form:form>
</div>