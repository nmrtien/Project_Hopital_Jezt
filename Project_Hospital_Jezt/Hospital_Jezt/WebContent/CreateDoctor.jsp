<%@ page
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Doctor</title>
</head>
<body>
	<form action="DoctorController">
		<div align="center">
			<table border="1">
				<tr>
					<td>ACC</td>
					<td><input type="text" name="doAcc" /></td>
				</tr>
				<tr>
					<td>PASS</td>
					<td><input type="text" name="doPass" /></td>
				</tr>
				<tr>
					<td>FULLNAME</td>
					<td><input type="text" name="doFullName" /></td>
				</tr>
				<tr>
					<td>PHONE</td>
					<td><input type="text" name="doPhone" /></td>
				</tr>
				<tr>
					<td>AGE</td>
					<td><input type="text" name="doAge" /></td>
				</tr>
				<tr>
					<td>EMAIL</td>
					<td><input type="text" name="doEmail" /></td>
				</tr>
				<tr>
					<td>AVATAR</td>
					<td><input type="text" name="doAvatar" /></td>
				</tr>
				<tr>
					<td>ADDRESS</td>
					<td><input type="text" name="doAdress" /></td>
				</tr>
				<tr>
					<td>CONTENT</td>
					<td><input type="text" name="doContent" /></td>
				</tr>
				<tr>
					<td>STATUS</td>
					<td><input type="text" name="doStatus" /></td>
				</tr>
				<tr>
					<td>DEPARTMENT</td>
					<td>
						<select id="caId" name="caId">
								<option>Choose department</option>
							<c:forEach items="${listCat}" var="cat">
								<option value="${cat.caId}">${cat.caName}</option>
							</c:forEach>
						 </select>
					</td>
				</tr>
			</table>
			</br>
			<input type="submit" value="CREATE" name="action" />
		</div>
	</form>
</body>
</html>