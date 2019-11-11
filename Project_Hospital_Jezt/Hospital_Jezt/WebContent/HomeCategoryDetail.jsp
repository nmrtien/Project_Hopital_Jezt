<%@ page
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Department Detail</title>

	<%@ include file="Common/IncludeFiles/HomeHeader.jsp" %>
	
	 <div class="hero-wrap" style="background-image: url('DesignHome/images/bg_6.jpg'); background-attachment:fixed;">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center" data-scrollax-parent="true">
          <div class="col-md-8 ftco-animate text-center">
            <p class="breadcrumbs"><span class="mr-2"></span> <span class="mr-2">Departments</span> <span>Department Detail</span></p>
            <h1 class="mb-3 bread">Department Home</h1>
          </div>
        </div>
      </div>
    </div>
    
    
    
    <section class="ftco-section ftco-degree-bg" style="background-color:#eaebf3">
      <div class="container">
      <div class="row justify-content-start mb-5 pb-3 mt-5">
		<div class="col-md-12 heading-section ftco-animate">
		    <h2 class="mb-4">Our Department</h2>
		</div>
	  </div>
        <div class="row">
          <div class="col-md-8 ftco-animate">
            <p>
              <img src="../Hospital_Jezt/Common/Images/CategoryImages/${cat.caImage}" alt="" class="img-fluid">
            </p>
            <h2 class="mb-3">${cat.caName}</h2>
			<p>${cat.caContent}</p>            
            

            <div class="row justify-content-start mb-5 pb-3 mt-5">
		          <div class="col-md-12 heading-section ftco-animate">
		            <h2 class="mb-4">Our Experienced Doctors</h2>
		          </div>
		        </div>
            <div class="row">
            	<c:forEach var="doc" items="${listDoc}">
	        <div class="col-md-6 ftco-animate">
			          <div class="block-2">
			            <div class="flipper">
			              <div class="front" style="background-image: url(../Hospital_Jezt/Common/Images/DoctorImages/${doc.doAvatar});">
			                <div class="box">
			                  <h2>${doc.doFullName}</h2>
			                  
			                </div>
			              </div>
			              <div class="back">
			                <!-- back content -->
			                <blockquote>
			                  <p>&ldquo;${doc.doContent}&rdquo;</p>
			                </blockquote>
			                <div class="author d-flex">
			                  <div class="image mr-3 align-self-center">
			                    <div class="img" style="background-image: url(../Hospital_Jezt/Common/Images/DoctorImages/${doc.doAvatar});"></div>
			                  </div>
			                  <div class="name align-self-center">${doc.doFullName}</div>
			                </div>
			              </div>
			            </div>
			          </div> <!-- .flip-container -->
			        </div>
        </c:forEach>
			        
            </div>

          </div> <!-- .col-md-8 -->
          

        </div>
      </div>
    </section> <!-- .section -->
    
    
    
    <%@ include file="Common/IncludeFiles/HomeFooter.jsp" %>
	
</html>