<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:importAttribute name="stylecss"/>
<tiles:importAttribute name="js"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
  <c:forEach var="css" items="${stylecss}">
        <link rel="stylesheet" type="text/css" href="${css }">
    </c:forEach>
</head>
<body class="bg-dark">

    <div class="container">
      <div class="card card-login mx-auto mt-5">
        <div class="card-header">Login</div>
        <div class="card-body">
          <form action="${context} /registerUser" method="POST" >
           
                <input type="hidden" name="userId">
                
                 <div class="form-group">
              <div class="form-label-group">
                <input type="text" name="fullName" id="fullName" class="form-control" placeholder="Full Name..." required="required">
                <label for="fullName">Full Name</label>
              </div>
            </div>
               
             <div class="form-group">
              <div class="form-label-group">
                <input type="text" name="userName"  id="userName" class="form-control" placeholder="User Name..." required="required" >
                <label for="userName">User Name</label>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
                <input type="password" name="passwordEcryted"  id="passwordEcryted" class="form-control" placeholder="Password...." required="required">
                <label for="passwordEcryted">Password</label>
              </div>
            </div>
            <div class="form-group">
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="remember-me">
                  Remember Password
                </label>
              </div>
            </div>
            <input class="btn btn-primary btn-block" type="submit" value="Register" />
          </form>
          <div class="text-center">
            <a class="d-block small mt-3" href="register.html">Register an Account</a>
            <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
          </div>
        </div>
      </div>
    </div>
	
	 <c:forEach var="script" items="${js}">
        <script src="${js}"></script>
    </c:forEach>
  </body>
</html>