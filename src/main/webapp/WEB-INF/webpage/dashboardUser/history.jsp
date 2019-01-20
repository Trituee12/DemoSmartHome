
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="ISO-8859-1">
</head>
<body id="page-top">





	<div id="content-wrapper">

		<div class="container-fluid">

			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
				<li class="breadcrumb-item active">Overview</li>
			</ol>

			<!-- Area Chart Example-->
			

			<!-- DataTables Example -->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fas fa-table"></i> History Status Device
				</div>
				<div class="card-body">
					<div class="table-responsive">
				
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>Id</th>
									<th>Device Name</th>
									<th>History Date</th>
									<th>Status Device</th>
									<th>USED-ON-OF</th>
								</tr>
							</thead>
							<tbody>
							
								<c:forEach var="list" items="${listhistory }" varStatus="count">
									<tr>
										<td>${list.historyId }</td>
										<td>${list.deviceName }</td>
										<td>${list.historyDate }</td>	
										<td>${list.statusDevice }</td>
										<c:choose>
										<c:when test="${list.used == true}"><td>ON</td></c:when>
										<c:when test="${list.used == false}"><td>OFF</td></c:when>
										</c:choose>
									<!-- 	=================================== -->					
									</tr>
									
								</c:forEach>

							</tbody>
						</table>
					
					
						
					</div>
				</div>
				<div class="card-footer small text-muted">Updated yesterday at
					11:59 PM</div>
			</div>
		</div>
	</div>
</body>
</html>
