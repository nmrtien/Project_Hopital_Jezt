<%@ page
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Medicine</title>

	<%@ include file="Common/IncludeFiles/HomeHeader.jsp" %>

	<div class="hero-wrap" style="background-image: url('DesignHome/images/bg_6.jpg'); background-attachment:fixed;">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center" data-scrollax-parent="true">
          <div class="col-md-8 ftco-animate text-center">
            <p class="breadcrumbs"><span class="mr-2">Medicine</span></p>
            <h1 class="mb-3 bread">Medicine</h1>
          </div>
        </div>
      </div>
    </div>
    
    <section class="ftco-section">
    	<div class="container">
    	<form action="MedicineController" style="margin-bottom:40px">
              	<input type="text" placeholder="Type Name Medicine ..." name="meName" style="border:1px solid #92abe7;width:200px" />
              	<input type="submit" value="search" name="action" style="border-radius:40%;background-color:#92abe7;color:white" />
              </form>
    		<div class="row d-flex">
    		
    		
    		<c:forEach var="med" items="${listMed}">
    		
    			<div class="col-lg-6 d-flex ftco-animate">
    				<div class="dept d-md-flex">
    					<a  class="img" style="background-image: url(../Hospital_Jezt/Common/Images/MedicineImages/${med.meImage});"></a>
    					<div class="text p-4">
    						<h3><a >${med.meName}</a></h3>
    						
    						<p>${med.meContent}</p>
    						<ul>
    							<li><span class="ion-ios-checkmark"></span>${med.meTitle}</li>
    							<li><span class="ion-ios-checkmark"></span>Producer: ${med.meProducer}</li>
    							<li><span class="ion-ios-checkmark"></span>DateOfManufacture: ${med.meDateOfManufacture}</li>
    							<li><span class="ion-ios-checkmark"></span>ExpirationDate: ${med.meExpirationDate}</li>
    							<li><span class="ion-ios-checkmark"></span>Price: ${med.mePrice}$</li>
    						</ul>
    						<hr>
    						<h5><a href="MedicineController?action=addToCart">Add To Cart</a></h5>
    					</div>
    					
    				</div>
    			</div>
    			
    		</c:forEach>
    			
    		</div>
    	</div>
    </section>
	
	
	<%@ include file="Common/IncludeFiles/HomeFooter.jsp" %>

</html>