<%@ page
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Doctor</title>
</head>
<body>
	<div align="center">
		<h1>List Doctor</h1>
		</br>
		<h3><a href="CategoryController?action=initCreateDoctor">Create New Doctor</a></h3>
		</br>
		<h3>${createDoctorFail}</h3>
		</br>
		<h3>${editDoctorFail}</h3>
		</br>
		<h3>${deleteDoctorFail}</h3>
		</br>
		<table border="1">
			<thead>
				<th>AVATAR</th>
				<th>FULLNAME</th>
				<th>ID</th>
				<th>ID DEPARTMENT</th>
				<th>CUSTOMIZE</th>
			</thead>
			<tbody>
				<c:forEach items="${listDoc}" var="doc">
					<tr>
						<td><img src="${doc.doAvatar}" height="50" with="200"/></td>
						<td>${doc.doFullName}</td>
						<td>${doc.doId}</td>
						<td>${doc.caId}</td>
						<td>
							<a href="DoctorController?action=detail&doId=${doc.doId}">Details</a>
							<a href="DoctorController?action=initEdit&doId=${doc.doId}">Edit</a>
							<a href="DoctorController?action=delete&doId=${doc.doId}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>