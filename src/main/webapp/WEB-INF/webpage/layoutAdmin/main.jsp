<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:importAttribute name="stylecss"/>
<tiles:importAttribute name="js"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="context" value="${pageContext.request.contextPath}" />
  <c:forEach var="css" items="${stylecss}">
        <link rel="stylesheet" type="text/css" href="${css }">
    </c:forEach>
</head>
<body>
	<div>
			<tiles:insertAttribute name="header" />
			<tiles:insertAttribute name="menu" />
			<tiles:insertAttribute name="body" />
			<tiles:insertAttribute name="footer" />
	</div>
	
	 <c:forEach var="script" items="${js}">
        <script src="${script}"></script>
    </c:forEach>
</body>
</html>