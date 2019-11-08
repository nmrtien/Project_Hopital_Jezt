<%@ page
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>
    List Doctor Home
  </title>
  <!-- Favicon -->
  
       <%@ include file="Common/IncludeFiles/DirectorHeader.jsp" %>
    
     <div class="container-fluid mt--7">
      <!-- Table -->
      <div class="row">
        <div class="col">
          <div class="card shadow">
            
            <div class="card-header border-0">
              <h3 class="mb-0"><a href="DoctorController?action=initCreateDoctor">Create New Doctor</a></h3>
              
			  <h3>${createDoctorFail}</h3>
			  
			  <h3>${editDoctorFail}</h3>
			  
			  <h3>${deleteDoctorFail}</h3>
            </div>
            <div class="card-header border-0">
              
              <form action="DoctorController" style="margin-top:20px">
              	<input type="text" placeholder="Type Name" name="doFullName" style="border:1px solid #92abe7"/>
              	<input type="submit" value="Search" name="action" style="border-radius:10px;background-color:#92abe7" />
              </form>            
			 
            </div>
            <div class="table-responsive">
              <table class="table align-items-center table-flush">
                <thead class="thead-light">
                  <tr>
                    <th>ID</th>
					<th>AVATAR</th>
					<th>FULLNAME</th>
					<th>Department</th>
                    <th scope="col"></th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="doc" items="${listDoc}">
                  <tr>
                    <th scope="row">
                      <div class="media align-items-center">
                        
                        <div class="media-body">
                          <span class="mb-0 text-sm">${doc.doId}</span>
                        </div>
                      </div>
                    </th>
                    <td>
                      <img src="../Hospital_Jezt/Common/Images/DoctorImages/${doc.doAvatar}" height="100" with="150"/>
                    </td>
                    <td>
                      <span class="badge badge-dot mr-4">
                        <i class="bg-warning"></i> ${doc.doFullName}
                      </span>
                    </td>
                    <td>
                      ${doc.caId}
                    </td>
                    
                    <td class="text-right">
                      <div class="dropdown">
                        <a class="btn btn-sm btn-icon-only text-light" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          <i class="fas fa-ellipsis-v"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                         
                          <a class="dropdown-item" href="DoctorController?action=initEdit&doId=${doc.doId}">Detail</a>
                          <a class="dropdown-item" href="DoctorController?action=delete&doId=${doc.doId}">Delete</a>
                        </div>
                      </div>
                    </td>
                  </tr>
                 
                  </c:forEach>
                  
                </tbody>
              </table>
              </br>
                  <a href="DoctorController?action=getAllDoctor" style="width:50px;margin:30px ">Back</a>
            </div>
            
          </div>
        </div>
      </div>
      </div>
    
      <!-- Footer -->
      
      <%@ include file="Common/IncludeFiles/DirectorFooter.jsp" %>

</html>