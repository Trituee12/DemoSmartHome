
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
								<form action="${context }/homepage/addarea" method="POST">
									<div class="form-group">
										<div class="form-row">
											<div class="col-md-12">
												<div class="form-label-group">
													<input type="text" id="areaId" name="areaId"
														class="form-control" placeholder="Id Area"
														required="required" autofocus="autofocus"> <label
														for="areaId">Id Area</label>
												</div>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="form-row">
											<div class="col-md-6">
												<div class="form-label-group">
													<input type="text" id="areaStatus" name="areaStatus"
														class="form-control" placeholder="Status Area"
														required="required"> <label for="areaStatus">Status
														Area</label>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-label-group">
													<input type="text" id="areaName" name="areaName"
														class="form-control" placeholder="Area Name"
														required="required"> <label for="areaName">Area
														Name</label>
												</div>
											</div>
										</div>
									</div>

									<div class="form-group">
										<div class="form-label-group">
											<input type="text" id="areaNote" name="areaNote"
												class="form-control" placeholder="Note Area"
												required="required"> <label for="areaNote">Note
												Area</label>
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
										<th>Area Name</th>
										<th>Area Status</th>
										<th>Area Note</th>
									</tr>
								</thead>
								
								<tbody>
									<c:forEach var="list" items="${listArea }">
										<tr>
											<td >${list.areaId }</td>
											<td >${list.areaName }</td>
											<td >${list.areaStatus }</td>
											<td >${list.areaNote}</td>
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
                document.getElementById("areaId").value = cel.cells[0].innerHTML;
                document.getElementById("areaStatus").value = cel.cells[2].innerHTML;
                document.getElementById("areaName").value = cel.cells[1].innerHTML;
                document.getElementById("areaNote").value = cel.cells[3].innerHTML;
            }
        </script>  
	<!-- /.content-wrapper -->

	<!-- /.container-fluid -->

	<!-- Sticky Footer -->
</body>

</html>
