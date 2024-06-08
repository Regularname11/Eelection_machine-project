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
          <c:if test="${candidate != null}">
                            <form action="updateCandidate" method="post">
                        </c:if>
                        <c:if test="${candidate == null}">
                            <form action="insertCandidate" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${candidate != null}">
                                    Edit Candidate
                                </c:if>
                                <c:if test="${candidate == null}">
                                    Add New Candidate
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${candidate != null}">
                            <input type="hidden" name="id" value="<c:out value='${candidate.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>First Name</label> <input type="text" value="<c:out value='${candidate.firstName}' />" class="form-control" name="firstName" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Last Name</label> <input type="text" value="<c:out value='${candidate.lastName}' />" class="form-control" name="lastName">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>City</label> <input type="text" value="<c:out value='${candidate.city}' />" class="form-control" name="city">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Age</label> <input type="text" value="<c:out value='${candidate.age}' />" class="form-control" name="age">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Profession</label> <input type="text" value="<c:out value='${candidate.profession}' />" class="form-control" name="profession">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Political Party</label> <input type="text" value="<c:out value='${candidate.politicalParty}' />" class="form-control" name="politicalParty">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Reason</label> <input type="text" value="<c:out value='${candidate.reason}' />" class="form-control" name="reason">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>About</label> <input type="text" value="<c:out value='${candidate.about}' />" class="form-control" name="about">
                        </fieldset>
                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
          
        </main>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <!-- Icons -->
    <script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
    <script>
      feather.replace()
    </script>

    
  </body>
</html>
