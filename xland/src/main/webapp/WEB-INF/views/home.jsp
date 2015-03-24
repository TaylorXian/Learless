<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/templates/bootstrap/header.jsp"%>
<c:forEach items="${articles}" var="a">
<div class="row">
	<h2>
		<a href="${a.id}">${a.title}</a>
	</h2>
	<p>
		<span>发表于${a.ctime}</span|<span><a href="#">作者:&nbsp;${a.author}</a></span>|<span><a href="#">评论:0</a></span>
	</p>
	<p>${a.content}</p>
</div>
</c:forEach>
<%@ include file="/templates/bootstrap/script.jsp"%>
<%@ include file="/templates/bootstrap/footer.jsp"%>