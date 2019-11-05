<%@ page
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<title>MedicineDetail</title>

	<%@ include file="Common/IncludeFiles/DoctorHeader.jsp" %>
	
	 <div class="container-fluid mt--7">
      <div class="row">
       
        <div class="col-xl-10 order-xl-1">
          <div class="card bg-secondary shadow">
          
            <div class="card-header bg-white border-0">
              <div class="row align-items-center">
                <div class="col-8">
                  <h3 class="mb-0">Medicine</h3>
                  
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
                        <input type="text" class="form-control form-control-alternative" value="${med.meName}" readonly="true" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Price</label>
                        <input type="text"  class="form-control form-control-alternative" value="${med.mePrice}" readonly="true" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-username">ID</label>
                        <input type="text" class="form-control form-control-alternative" value="${med.meId}" readonly="true" />
                      </div>
                    </div>
                  

                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Producer</label>
                        <input type="text"  class="form-control form-control-alternative" value="${med.meProducer}" readonly="true" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Title</label>
                        <input type="text"  class="form-control form-control-alternative" value="${med.meTitle}" readonly="true" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Content</label>
                        <input type="text"  class="form-control form-control-alternative" value="${med.meContent}" readonly="true" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Date Of Manufacture</label>
                        <input type="text"  class="form-control form-control-alternative" value="${med.meDateOfManufacture}" readonly="true" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Expiration Date</label>
                        <input type="text"  class="form-control form-control-alternative" value="${med.meExpirationDate}" readonly="true" />
                      </div>
                    </div>
                   
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Department ID</label>
                        <input type="text"  class="form-control form-control-alternative" value="${med.caId}" readonly="true" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Status</label>
                        <input type="text"  class="form-control form-control-alternative" value="${med.meStatus}" readonly="true" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-last-name"></label>
                        <img alt="" src="${med.meImage}" with="500px" height="200px">
                      </div>
                    </div>
                     
                   </div>
                  </div>
                
                </div>
                </br>
                  <a href="MedicineController?action=getMedicineWithCaId&caId=${med.caId}" style="width:50px;margin-left:30px ">Back</a>
              
            </div>
          </div>
        </div>
      </div>
	
	<%@ include file="Common/IncludeFiles/DoctorFooter.jsp" %>
	
</html>