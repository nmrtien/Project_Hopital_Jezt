<%@ page
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Department</title>
</head>
<body>
	<div align="center">
	<h2>List Department !</h2>
	</br>
	<h4><a href="CategoryController?action=createNew">Create New</a></h4>
	</br>
		<table border="1">
			<thead>
				<th>ID</th>
				<th>NAME</th>
				<th>CONTENT</th>
				<th>STATUS</th>
				<th>Customize</th>
			</thead>
			<tbody>
				<c:forEach var="cat" items="${listCat}">
					<tr>
						<td>${cat.caId}</td>
						<td>${cat.caName}</td>
						<td>${cat.caContent}</td>
						<td>${cat.caStatus}</td>
						<td>
							<a href="#">EDIT</a>
							<a href="CategoryController?action=getDoctorWithCaId&caId=${cat.caId}">DETAILS</a>
							<a href="#">DELETE</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>