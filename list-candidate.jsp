<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Dashboard Template for Bootstrap</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
      <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap4.min.css">
      
    <!-- Custom styles for this template -->
    <link href="style/admin.css" rel="stylesheet">
  </head>

  <body>
    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Election</a>
     
      <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <a class="nav-link" href="<%=request.getContextPath()%>/">Sign out</a>
        </li>
      </ul>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/listCandidate">
                  <span data-feather="users"></span>
                  Candidates
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/listQuestion">
                  <span data-feather="file-text"></span>
                  Questions
                </a>
              </li>
              
            </ul>

            
          </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
      
          <h2>Candidates</h2>
          <div class="container text-left" style="margin-left: 85%;margin-bottom: 2%;">

            <a href="newCandidate" class="btn btn-info">Add New Candidate</a>
          </div>
          <div class="table-responsive">
            <table id="example" class="table table-striped table-bordered" style="width:100%">
              <thead>
                <tr>
                  <th>#</th>
                  <th>First name</th>
                  <th>Last name</th>
                  <th>City</th>
                  <th>Age</th>
                  <th>Profession</th>
                  <th>Political Party</th>
                  <th>Reason</th>
                  <th>About</th>
                  <th>Action</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach var="candidate" items="${listCandidate}">
                <tr>
                  <td><c:out value="${candidate.id}" /></td>
                  <td><c:out value="${candidate.firstName}" /></td>
                  <td><c:out value="${candidate.lastName}" /></td>
                  <td><c:out value="${candidate.city}" /></td>
                  <td><c:out value="${candidate.age}" /></td>
                  <td><c:out value="${candidate.profession}" /></td>
                  <td><c:out value="${candidate.politicalParty}" /></td>
                  <td><c:out value="${candidate.reason}" /></td>
                  <td><c:out value="${candidate.about}" /></td>
                  <td>
                                            <!-- Call to action buttons -->
                                            <ul class="list-inline m-0" style="display: flex;">
                                               
                                                <li class="list-inline-item">
                                                    <a href="editCandidate?id=<c:out value='${candidate.id}' />"><i class="fa fa-edit"></i></a>
                                                </li>
                                                <li class="list-inline-item">
                                                    <a href="deleteCandidate?id=<c:out value='${candidate.id}' />"><i class="fa fa-trash"></i></a>
                                                </li>
                                            </ul>
                                        </td>
                </tr>
                </c:forEach>
                
              </tbody>
            </table>
          </div>
        </main>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
   
    
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <!-- Icons -->
    <script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
    
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
    <script>
	    $(document).ready(function () {
	        $('#example').DataTable();
	    });
      feather.replace()
    </script>

  </body>
</html>
