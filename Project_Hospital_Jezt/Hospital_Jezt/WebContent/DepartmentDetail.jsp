<%@ page
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Department Detail</title>
</head>
<body>
	<div align="center">
		<h2>List Doctor</h2>
		</br>
		<table border="1">
			<thead>
				<th>ID</th>
				<th>ACCOUNT</th>
				<th>PASSWORD</th>
				<th>FULLNAME</th>
				<th>PHONE</th>
				<th>AGE</th>
				<th>EMAIL</th>
				<th>AVATAR</th>
				<th>ADDRESS</th>
				<th>CONTENT</th>
				
			</thead>
			<tbody>
				<c:forEach items="${listDoc}" var="doc">
					<tr>
						<td>${doc.doId}</td>
						<td>${doc.doAcc}</td>
						<td>${doc.doPass}</td>
						<td>${doc.doFullName}</td>
						<td>${doc.doPhone}</td>
						<td>${doc.doAge}</td>
						<td>${doc.doEmail}</td>
						<td><img src="${doc.doAvatar}" alt="Doctor face" height="100" width="100"></td>
						<td>${doc.doAdress}</td>
						<td>${doc.doContent}</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</br>
		<a href="CategoryController?action=getAllCategory">Back</a>
	</div>
</body>
</html>