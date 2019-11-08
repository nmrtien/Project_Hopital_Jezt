<%@ page
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Patients</title>

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
                  <h3>${createFail}</h3>
                </div>
                <div class="col-4 text-right">
                  <input type="submit" value="EDIT" name="action" class="btn btn-sm btn-primary" />
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
                        <input type="text" class="form-control form-control-alternative" placeholder="${accFail}" value="${pat.paAcc}" name="paAcc" readonly="true"/>
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Password</label>
                        <input type="text"  class="form-control form-control-alternative" placeholder="${passFail}" value="${pat.paPass}" name="paPass" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-username">ID</label>
                        <input type="text" class="form-control form-control-alternative" value="${pat.paId}" name="paId" readonly="true" />
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >FullName</label>
                        <input type="text"  class="form-control form-control-alternative" placeholder="${fullnameFail}" value="${pat.paFullName}" name="paFullName" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Phone</label>
                        <input type="text"  class="form-control form-control-alternative" placeholder="${phoneFail}" value="${pat.paPhone}" name="paPhone" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Age</label>
                        <input type="text"  class="form-control form-control-alternative" placeholder="${ageFail}" value="${pat.paAge}" name="paAge" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Email</label>
                        <input type="text"  class="form-control form-control-alternative" placeholder="${emailFail}" value="${pat.paEmail}" name="paEmail" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Change Avatar</label>
                        <input type="file"  class="form-control form-control-alternative" placeholder="${avatarFail}"  name="paAvatar" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Avatar</label>
                        <img src="../Hospital_Jezt/Common/Images/PatientsImages/${pat.paAvatar}" height="100" with="150"/>
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Address</label>
                        <input type="text"  class="form-control form-control-alternative" placeholder="${addressFail}" value="${pat.paAddress}" name="paAddress" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Content</label>
                        <input type="text"  class="form-control form-control-alternative"  value="${pat.paContent}" name="paContent" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Status</label>
                        <input type="text"  class="form-control form-control-alternative"  value="${pat.paStatus}" name="paStatus" />
                      </div>
                    </div>
                    
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Doctor ID</label>
                        <input type="text"  class="form-control form-control-alternative"  value="${pat.doId}" name="doId" readonly="true" />
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