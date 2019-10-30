<%@ page
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div align="center">
		<h1>Please enterning your account DIRECTOR !</h1>
		</br>
		<h3>${message}</h3>
		</br>
		<form method="post" action="LoginController?action=director">
			<table>
				<tr>
					<td>USER: </td>
					<td><input type="text" name="diAcc" id="name"/></td>
				</tr>
				<tr>
					<td>PASSWORD: </td>
					<td><input type="password" name="diPass" id="password" /></td>
				</tr>				
				</br>			
				<tr>
					<td><input type="submit" value="Login"/></td>
				</tr>				
			</table>
		</form>
	</div>
</body>
</html>