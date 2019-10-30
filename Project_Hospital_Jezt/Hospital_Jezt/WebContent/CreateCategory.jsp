<%@ page
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Ca</title>
</head>
<body>
	<form action="CategoryController">
		<div align="center">
			<h1>Create New Department</h1>
			</br>
			<h3>${createFail}</h3>
			</br>
			<table border="1">
				<tr>
					<td>NAME</td>
					<td><input type="text" name="caName" /></td>
				</tr>
				<tr>
					<td>CONTENT</td>
					<td><input type="text" name="caContent" /></td>
				</tr>
				<tr>
					<td>STATUS</td>
					<td><input type="text" name="caStatus" /></td>
				</tr>
			</table>
			<input type="submit" name="action" value="CREATE" />
		</div>
	</form>
</body>
</html>