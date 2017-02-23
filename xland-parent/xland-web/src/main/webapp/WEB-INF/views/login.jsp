<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/templates/bootstrap/header.jsp"%>
<div class="row">
	<div class="col-md-6">
		<form name="loginForm" class="form-horizontal" action="login"
			method="POST">
			<div class="form-group">
				<label for="username" class="col-sm-2 control-label">账号:</label>
				<div class="col-sm-5">
					<input class="form-control" id="username" name="username"
						placeholder="输入邮箱或用户名..." required="required">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">密码:</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" id="password"
						name="password" placeholder="输入密码..." required="required">
				</div>
			</div>
			<div class="form-group hidden">
				<div class="col-sm-offset-2 col-sm-5">
					<div class="checkbox">
						<label> <input type="checkbox" /> 记住我
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-5">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<button type="submit" class="btn btn-default">登录</button>
				</div>
			</div>
			<div class="col-sm-offset-2 col-sm-5">
				<c:if test="${not empty error}">
					<div class="alert alert-danger" role="alert"">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="alert alert-danger" role="alert"">${msg}</div>
				</c:if>
			</div>
		</form>
	</div>
</div>
<%@ include file="/templates/bootstrap/script.jsp"%>
<script type="text/javascript">
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>
<%@ include file="/templates/bootstrap/footer.jsp"%>