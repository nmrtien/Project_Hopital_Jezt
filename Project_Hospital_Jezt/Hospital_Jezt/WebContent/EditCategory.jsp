<%@ page
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>
    Edit Department
  </title>
  <!-- Favicon -->
  
  		<%@ include file="Common/IncludeFiles/DirectorHeader.jsp" %>
  
    <!-- Page content -->
    <div class="container-fluid mt--7">
      <div class="row">
       
        <div class="col-xl-10 order-xl-1">
          <div class="card bg-secondary shadow">
          <form action="CategoryController">
            <div class="card-header bg-white border-0">
              <div class="row align-items-center">
                <div class="col-8">
                  <h3 class="mb-0">Department</h3>
                </div>
                <div class="col-4 text-right">
                  <input type="submit" value="SAVE" name="action" class="btn btn-sm btn-primary" />
                </div>
              </div>
            </div>
            <div class="card-body">
              
                <h6 class="heading-small text-muted mb-4">Department information</h6>
                <div class="pl-lg-4">
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-username">Department</label>
                        <input type="text" class="form-control form-control-alternative" value="${cat.caName}" name="caName" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Content</label>
                        <input type="text"  class="form-control form-control-alternative" value="${cat.caContent}" name="caContent" />
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >Status</label>
                        <input type="text"  class="form-control form-control-alternative" value="${cat.caStatus}" name="caStatus" />
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" >ID</label>
                        <input type="text"  class="form-control form-control-alternative" value="${cat.caId}" name="caId" readonly="true">
                      </div>
                    </div>
                    
                  </div>
                </div>
                <hr class="my-4" />
                <!-- Address -->
                
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