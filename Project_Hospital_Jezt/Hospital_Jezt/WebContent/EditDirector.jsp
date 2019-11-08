<%@ page
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>
    Edit Director
  </title>
  <!-- Favicon -->
  
  		<%@ include file="Common/IncludeFiles/DirectorHeader.jsp" %>
  
    <!-- Page content -->
    <div class="container-fluid mt--7">
      <div class="row">
       
        <div class="col-xl-10 order-xl-1">
          <div class="card bg-secondary shadow">
          <form action="DirectorController">
            <div class="card-header bg-white border-0">
              <div class="row align-items-center">
                <div class="col-8">
                  <h3 class="mb-0">My account</h3>
                  </br>
                  <h4>${message}</h4>
                </div>
                <div class="col-4 text-right">
                  <input type="submit" value="SAVE" name="action" class="btn btn-sm btn-primary" />
                </div>
              </div>
            </div>
            <div class="card-body">
              
                <h6 class="heading-small text-muted mb-4">User information</h6>
                <div class="pl-lg-4">
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-username">Username: ${accFail}</label>
                        <input type="text" class="form-control form-control-alternative" placeholder="" value="${dir.diAcc}" name="diAcc" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Password: ${passFail}</label>
                        <input type="text"  class="form-control form-control-alternative" placeholder="" value="${dir.diPass}" name="diPass" />
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >FullName: ${fullNameFail}</label>
                        <input type="text"  class="form-control form-control-alternative" placeholder="" value="${dir.diFullName}" name="diFullName" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >ID</label>
                        <input type="text"  class="form-control form-control-alternative" value="${dir.diId}" name="diId" readonly="true">
                      </div>
                    </div>
                    
                  </div>
                </div>
                <hr class="my-4" />
                <!-- Address -->
                <h6 class="heading-small text-muted mb-4">Contact information</h6>
                <div class="pl-lg-4">
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group">
                        <label class="form-control-label" >Phone: ${phoneFail}</label>
                        <input  class="form-control form-control-alternative"  value="${dir.diPhone}" name="diPhone" type="text" />
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    
                    
                    
                  </div>
                </div>
                <hr class="my-4" />
                <!-- Description -->
                <h6 class="heading-small text-muted mb-4">NOTICE</h6>
                <div class="pl-lg-4">
                  <div class="form-group">
                    <label>Notice</label>
                    <input type="text" class="form-control form-control-alternative" value="${dir.diContent}" name="diContent" />
                  </div>
                </div>
                <div class="pl-lg-4">
                  <div class="form-group">
                    <label>RollId</label>
                    <input type="text" class="form-control form-control-alternative" value="${dir.rollId}" name="rollId" readonly="true" />
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
      <!-- Footer -->
      
      <%@ include file="Common/IncludeFiles/DirectorFooter.jsp" %>

</html>