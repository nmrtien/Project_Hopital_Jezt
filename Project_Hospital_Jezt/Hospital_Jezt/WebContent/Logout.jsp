<%@ page
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% 
		session.invalidate();
		response.sendRedirect("Home.jsp");
	%>

</body>
</html>