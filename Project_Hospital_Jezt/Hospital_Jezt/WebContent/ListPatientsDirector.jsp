<%@ page
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Patients</title>

	<%@ include file="Common/IncludeFiles/DirectorHeader.jsp" %>

	<div class="container-fluid mt--7">
      <!-- Table -->
      <div class="row">
        <div class="col">
          <div class="card shadow">
            
            <div class="card-header border-0">
              
              <form action="PatientsController" style="margin-top:20px">
              	<input type="text" placeholder="Type Name" name="paFullName" style="border:1px solid #92abe7"/>
              	<input type="submit" value="Search" name="action" style="border-radius:40%;background-color:#92abe7;color:white" />
              </form>            
			 
            </div>
            <div class="table-responsive">
              <table class="table align-items-center table-flush">
                <thead class="thead-light">
                  <tr>
                    <th>ID</th>
					<th>AVATAR</th>
					<th>FULLNAME</th>
					<th>EMAIL</th>
					<th>CONTENT</th>
                    <th scope="col"></th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="pat" items="${listPat}">
                  <tr>
                    <th scope="row">
                      <div class="media align-items-center">
                        
                        <div class="media-body">
                          <span class="mb-0 text-sm">${pat.paId}</span>
                        </div>
                      </div>
                    </th>
                    <td>
                      <img src="../Hospital_Jezt/Common/Images/PatientsImages/${pat.paAvatar}" height="100" with="150"/>
                    </td>
                    <td>
                      <span class="badge badge-dot mr-4">
                        <i class="bg-warning"></i> ${pat.paFullName}
                      </span>
                    </td>
                    <td>
                      <span class="badge badge-dot mr-4">
                        <i class="bg-warning"></i> ${pat.paEmail}
                      </span>
                    </td>
                    <td>
                      ${pat.paContent}
                    </td>
                    
                    <td class="text-right">
                      <div class="dropdown">
                        <a class="btn btn-sm btn-icon-only text-light" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          <i class="fas fa-ellipsis-v"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                   			
                          
                          
                          <a class="dropdown-item" href="PatientsController?action=getPatientsByIdDirector&paId=${pat.paId}">Detail</a>
                          <a class="dropdown-item" href="PatientsController?action=delete&paId=${pat.paId}">Delete</a>
                          
                        </div>
                      </div>
                    </td>
                  </tr>
                 
                  </c:forEach>
                  
                </tbody>
              </table>
              
            </div>
            
          </div>
        </div>
      </div>
      </div>


	<%@ include file="Common/IncludeFiles/DirectorFooter.jsp" %>
</html>