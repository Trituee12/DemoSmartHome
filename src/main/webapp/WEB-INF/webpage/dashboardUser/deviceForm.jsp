
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
				<li class="breadcrumb-item active">Area Room</li>
			</ol>
			<div class="row">
				<div class="col-xl-4 col-sm-6 mb-3">
					<div class=" o-hidden h-100">
						<div class="card card-register ">
							<div class="card-header">Form Area</div>
							<div class="card-body">
								<form action="${context }/myarea/add-device" method="POST">
										<div class="form-group">
													<input type="text" id="deviceId" name="deviceId"
														class="form-control" placeholder="Id Area"
														 autofocus="autofocus"> </div>
									<div class="form-group">
										<div class="form-row">
											<div class="col-md-6">
												<div class="form-label-group">
													<input type="text" id="deviceName" name="deviceName"
														class="form-control" placeholder="Status Area"
														required="required"> <label for="deviceName">Device Name</label>
														
														<input type="hidden" id="areaDevices.id" name="areaDevices.id" >
														
														<input type = "hidden" name="nameArea" value="${areaname }"/>
														<input type = "hidden" name="noteArea" value="${areanote }"/>
												</div>
											</div>
										</div>
									</div>							
									<input class="btn btn-primary btn-block" type="submit"
										value="Add" />
								</form>
							</div>
						</div>
					</div>
				</div>
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
										<th>ID</th>
										<th>Device Name</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="list" items="${listmydevice }">
										<tr>
											<td >${list.deviceId }</td>
											<td >${list.deviceName }</td>
											<td style="visibility: hidden">${list.areaDevices.id }</td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
					<div class="card-footer small text-muted">Updated yesterday
						at 11:59 PM</div>
				</div>

			</div>
		</div>
	</div>

  <script language="javascript">
            var tbl = document.getElementById("dataTable");
            if (tbl != null) {
                for (var i = 1; i < tbl.rows.length; i++) {
                    for (var j = 0; j < tbl.rows[i].cells.length; j++)
                        tbl.rows[i].onclick = function () {
                            getval(this);
                        };
                }
                ;
            }
            function getval(cel) {
            	document.getElementById("deviceId").value = cel.cells[0].innerHTML;
                document.getElementById("deviceName").value = cel.cells[1].innerHTML;
                document.getElementById("areaDevices.id").value = cel.cells[2].innerHTML;
            }
        </script>  
	<!-- /.content-wrapper -->

	<!-- /.container-fluid -->

	<!-- Sticky Footer -->
</body>

</html>
