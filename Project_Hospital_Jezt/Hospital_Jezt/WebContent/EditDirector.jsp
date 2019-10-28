<%@ page
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="DirectorController">
	<div align="center">
		<h1>EDIT</h1>
		</br>
		<table boder="1">
			<tr>
				<td>ID:</td>
				<td><input type="text" value="${dir.diId}" name="diId" readonly="true"/></td>
			</tr>
			<tr>
				<td>ACCOUNT:</td>
				<td><input type="text" value="${dir.diAcc}" name="diAcc"/></td>
			</tr>
			<tr>
				<td>PASSWORD:</td>
				<td><input type="text" value="${dir.diPass}" name="diPass"/></td>
			</tr>
			<tr>
				<td>FULLNAME:</td>
				<td><input type="text" value="${dir.diFullName}" name="diFullName"/></td>
			</tr>
			<tr>
				<td>PHONE:</td>
				<td><input type="text" value="${dir.diPhone}" name="diPhone"/></td>
			</tr>
			<tr>
				<td>NOTICE:</td>
				<td><input type="text" value="${dir.diContent}" name="diContent"/></td>
			</tr>
			<tr>
				<td>STATUS</td>
				<td><input type="text" value="${dir.diStatus}" name="diStatus"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="edit" /></td>
				<td><a href="Director.jsp">BACK HOME</a></td>
			</tr>
		</table>
	</div>
</form>
</body>
</html>