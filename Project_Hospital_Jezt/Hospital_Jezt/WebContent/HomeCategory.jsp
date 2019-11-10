<%@ page
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Departments</title>
	
	<%@ include file="Common/IncludeFiles/HomeHeader.jsp" %>
	
	<div class="hero-wrap" style="background-image: url('DesignHome/images/bg_6.jpg'); background-attachment:fixed;">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center" data-scrollax-parent="true">
          <div class="col-md-8 ftco-animate text-center">
            <p class="breadcrumbs"><span class="mr-2">Departments</span></p>
            <h1 class="mb-3 bread">Departments</h1>
          </div>
        </div>
      </div>
    </div>
    
    <section class="ftco-section">
    	<div class="container">
    		<div class="row d-flex">
    		
    		<c:forEach var="cat" items="${listCat}">
    		
    			<div class="col-lg-6 d-flex ftco-animate">
    				<div class="dept d-md-flex">
    					<a href="CategoryController?action=homeCategoryDetail&caId=${cat.caId}" class="img" style="background-image: url(../Hospital_Jezt/Common/Images/CategoryImages/${cat.caImage});"></a>
    					<div class="text p-4">
    						<h3><a href="CategoryController?action=homeCategoryDetail&caId=${cat.caId}">Departments ${cat.caName}</a></h3>
    						
    						<p>${cat.caContent}</p>
    						<ul>
    							<li><span class="ion-ios-checkmark"></span>Emergency</li>
    							<li><span class="ion-ios-checkmark"></span>Laboratory</li>
    							<li><span class="ion-ios-checkmark"></span>Dental</li>
    						</ul>
    					</div>
    				</div>
    			</div>
    			
    		</c:forEach>
    			
    		</div>
    	</div>
    </section>

	<%@ include file="Common/IncludeFiles/HomeFooter.jsp" %>

</html>