<%@ page
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Doctor</title>
</head>
<body>
	<form action="DoctorController">
		<div align="center">
			<table border="1">
				<tr>
					<td>ID</td>
					<td><input type="text" value="${doc.doId}" name="doId" readonly="true" /></td>
				</tr>
				<tr>
					<td>ACC</td>
					<td><input type="text" value="${doc.doAcc}" name="doAcc" /></td>
				</tr>
				<tr>
					<td>PASS</td>
					<td><input type="text" value="${doc.doPass}" name="doPass" /></td>
				</tr>
				<tr>
					<td>FULLNAME</td>
					<td><input type="text" value="${doc.doFullName}" name="doFullName" /></td>
				</tr>
				<tr>
					<td>PHONE</td>
					<td><input type="text" value="${doc.doPhone}" name="doPhone" /></td>
				</tr>
				<tr>
					<td>AGE</td>
					<td><input type="text" value="${doc.doAge}" name="doAge" /></td>
				</tr>
				<tr>
					<td>EMAIL</td>
					<td><input type="text" value="${doc.doEmail}" name="doEmail" /></td>
				</tr>
				<tr>
					<td>AVATAR</td>
					<td><input type="text" value="${doc.doAvatar}" name="doAvatar" /></td>
				</tr>
				<tr>
					<td>ADDRESS</td>
					<td><input type="text" value="${doc.doAdress}" name="doAdress" /></td>
				</tr>
				<tr>
					<td>CONTENT</td>
					<td><input type="text" value="${doc.doContent}" name="doContent" /></td>
				</tr>
				<tr>
					<td>STATUS</td>
					<td><input type="text" value="${doc.doStatus}" name="doStatus" /></td>
				</tr>
				<tr>
					<td>ID DEPARTMENT</td>
					<td><input type="text" value="${doc.caId}" name="caId" readonly="true"/></td>
				</tr>
				<%-- <tr>
					<td>DEPARTMENT</td>
					<td>
						<select id="caId" name="caId">
								<option>Choose department</option>
							<c:forEach items="${listCat}" var="cat">
								<option value="${cat.caId}">${cat.caName}</option>
							</c:forEach>
						 </select>
					</td>
				</tr> --%>
			</table>
			</br>
			<input type="submit" value="EDIT" name="action" />
		</div>
	</form>
</body>
</html>