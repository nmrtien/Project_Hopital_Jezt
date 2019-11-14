<%@ page
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
input[type=text] {
  border: none;
  
  background-color:#eaebf3;
}
input[type=submit] {
  width: 80px;
  border: none;
  color:red;
  background-color:#eaebf3;
}
</style>
<meta charset="UTF-8">
<title>Submit Cart</title>

	<%@ include file="Common/IncludeFiles/HomeHeader.jsp" %>
	
	<div class="hero-wrap" style="background-image: url('DesignHome/images/bg_6.jpg'); background-attachment:fixed;">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center" data-scrollax-parent="true">
          <div class="col-md-8 ftco-animate text-center">
            <p class="breadcrumbs"><span class="mr-2"></span> <span class="mr-2">Cart</span></p>
            <h1 class="mb-3 bread">Submit Cart</h1>
          </div>
        </div>
      </div>
    </div>
    
	<form action="OderController">
	<div align="center" style="background-color:#eaebf3">
	<br>
	<div>
	<h3>You need click submit medicine to buy it</h3>
	</div>
	<br>
		<table style="width:1000px; height:500px">
			<thead>
				<th>Medicine</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Amount</th>
				<th></th>
			</thead>
			<hr>
			<tbody>
				<c:forEach var="cart" items="${listCart}">
					<tr>						
						<td><input type="text" value="${cart.med.meName}" name="oddMeName" readonly="true"></td>
						<td><input type="text" value="${cart.med.mePrice}" name="oddMePrice" readonly="true"></td>
						<td><input type="text" value="${cart.quantity}" name="oddMeQuantity" readonly="true"></td>
						<td><input type="text" value="${cart.quantity*cart.med.mePrice}" name="oddAmount" readonly="true"></td>
						<td>
							<a href="">Delete</a>
							
							<input type="submit" value="Submit" name="action">
						</td>
					</tr>
					
				</c:forEach>
					<tr>
						<td>TotalQuantity</td>
						<td>${totalQuantity}</td>						
					</tr>
					
					<tr>
						<td>TotalAmount</td>
						<td>${totalAmount}</td>
					</tr>
					<tr>
						<td>Name:</td>
						<td><input type="text" value="${od.odName}" name="odName" readonly="true"></td>
					</tr>
					<tr>
						<td>Phone:</td>
						<td><input type="text" value="${od.odPhone}" name="odPhone" readonly="true"></td>
					</tr>
					<tr>
						<td>Address:</td>
						<td><input type="text" value="${od.odAddress}" name="odAddress" readonly="true"></td>
					</tr>
					<tr>
						<td>Oder ID</td>
						<td><input type="text" value="${jezt}" name="odId" readonly="true"></td>
					</tr>
			</tbody>
		</table>
		<hr>
		<div>
		
		<a href="Home.jsp">Back Home</a>
		</div>
		<br>
	</div>
	</form>
	<%@ include file="Common/IncludeFiles/HomeFooter.jsp" %>

</html>