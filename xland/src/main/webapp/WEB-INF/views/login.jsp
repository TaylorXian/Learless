<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/templates/bootstrap/header.jsp"%>
<form:form action="usr/add" method="post" modelAttribute="usr" >
	<form:input path="name" />
	<form:errors path="name" cssClass="errorMessage" element="div" />
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success">
			<spring:message code="message.youWrote" arguments="${message}"
				htmlEscape="true" />
		</div>
	</c:if>
	<input type="submit" value="Login" class="btn btn-default" />
</form:form>
<%@ include file="/templates/bootstrap/script.jsp"%>
<%@ include file="/templates/bootstrap/footer.jsp"%>