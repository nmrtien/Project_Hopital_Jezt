<%@ page
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail Doctor</title>
</head>
<body>
	<div align="center">
		<h1>Detail Doctor</h1>
		</br>
		<table border="1">
			<tr>
				<td>AVATAR</td>
				<td><img src="${doc.doAvatar}" height="100" with="200"/></td>
			</tr>
			<tr>
				<td>ID</td>
				<td>${doc.doId}</td>
			</tr>
			<tr>
				<td>ACCOUNT</td>
				<td>${doc.doAcc}</td>
			</tr>
			<tr>
				<td>PASSWORD</td>
				<td>${doc.doPass}</td>
			</tr>
			<tr>
				<td>FULLNAME</td>
				<td>${doc.doFullName}</td>
			</tr>
			<tr>
				<td>PHONE</td>
				<td>${doc.doPhone}</td>
			</tr>
			<tr>
				<td>AGE</td>
				<td>${doc.doAge}</td>
			</tr>
			<tr>
				<td>EMAIL</td>
				<td>${doc.doEmail}</td>
			</tr>
			<tr>
				<td>ADDRESS</td>
				<td>${doc.doAdress}</td>
			</tr>
			<tr>
				<td>CONTENT</td>
				<td>${doc.doContent}</td>
			</tr>
			<tr>
				<td>STATUS</td>
				<td>${doc.doStatus}</td>
			</tr>
			<tr>
				<td>ID DEPARTMENT</td>
				<td>${doc.caId}</td>
			</tr>
		</table>
	</div>
</body>
</html>