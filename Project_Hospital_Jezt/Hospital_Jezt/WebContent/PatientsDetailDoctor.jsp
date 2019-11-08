<%@ page
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Patients</title>
	
	<%@ include file="Common/IncludeFiles/DoctorHeader.jsp" %>
	
    <!-- Page content -->
    <div class="container-fluid mt--7">
      <div class="row">
       
        <div class="col-xl-9 order-xl-1">
          <div class="card bg-secondary shadow">
            <div class="card-header bg-white border-0">
              <div class="row align-items-center">
                <div class="col-8">
                  <h3 class="mb-0">My account</h3>
                </div>
              </div>
            </div>
            <div class="card-body">
              <form>
                <h6 class="heading-small text-muted mb-4">Patients information</h6>
                <div class="pl-lg-4">
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-username">Username</label>
                        <input type="text" id="input-username" class="form-control form-control-alternative" value="${pat.paAcc}" readonly="true" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-email">Password</label>
                        <input type="email" id="input-email" class="form-control form-control-alternative" value="${pat.paPass}" readonly="true" />
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-first-name">FullName</label>
                        <input type="text" id="input-first-name" class="form-control form-control-alternative" value="${pat.paFullName}" readonly="true" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-last-name">ID</label>
                        <input type="number" id="input-last-name" class="form-control form-control-alternative" value="${pat.paId}" readonly="true">
                      </div>
                    </div>
                    
                     <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-last-name">Age</label>
                        <input type="number" id="input-last-name" class="form-control form-control-alternative" value="${pat.paAge}" readonly="true">
                      </div>
                    </div>
                     <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-last-name">Description</label>
                        <input type="text" id="input-last-name" class="form-control form-control-alternative" value="${pat.paContent}" readonly="true">
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-last-name">Doctor Id</label>
                        <input type="text" id="input-last-name" class="form-control form-control-alternative" value="${pat.doId}" readonly="true">
                      </div>
                    </div>
                     <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-last-name"></label>
                        <img alt="" src="../Hospital_Jezt/Common/Images/PatientsImages/${pat.paAvatar}" with="200px" height="200px">
                      </div>
                    </div>
                    
                  </div>
                  
                </div>
               
              </form>
            </div>
          </div>
        </div>
      </div>
      
     <%@ include file="Common/IncludeFiles/DoctorFooter.jsp" %>

</body>
</html>