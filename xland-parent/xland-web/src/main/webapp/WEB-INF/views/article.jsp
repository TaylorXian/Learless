<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/templates/bootstrap/header.jsp"%>
<div class="row">
	<div class="col-md-6">
		<div>
			<h2>
				<a href="article/${article.id}">${article.title}</a>
			</h2>
			<p>
				<span><a href="usr/${article.author}">${article.author}</a></span>&nbsp;<span>${article.ctime}</span>
			</p>
			<p>${article.content}</p>
		</div>
		<div>
			<hr />
			<div id="tweets">没有评论</div>
			<hr />
		</div>
		<div id="comment">
			<form class="ch-form" action="comment/" method="post">
				<div class="form-group">
					<input type="text" class="form-control" id="name" name="name"
						placeholder="随便写个名字吧..." required="required" value="${login_fellow}" />
				</div>
				<div class="form-group">
					<textarea class="form-control" id="textarea1" name="textarea1"
						placeholder="随便写点什么吧..." required="required"></textarea>
				</div>
				<div class="form-group">
					<input type="submit" id="submit" value="评论" class="btn btn-default" />
				</div>
			</form>
		</div>
	</div>
</div>
<%@ include file="/templates/bootstrap/script.jsp"%>
<%@ include file="/templates/bootstrap/footer.jsp"%>