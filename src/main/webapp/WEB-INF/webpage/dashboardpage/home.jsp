
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

			<!-- Icon Cards-->
			<div class="row">
				<div class="col-xl-3 col-sm-6 mb-3">
					<div class="card text-white bg-primary o-hidden h-100">
						<div class="card-body">
							<div class="card-body-icon">
								<i class="fas fa-fw fa-user-circle"></i>
							</div>
							<div class="mr-5">${countUser}USER</div>
						</div>
						<a class="card-footer text-white clearfix small z-1" href="#">
							<span class="float-left">View Details</span> <span
							class="float-right"> <i class="fas fa-angle-right"></i>
						</span>
						</a>
					</div>
				</div>
				<div class="col-xl-3 col-sm-6 mb-3">
					<div class="card text-white bg-warning o-hidden h-100">
						<div class="card-body">
							<div class="card-body-icon">
								<i class="fas fa-fw fa-list"></i>
							</div>
							<div class="mr-5">11 New Tasks!</div>
						</div>
						<a class="card-footer text-white clearfix small z-1" href="#">
							<span class="float-left">View Details</span> <span
							class="float-right"> <i class="fas fa-angle-right"></i>
						</span>
						</a>
					</div>
				</div>
				<div class="col-xl-3 col-sm-6 mb-3">
					<div class="card text-white bg-success o-hidden h-100">
						<div class="card-body">
							<div class="card-body-icon">
								<i class="fas fa-fw fa-shopping-cart"></i>
							</div>
							<div class="mr-5">123 New Orders!</div>
						</div>
						<a class="card-footer text-white clearfix small z-1" href="#">
							<span class="float-left">View Details</span> <span
							class="float-right"> <i class="fas fa-angle-right"></i>
						</span>
						</a>
					</div>
				</div>
				<div class="col-xl-3 col-sm-6 mb-3">
					<div class="card text-white bg-danger o-hidden h-100">
						<div class="card-body">
							<div class="card-body-icon">
								<i class="fas fa-fw fa-life-ring"></i>
							</div>
							<div class="mr-5">13 New Tickets!</div>
						</div>
						<a class="card-footer text-white clearfix small z-1" href="#">
							<span class="float-left">View Details</span> <span
							class="float-right"> <i class="fas fa-angle-right"></i>
						</span>
						</a>
					</div>
				</div>
			</div>

			<!-- Area Chart Example-->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fas fa-chart-area"></i> Area Chart Example
				</div>
				<div class="card-body">
					<canvas id="myAreaChart" width="100%" height="30"></canvas>
				</div>
				<div class="card-footer small text-muted">Updated yesterday at
					11:59 PM</div>
			</div>

			<!-- DataTables Example -->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fas fa-table"></i> Data Table Example
				</div>
				<div class="card-body">
					<div class="table-responsive">
					<form action="${context }/homepage/SetRole" method="POST">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>Id</th>
									<th>User Name</th>
									<th>Full Name</th>
									<th>Active</th>
									<th>Role Account</th>
									<th>Register date</th>
								</tr>
							</thead>
							<tbody>
							
								<c:forEach var="list" items="${listUser }" varStatus="count">
									<tr>
										<td><button style="margin: 5px" class="btn btn-success btnId" value="${list.userId}">${list.userId } </button></td>
										<td>${list.userName }</td>
										<td>${list.fullName }</td>
										<c:choose>
											<c:when test="${list.active == true }">
												<td>Đã kích hoạt</td>
											</c:when>
											<c:when test="${list.active == false }">
												<td>Chưa kích hoạt kích hoạt</td>
											</c:when>
										</c:choose>
										
										
										
										<td>
										
										<div class="switch">
															<input type="radio" class="switch-input"
																name="listroleuser[${count.index}].RoleId"
																id="week${count.index}"
															<c:if test="${list.roles.iterator().next().getNameRole() == 'USER'}">checked</c:if>
																value="2"> <label
																for="week${count.index}"
																class="switch-label switch-label-off">USER</label>
															 <input
																type="radio" class="switch-input"
																name="listroleuser[${count.index}].RoleId"
																<c:if test="${list.roles.iterator().next().getNameRole() == 'ADMIN'}">checked</c:if>
																value="1" id="month${count.index}">
																<label for="month${count.index}"
																class="switch-label switch-label-on">ADMIN</label> <span
																class="switch-selection"></span>
														</div>
														
										
									<!-- 	=================================== -->
										<td>${list.registerDate }</td>
										<td hidden=""><input type="hidden" name="listroleuser[${count.index}].UserId" value="${list.userId }"/></td>
									</tr>
									
								</c:forEach>

							</tbody>
						</table>
					
						<div align="center"><input type="submit" class="btn btn-success form-control" style="width: 100px;" value="Save Role"/></div>		
							</form>
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
