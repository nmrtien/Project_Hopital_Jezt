<%@ page
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>
    Edit Medicine
  </title>
  <!-- Favicon -->
  
  		<%@ include file="Common/IncludeFiles/DirectorHeader.jsp" %>
  
    <!-- Page content -->
    <div class="container-fluid mt--7">
      <div class="row">
       
        <div class="col-xl-10 order-xl-1">
          <div class="card bg-secondary shadow">
          <form action="MedicineController">
            <div class="card-header bg-white border-0">
              <div class="row align-items-center">
                <div class="col-8">
                  <h3 class="mb-0">Medicine</h3>
                  <h3>${createFail}</h3>
                </div>
                <div class="col-4 text-right">
                  <input type="submit" value="EDIT" name="action" class="btn btn-sm btn-primary" />
                </div>
              </div>
            </div>
            <div class="card-body">
              
                <h6 class="heading-small text-muted mb-4">Medicine information</h6>
                <div class="pl-lg-4">
                  <div class="row">
                  
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-username">Name</label>
                        <input type="text" class="form-control form-control-alternative" value="${med.meName}" name="meName" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Price</label>
                        <input type="text"  class="form-control form-control-alternative" value="${med.mePrice}" name="mePrice" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-username">ID</label>
                        <input type="text" class="form-control form-control-alternative" value="${med.meId}" name="meId" readonly="true" />
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Producer</label>
                        <input type="text"  class="form-control form-control-alternative" value="${med.meProducer}" name="meProducer" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Title</label>
                        <input type="text"  class="form-control form-control-alternative" value="${med.meTitle}" name="meTitle" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Content</label>
                        <input type="text"  class="form-control form-control-alternative" value="${med.meContent}" name="meContent" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Date Of Manufacture</label>
                        <input type="text"  class="form-control form-control-alternative" value="${med.meDateOfManufacture}" name="meDateOfManufacture" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Expiration Date</label>
                        <input type="text"  class="form-control form-control-alternative" value="${med.meExpirationDate}" name="meExpirationDate" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Status</label>
                        <input type="text"  class="form-control form-control-alternative" value="${med.meStatus}" name="meStatus" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" > Change Image</label>
                        <input type="file"  class="form-control form-control-alternative" value="${med.meImage}" name="meImage" />
                      </div>
                    </div>
                    
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Old Image</label>
                        <img src="../Hospital_Jezt/Common/Images/MedicineImages/${med.meImage}" height="100" with="150"/>
                      </div>
                    </div>
                    
                    <div class="col-lg-6">
                      <div class="form-group">
					<label class="form-control-label" >Department: </label>
					
						<select id="caId" name="caId">
								<option>Choose department</option>
							<c:forEach items="${listCat}" var="cat">
								<option value="${cat.caId}">${cat.caName}</option>
							</c:forEach>
						 </select>
					 </div>
                    </div>
					
                  </div>
                </div>
                <hr class="my-4" />
                <!-- Description -->
                
              </form>
            </div>
          </div>
        </div>
      </div>
      <!-- Footer -->
      
      <%@ include file="Common/IncludeFiles/DirectorFooter.jsp" %>

</html>