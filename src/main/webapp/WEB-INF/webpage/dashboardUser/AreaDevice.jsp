
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="ISO-8859-1">

<link type="text/css" href="css/bootstrap.min.css" />
        <link type="text/css" href="css/bootstrap-timepicker.min.css" />
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap-2.2.2.min.js"></script>
        <script type="text/javascript" src="js/bootstrap-timepicker.min.js"></script>
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


			<!-- DataTables Example -->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fas fa-table"></i><span id="nameRoom" >${nameRoom }</span>
				</div>
				<div class="card-body">

					<form:form modelAttribute="deviceStatus"
						action="${context }/myarea/setdevice" method="POST">
						<table class="table table-bordered" width="100%" cellspacing="0">
							<thead>
								<tr>
									<th>Device</th>
									<th>USED</th>
									<th>SMS</th>
									<th>CALL</th>
									<th>OUTPU1</th>
									<th>OUTPUT2</th>
									<th>Loa</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="list" items="${listad}" varStatus="count">
								<tr>
										<input type="hidden" name="listStatus[${count.index}].statusId" value="${list.statusId}" />
											<input type="hidden" name="listStatus[${count.index}].deviceName" value="${list.devices.deviceName}" />
											<input type="hidden" name="listStatus[${count.index}].devices.deviceId" value="${list.devices.deviceId}" />
										<td><button type="button"  style="margin: 5px" class="btn btn-success btnId3" value="${list.devices.deviceId}">${list.devices.deviceName}</button></td>
										<td><input type="checkbox" name="listStatus[${count.index}].used" value = "true"
											<c:if test="${list.used == true}"> checked="checked" </c:if> />
										</td>
										<td><input type="checkbox" name="listStatus[${count.index}].sms" value = "true"
											<c:if test="${list.sms == true}"> checked="checked" </c:if> />
										</td>
										<td><input type="checkbox" name="listStatus[${count.index}].call" value = "true"
											<c:if test="${list.call == true}"> checked="checked" </c:if> />
										</td>
										<td><select name="listStatus[${count.index}].outPut1">
												<c:forEach var="listnumber" items="${number }">
													<option
														<c:if test="${list.outPut1 == listnumber}">selected="selected"</c:if>
														value="${listnumber }">${listnumber }</option>
												</c:forEach>
										</select></td>
										<td><select name="listStatus[${count.index}].outPut2">
												<c:forEach var="listnumber" items="${number }">
													<option
														<c:if test="${list.outPut2 == listnumber}">selected="selected"</c:if>
														value="${listnumber }">${listnumber }</option>
												</c:forEach>
										</select></td>
										<td><input type="checkbox" name="listStatus[${count.index}].loa" value = "true"
											<c:if test="${list.loa == true}"> checked="checked" </c:if> />
										</td>
										<!-- 	=================================== -->
									
								</tr>
								</c:forEach>
							</tbody>
						</table>
						<div align="center">
							<input type="submit" value="Lưu"
								class="btn btn-success form-control"  style="width: 100px" />
						</div>
					</form:form>
				</div>
				
			
				
				<div class="card-footer small text-muted">Updated yesterday at
					11:59 PM</div>
			</div>
		</div>
	</div>

	<!-- Logout Modal-->
	<div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<!-- Bootstrap Modal content-->
			<div class="modal-content">
				<div class="card-body">
					<div class="table-responsive" id="tableajax">
						<form
						action="${context }/myarea/setdevice-area" method="POST">
						<table class="table table-bordered" id="dataTable2" width="100%" cellspacing="0">
							<thead>
								<tr>
									<th>Name</th>
									<th>ON</th>
									<th>OFF</th>
								</tr>
							</thead>
								<tbody id="tbody2">		
								
							</tbody>
						</table>
						<div align="center">
							<input type="submit" value="Lưu"
								class="btn btn-success form-control" style="width: 100px" />
						</div>
					</form>
						<div class="modal-body1">
							<p id="greetingId1"></p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
