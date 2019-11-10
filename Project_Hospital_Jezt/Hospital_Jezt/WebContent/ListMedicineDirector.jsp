<%@ page
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>
    List Medicine
  </title>
  <!-- Favicon -->
  		
  		<%@ include file="Common/IncludeFiles/DirectorHeader.jsp" %>
    
     <div class="container-fluid mt--7">
      <!-- Table -->
      <div class="row">
        <div class="col">
          <div class="card shadow">
            
            <div class="card-header border-0">
              <h3 class="mb-0"><a href="MedicineController?action=initCreateMedicine">Create New Medicine</a></h3>
              </br>
			  <h3>${createMedicineFail}</h3>
			  </br>
			  <h3>${editMedicineFail}</h3>
			  </br>
			  <h3>${deleteMedicineFail}</h3>
			  <form action="MedicineController" >
              	<input type="text" placeholder="Type Name" name="meName" style="border:1px solid #92abe7"/>
              	<input type="submit" value="Find" name="action" style="border-radius:10px;background-color:#92abe7" />
              </form>
              </br>
            </div>
            <div class="table-responsive">
              <table class="table align-items-center table-flush">
                <thead class="thead-light">
                  <tr>
                    <th>ID</th>
					<th>IMAGE</th>
					<th>NAME</th>
					<th>PRICE</th>
					<th>Department ID</th>
                    <th scope="col"></th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="med" items="${listMed}">
                  <tr>
                    <th scope="row">
                      <div class="media align-items-center">
                        
                        <div class="media-body">
                          <span class="mb-0 text-sm">${med.meId}</span>
                        </div>
                      </div>
                    </th>
                    <td>
                      <img src="../Hospital_Jezt/Common/Images/MedicineImages/${med.meImage}" height="100" with="150"/>
                    </td>
                    <td>
                      <span class="badge badge-dot mr-4">
                        <i class="bg-warning"></i> ${med.meName}
                      </span>
                    </td>
                    <td>
                      <span class="badge badge-dot mr-4">
                        <i class="bg-warning"></i> ${med.mePrice}
                      </span>
                    </td>
                    <td>
                      ${med.caId}
                    </td>
                    
                    <td class="text-right">
                      <div class="dropdown">
                        <a class="btn btn-sm btn-icon-only text-light" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          <i class="fas fa-ellipsis-v"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                          <a class="dropdown-item" href="MedicineController?action=initEdit&meId=${med.meId}">Edit</a>
                          <a class="dropdown-item" href="MedicineController?action=detail&meId=${med.meId}">Detail</a>
                          <a class="dropdown-item" href="MedicineController?action=delete&meId=${med.meId}">Delete</a>
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