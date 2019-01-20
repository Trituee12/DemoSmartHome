<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div id="wrapper">
<ul class="sidebar navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="${context }/myarea/home">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span>
          </a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>My Area</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <c:forEach var="list" items="${listarea }" varStatus="count">
            <h6 class="dropdown-header">${list.areaName }</h6>
            <a class="dropdown-item" href="${context }/myarea/areas/${list.users.userId}/${list.areaName }">Manager Status Device</a>
            <a class="dropdown-item" href="${context} /myarea/my-device/${list.areaName }">My Device</a>
            <div class="dropdown-divider"></div>
            </c:forEach>
          </div>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="${context} /myarea/history-status">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>My history</span>
          </a>
        </li>
      </ul>
       
     
</body>
</html>