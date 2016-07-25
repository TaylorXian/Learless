<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/templates/bootstrap/header.jsp"%>
<div class="row">
<div class="col-md-8">
<c:forEach items="${articles}" var="a">
<div>
	<h2>
		<a href="article/${a.id}">${a.title}</a>
	</h2>
	<p>
		<span><a href="usr/${a.author}">${a.author}</a></span>&nbsp;<span>${a.ctime}</span>
	</p>
	<p>${fn:substring(a.content, 0, 200)}</p>
	<p><c:if test="${fn:length(a.content) gt 200 }">...</c:if></p>
</div>
</c:forEach>
</div>
</div>
<%@ include file="/templates/bootstrap/script.jsp"%>
<%@ include file="/templates/bootstrap/footer.jsp"%>