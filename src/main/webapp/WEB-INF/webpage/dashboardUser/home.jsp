
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
					<i class="fas fa-table"></i> Data Table Example
				</div>
				<div class="card-body">
					<div class="table-responsive">
				
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>Id</th>
									<th>User Name</th>
									<th>Full Name</th>
				
								</tr>
							</thead>
							<tbody>
							
								<c:forEach var="list" items="${listarea }" varStatus="count">
									<tr>
										<td>${list.areaId }</td>
										<td>${list.areaName }</td>
										<td>${list.areaNote }</td>			
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

	<!-- Logout Modal-->
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<!-- Bootstrap Modal content-->
			<div class="modal-content">
				<div class="card-body">
					<div class="table-responsive" id="tableajax">
						<table class="table table-bordered " id="dataTable1" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>Id</th>
									<th>Area Name</th>
									<th>Area Status</th>
									<th>Area Note</th>
								</tr>
							</thead>
							<tbody id="tdbody1">
							
							</tbody>
						</table>
							<div class="modal-body">
          					<p id="greetingId"></p>
       						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- /.content-wrapper -->

	<!-- /.container-fluid -->

	<!-- Sticky Footer -->

</body>
</html>
