<%@ page
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Director Detail</title>
</head>
<body>
	<div align="center">
		<h1>Information</h1>
		</br>
		<table border="1">
			<tr>
				<td>ID:</td>
				<td>${dir.diId}</td>
			</tr>
			<tr>
				<td>ACCOUNT:</td>
				<td>${dir.diAcc}</td>
			</tr>
			<tr>
				<td>PASSWORD:</td>
				<td>${dir.diPass}</td>
			</tr>
			<tr>
				<td>FULLNAME:</td>
				<td>${dir.diFullName}</td>
			</tr>
			<tr>
				<td>PHONE:</td>
				<td>${dir.diPhone}</td>
			</tr>
			<tr>
				<td>NOTICE:</td>
				<td>${dir.diContent}</td>
			</tr>
			<tr>
				<td>STATUS</td>
				<td>${dir.diStatus}</td>
			</tr>
			<tr>
				<td><a href="DirectorController?action=initEditDirector&diId=${dir.diId}">EDIT</a></td>
				<td><a href="Director.jsp">BACK</a></td>
			</tr>
		</table>
	</div>
</body>
</html>