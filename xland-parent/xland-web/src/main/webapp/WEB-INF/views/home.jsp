<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/templates/bootstrap/header.jsp"%>
<div class="row content">
<div class="col-md-6 list">
<c:forEach items="${articles}" var="a">
<div class="list-item">
	<div class="item-head">
		<div class="title">
			<a href="article/${a.id}">${a.title}</a>
		</div>
		<div class="sub">
			<span class="normal tag"><a href="usr/${a.author}">${a.author}</a></span>
			<span class="small tag">${fn:substring(a.ctime, 0, 13)}h</span>
		</div>
	</div>
	<div class="item-body">
		<p class="text-wrap">${fn:substring(a.content, 0, 160)}</p><c:if test="${fn:length(a.content) gt 160 }">
		<p><a href="article/${a.id}" class="small tag">&gt;&gt;&gt;</a></p></c:if>
	</div>
	<div class="item-foot">
	</div>
</div>
</c:forEach>
</div>
</div>
<%@ include file="/templates/bootstrap/script.jsp"%>
<%@ include file="/templates/bootstrap/footer.jsp"%>
