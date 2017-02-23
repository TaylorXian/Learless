<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/templates/bootstrap/header.jsp"%>
<c:url value="/logout" var="logoutUrl" />
<div class="row">
	<div class="col-md-6">
		<%-- csrt support --%>
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				Welcome : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>
	</div>
</div>

<%@ include file="/templates/bootstrap/script.jsp"%>
<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>
<%@ include file="/templates/bootstrap/footer.jsp"%>