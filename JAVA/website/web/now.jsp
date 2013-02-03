<%@ page import="java.util.Date" %>
<html>
	<body>
		<h1>
			<%
				Date now = new Date();
				out.println(now);
			%>
		</h1>
	</body>
</html>