<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ page import = "java.util.ArrayList" %>
 <%@ page import="model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Election</title>

    <!-- Bootstrap core CSS -->
    <style type="text/css">
     body {
  			padding-top: 3.5rem;
		}
    </style>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="jumbotron.css" rel="stylesheet">
  </head>

  <body>

    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">Election</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="<%=request.getContextPath()%>/">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link"  href="<%=request.getContextPath()%>/loginPage">Admin</a>
          </li>
        </ul>
        
      </div>
    </nav>

    <main role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <div class="container">
          <h1 class="display-3">Find your candidate</h1>
          <p>FOR THE UPCOMING ELECTION</p>
          <p><a class="btn btn-primary btn-lg" href="<%=request.getContextPath()%>/test" role="button">Take the test</a></p>
        </div>
      </div>
      <h1 class="container" style="text-decoration: underline;margin-bottom: 2%">CANDIDATES</h1>
      <div class="container">
        <!-- Example row of columns -->
        <div class="row">
        
        <div class="col-md-6">
        <h2>Your answers</h2>
        <c:forEach var="answers" items="${allAnswer.answerPublic}">
            <div>
             <p><c:out value="${answers.question}" /> : <b> <c:out value="${answers.answer}" /> </b></p>
            </div>
        </c:forEach>
        </div>
       
       <div class="col-md-6">
        <h2>Candidate answers</h2>
        <c:forEach var="answer" items="${allAnswer.answerCandidate}">
            <h2><c:out value="${answer.candidateName}" /></h2><a  href="details?id=<c:out value='${answer.candidateId}' />">more details</a>
            <c:forEach var="an" items="${answer.listAnswer}">
            <div>
             <p><c:out value="${an.question}" /> :<b> <c:out value="${an.answer}" /> </b></p>
            </div>
            </c:forEach>
        </c:forEach>
        </div>
      </div>
        
        <hr>

      </div> <!-- /container -->

    </main>

    <footer class="container">
      <p>&copy; Election 2022</p>
    </footer>

    <!-- Bootstrap core JavaScript
    ================================================== -->
   <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>
