<%@ page
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EDIT CATEGORY</title>
</head>
<body>
	<form action="CategoryController">
		<div align="center">
			<h1>Edit</h1>
			</br>
			<table border="1">
				<tr>
					<td>ID</td>
					<td><input type="text" value="${cat.caId}" name="caId" readonly="true" /></td>
				</tr>
				<tr>
					<td>NAME</td>
					<td><input type="text" value="${cat.caName}" name="caName" /></td>
				</tr>
				<tr>
					<td>CONTENT</td>
					<td><input type="text" value="${cat.caContent}" name="caContent" /></td>
				</tr>
				<tr>
					<td>STATUS</td>
					<td><input type="text" value="${cat.caStatus}" name="caStatus" /></td>
				</tr>
			</table>
			<input type="submit" value="EDIT" name="action" />
		</div>
	</form>
</body>
</html>