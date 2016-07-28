<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/templates/bootstrap/header.jsp"%>
<div class="row">
	<div class="col-md-8">
		<h3>写文章</h3>
		<form class="" method="POST" action="${form_action}">
			<div class="form-group">
				<input type="text" class="form-control" id="title" name="title"
					value="${ empty blog_title ? '' : blog_title }"
					placeholder="输入文章标题...">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="author" name="author"
					value="${login_fellow}" placeholder="输入名字...">
			</div>
			<div class="form-group">
				<textarea class="form-control" id="content" name="content"
					class="myCountdown" placeholder="输入内容...">${blog_content}</textarea>
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-default" value="发表" />
			</div>
		</form>
	</div>
</div>
<%@ include file="/templates/bootstrap/script.jsp"%>
<script src="http://js.nicedit.com/nicEdit-latest.js"
	type="text/javascript"></script>
<script type="text/javascript">bkLib.onDomLoaded(nicEditors.allTextAreas);jQuery('#title').focus()</script>
<%@ include file="/templates/bootstrap/footer.jsp"%>
