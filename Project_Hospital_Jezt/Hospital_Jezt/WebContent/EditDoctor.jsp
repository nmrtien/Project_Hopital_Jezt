<%@ page
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>
    Edit Doctor
  </title>
  <!-- Favicon -->
  
  		<%@ include file="Common/IncludeFiles/DirectorHeader.jsp" %>
  
    <!-- Page content -->
    <div class="container-fluid mt--7">
      <div class="row">
       
        <div class="col-xl-10 order-xl-1">
          <div class="card bg-secondary shadow">
          <form action="DoctorController">
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
              
                <h6 class="heading-small text-muted mb-4">Doctor information</h6>
                <div class="pl-lg-4">
                  <div class="row">
                  
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-username">Username</label>
                        <input type="text" class="form-control form-control-alternative" value="${doc.doAcc}" name="doAcc" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Password</label>
                        <input type="text"  class="form-control form-control-alternative" value="${doc.doPass}" name="doPass" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-username">ID</label>
                        <input type="text" class="form-control form-control-alternative" value="${doc.doId}" name="doId" readonly="true" />
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >FullName</label>
                        <input type="text"  class="form-control form-control-alternative" value="${doc.doFullName}" name="doFullName" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Phone</label>
                        <input type="text"  class="form-control form-control-alternative" value="${doc.doPhone}" name="doPhone" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Age</label>
                        <input type="text"  class="form-control form-control-alternative" value="${doc.doAge}" name="doAge" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Email</label>
                        <input type="text"  class="form-control form-control-alternative" value="${doc.doEmail}" name="doEmail" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Avatar</label>
                        <input type="text"  class="form-control form-control-alternative" value="${doc.doAvatar}" name="doAvatar" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Address</label>
                        <input type="text"  class="form-control form-control-alternative" value="${doc.doAddress}" name="doAddress" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Content</label>
                        <input type="text"  class="form-control form-control-alternative" value="${doc.doContent}" name="doContent" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Status</label>
                        <input type="text"  class="form-control form-control-alternative" value="${doc.doStatus}" name="doStatus" />
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