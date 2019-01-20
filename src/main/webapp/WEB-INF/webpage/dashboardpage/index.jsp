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
          <form action="${context }/checklogin" method="POST">
            <div class="form-group">
              <div class="form-label-group">
                <input type="text" name="username" id="username" class="form-control" placeholder="User Name..." required="required" autofocus="autofocus">
                <label for="username">User Name </label>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
                <input type="password" name="password" id="password" class="form-control" placeholder="Password...." required="required">
                <label for="password">Password</label>
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
            <input type="submit" class="btn btn-primary btn-block" value="Login" />
          </form>
          <div class="text-center">
            <a class="d-block small mt-3" href="${context }/register">Register an Account</a>
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