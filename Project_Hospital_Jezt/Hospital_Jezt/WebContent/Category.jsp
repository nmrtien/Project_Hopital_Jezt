<%@ page
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>
    Department Home
  </title>
  <!-- Favicon -->
  
    <%@ include file="Common/IncludeFiles/DirectorHeader.jsp" %>
    
     <div class="container-fluid mt--7">
      <!-- Table -->
      <div class="row">
        <div class="col">
          <div class="card shadow">
            
            <div class="card-header border-0">
              <h3 class="mb-0"><a href="CreateCategory.jsp">Create New Department</a></h3>
              <h3>${deleteFail}</h3>
            </div>
            <div class="table-responsive">
              <table class="table align-items-center table-flush">
                <thead class="thead-light">
                  <tr>
                    <th>ID</th>
					<th>NAME</th>
					<th>CONTENT</th>
					<th>STATUS</th>
                    <th scope="col"></th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="cat" items="${listCat}">
                  <tr>
                    <th scope="row">
                      <div class="media align-items-center">
                        
                        <div class="media-body">
                          <span class="mb-0 text-sm">${cat.caId}</span>
                        </div>
                      </div>
                    </th>
                    <td>
                      ${cat.caName}
                    </td>
                    <td>
                      <span class="badge badge-dot mr-4">
                        <i class="bg-warning"></i> ${cat.caContent}
                      </span>
                    </td>
                    <td>
                      ${cat.caStatus}
                    </td>
                    
                    <td class="text-right">
                      <div class="dropdown">
                        <a class="btn btn-sm btn-icon-only text-light" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          <i class="fas fa-ellipsis-v"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                          <a class="dropdown-item" href="CategoryController?action=initEdit&caId=${cat.caId}">Edit</a>
                          <a class="dropdown-item" href="CategoryController?action=getDoctorWithCaId&caId=${cat.caId}">Detail</a>
                          <a class="dropdown-item" href="CategoryController?action=delete&caId=${cat.caId}">Delete</a>
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
    
      <!-- Footer -->
         <%@ include file="Common/IncludeFiles/DirectorFooter.jsp" %> 

</html>