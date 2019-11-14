<%@ page
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Oder Detail</title>

	<%@ include file="Common/IncludeFiles/DirectorHeader.jsp" %>
    
     <div class="container-fluid mt--7">
      <!-- Table -->
      <div class="row">
        <div class="col">
          <div class="card shadow">
            
            <div class="table-responsive">
              <table class="table align-items-center table-flush">
                <thead class="thead-light">
                  <tr>
                    <th>ID</th>
					<th>MEDICINE</th>
					<th>QUANTITY</th>
					<th>PRICE</th>
					<th>AMOUNT</th>
					<th>ODER ID</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="odd" items="${listOdd}">
                  <tr>
                    <th scope="row">
                      <div class="media align-items-center">
                        
                        <div class="media-body">
                          <span class="mb-0 text-sm">${odd.oddId}</span>
                        </div>
                      </div>
                    </th>
                    <td>
                      <span class="badge badge-dot mr-4">
                        <i class="bg-warning"></i> ${odd.oddMeName}
                      </span>
                    </td>
                    <td>
                      <span class="badge badge-dot mr-4">
                        <i class="bg-warning"></i> ${odd.oddMeQuantity}
                      </span>
                    </td>
                    <td>
                      ${odd.oddMePrice}
                    </td>
                    <td>
                      ${odd.oddAmount}
                    </td>
                    <td>
                      ${odd.odId}
                    </td>
                    <td class="text-right">
                      
                    </td>
                  </tr>
                 
                  </c:forEach>
                  
                </tbody>
              </table>
              </br>
                  <a href="OderController?action=getAllOder" style="width:50px;margin:30px ">Back</a>
            </div>
            
          </div>
        </div>
      </div>
      </div>
    
      <!-- Footer -->
      
       
      <%@ include file="Common/IncludeFiles/DirectorFooter.jsp" %>

</html>