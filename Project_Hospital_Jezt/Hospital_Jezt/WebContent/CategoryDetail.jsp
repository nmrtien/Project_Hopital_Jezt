<%@ page
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>
    Department Detail
  </title>
  <!-- Favicon -->
 		
 	<%@ include file="Common/IncludeFiles/DirectorHeader.jsp" %>
    	
     <div class="container-fluid mt--7">
      <!-- Table -->
      <div class="row">
        <div class="col">
          <div class="card shadow">
            <div class="card-header border-0">
              <h3 class="mb-0">Doctor</h3>
            </div>
            
            <div class="table-responsive">
              <table class="table align-items-center table-flush">
                <thead class="thead-light">
                  <tr>
                    <th>ID</th>
                    <th>AVATAR</th>
                    <th>FULLNAME</th>
					<th>ACCOUNT</th>
					<th>PASSWORD</th>
					
					<th>PHONE</th>
					<th>AGE</th>
					<th>EMAIL</th>
					
					<th>ADDRESS</th>
					<th>CONTENT</th>
                    <th scope="col"></th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="doc" items="${listDoc}">
                  <tr>
                    <th scope="row">
                      <div class="badge badge-dot mr-4">
                        
                        <div class="media-body">
                          <span class="mb-0 text-sm">${doc.doId}</span>
                        </div>
                      </div>
                    </th>
                    <td>
                      <img src="${doc.doAvatar}" alt="Doctor face" height="100" width="150">
                    </td>
                    <td>
                      ${doc.doFullName}
                    </td>
                    <td>
                      ${doc.doAcc}
                    </td>
                    <td>
                      <span >
                        <i class="bg-warning"></i> ${doc.doPass}
                      </span>
                    </td>
                    
                    <td>
                      ${doc.doPhone}
                    </td>
                    <td>
                      ${doc.doAge}
                    </td>
                    <td>
                      ${doc.doEmail}
                    </td>
                    
                    <td>${doc.doAddress}</td>
					<td>${doc.doContent}</td>
                    
                    
                  </tr>
                 
                  </c:forEach>
                  
                </tbody>
              </table>
            </div>
            
            </br>
                  <a href="CategoryController?action=getAllCategory" style="width:50px;margin-left:30px ">Back</a>
            
            
          </div>
        </div>
      </div>
      </div>
    
      <%@ include file="Common/IncludeFiles/DirectorFooter.jsp" %>

</html>