<%@ page
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Patients</title>
	
	<%@ include file="Common/IncludeFiles/DoctorHeader.jsp" %>
	
	<div class="container-fluid mt--7">
      <div class="row">
       
        <div class="col-xl-10 order-xl-1">
          <div class="card bg-secondary shadow">
          <form action="PatientsController">
            <div class="card-header bg-white border-0">
              <div class="row align-items-center">
                <div class="col-8">
                  <h3 class="mb-0">Doctor</h3>
                  <h3>${message}</h3>
                </div>
                <div class="col-4 text-right">
                  <input type="submit" value="CREATE" name="action" class="btn btn-sm btn-primary" />
                </div>
              </div>
            </div>
            <div class="card-body">
              
                <h6 class="heading-small text-muted mb-4">Patients information</h6>
                <div class="pl-lg-4">
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-username">Username</label>
                        <input type="text" class="form-control form-control-alternative" placeholder="${accFail}${accFail02}" name="paAcc" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Password</label>
                        <input type="text"  class="form-control form-control-alternative" placeholder="${passFail}" name="paPass" />
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >FullName</label>
                        <input type="text"  class="form-control form-control-alternative" placeholder="${fullnameFail}" name="paFullName" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Phone</label>
                        <input type="text"  class="form-control form-control-alternative" placeholder="${phoneFail}" name="paPhone" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Age</label>
                        <input type="text"  class="form-control form-control-alternative" placeholder="${ageFail}" name="paAge" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Email</label>
                        <input type="text"  class="form-control form-control-alternative" placeholder="${emailFail}" name="paEmail" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Avatar</label>
                        <input type="file"  class="form-control form-control-alternative" placeholder="${avatarFail}" name="paAvatar" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Address</label>
                        <input type="text"  class="form-control form-control-alternative" placeholder="${addressFail}" name="paAddress" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Content</label>
                        <input type="text"  class="form-control form-control-alternative" name="paContent" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Status</label>
                        <input type="text"  class="form-control form-control-alternative" name="paStatus" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Doctor ID</label>
                        <input type="text"  class="form-control form-control-alternative" value="${doc.doId}" name="doId" readonly="true" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Roll ID</label>
                        <input type="text"  class="form-control form-control-alternative" value="${pat.rollId}" name="rollId" readonly="true" />
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
      
    <%@ include file="Common/IncludeFiles/DoctorFooter.jsp" %>

</body>
</html>