<%@ page
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>
    Director Information
  </title>
  <!-- Favicon -->
  
 	<%@ include file="Common/IncludeFiles/DirectorHeader.jsp" %>
 	
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
                <div class="col-4 text-right">
                  <a href="DirectorController?action=initEditDirector&diId=${dir.diId}" class="btn btn-sm btn-primary" >EDIT</a>
                </div>
              </div>
            </div>
            <div class="card-body">
              <form>
                <h6 class="heading-small text-muted mb-4">Director information</h6>
                <div class="pl-lg-4">
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-username">Username</label>
                        <input type="text" id="input-username" class="form-control form-control-alternative" value="${dir.diAcc}" readonly="true" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-email">Password</label>
                        <input type="email" id="input-email" class="form-control form-control-alternative" value="${dir.diPass}" readonly="true" />
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-first-name">FullName</label>
                        <input type="text" id="input-first-name" class="form-control form-control-alternative" value="${dir.diFullName}" readonly="true" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-last-name">ID</label>
                        <input type="number" id="input-last-name" class="form-control form-control-alternative" value="${dir.diId}" readonly="true">
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
                        <label class="form-control-label" for="input-address">Phone</label>
                        <input id="input-address" class="form-control form-control-alternative" value="${dir.diPhone}" readonly="true" type="text" />
                      </div>
                    </div>
                  </div>
                 
                </div>
                <hr class="my-4" />
                <!-- Description -->
                <h6 class="heading-small text-muted mb-4">NOTICE</h6>
                <div class="pl-lg-4">
                  <div class="form-group">
                    <label>Notice</label>
                    <input type="text" class="form-control form-control-alternative" value="${dir.diContent}" readonly="true" />
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