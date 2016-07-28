<%
String port = request.getServerPort() == 80 ? "" : ":" + request.getServerPort();
String base = String.format("%s://%s%s%s/", request.getScheme(),
		request.getServerName(), port, request.getContextPath());
%>
