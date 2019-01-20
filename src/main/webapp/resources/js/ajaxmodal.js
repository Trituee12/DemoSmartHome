$(document).ready(
		function() {

			var url = window.location;

			$(".btnId3").click(function(event) {
				event.preventDefault();
			
				// Open Bootstrap Modal
				openModel1();
				// Get data from Server
				ajaxGet1($(this).val());
				
			})

			// Open Bootstrap Modal
			function openModel1() {
				$("#myModal3").modal();
			}

			// DO GET
			function ajaxGet1(id) {
				var Table = document.getElementById("tbody2");
				var areaName= document.getElementById("nameRoom").innerHTML;
				Table.innerHTML = "";
				$.ajax({
					type : "GET",
					url : "/myarea/"+areaName+"/"+ id,
					success : function(data) {
						// fill data to Modal Body
						fillData1(data);
					},
					error : function(e) {
						fillData1(null);
					}
				});
			}

			function fillData1(data) {
				if (data != null) {

					$.each(data,function(i, AreaDevice) {

								var customerRow = 
										 '<tr> <input type="hidden" name="id" value = "' + AreaDevice.id
										+ '" /> <input type="hidden" name="areas.areaId" value = "' + AreaDevice.id
										+ '" />' + '<td>MonDay</td> </td>'
										+ '<td> <input type="time" name="moStart" value = "' + AreaDevice.moStart
										+ '" /></td>'
										+ '<td> <input type="time" name="moEnd" value = "' + AreaDevice.moEnd
										+ '" /></td>'
										+ '</tr>' +
										'<tr>' + '<td>Tuesday</td> </td>'
										+ '<td> <input type="time" name="tueStart" value = "' + AreaDevice.tueStart
										+ '" /></td>'
										+ '<td> <input type="time" name="tueEnd" value = "' + AreaDevice.tueEnd
										+ '" /></td>'
										+ '</tr>' +
										'<tr>' + '<td>Wednesday</td> </td>'
										+ '<td> <input type="time" name="wedStart" value = "' + AreaDevice.wedStart
										+ '" /></td>'
										+ '<td> <input type="time" name="wedEnd" value = "' + AreaDevice.wedEnd
										+ '" /></td>'
										+ '</tr>' +
										'<tr>' + '<td>Thursday</td> </td>'
										+ '<td> <input type="time" name="thurStart" value = "' + AreaDevice.thurStart
										+ '" /></td>'
										+ '<td> <input type="time" name="thurEnd" value = "' + AreaDevice.thurEnd
										+ '" /></td>'
										+ '</tr>' +
										'<tr>' + '<td>Friday</td> </td>'
										+ '<td> <input type="time" name="friStart" value = "' + AreaDevice.friStart
										+ '" /></td>'
										+ '<td> <input type="time" name="friEnd" value = "' + AreaDevice.friEnd
										+ '" /></td>'
										+ '</tr>' +
										'<tr>' + '<td>Saturday</td> </td>'
										+ '<td> <input type="time" name="staStart" value = "' + AreaDevice.staStart
										+ '" /></td>'
										+ '<td> <input type="time" name="staEnd" value = "' + AreaDevice.staEnd
										+ '" /></td>'
										+ '</tr>' +
										'<tr>' + '<td>Sunday</td> </td>'
										+ '<td> <input type="time" name="sunStart" value = "' + AreaDevice.sunStart
										+ '" /></td>'
										+ '<td> <input type="time" name="sunEnd" value = "' + AreaDevice.sunEnd
										+ '" /></td>'
										+ '</tr>';
								$('#dataTable2 tbody').append(customerRow);

							});
				} else {
					$(".modal-body1 #greetingId1").text(
							"Can Not Get Data from Server!");
				}
			}
		});
		

$(document).ready(
		function() {

			var url = window.location;

			$(".btnId").click(function(event) {
				event.preventDefault();
			
				// Open Bootstrap Modal
				openModel();
				// Get data from Server
				ajaxGet($(this).val());
				
			})

			// Open Bootstrap Modal
			function openModel() {
				$("#myModal1").modal();
			}

			// DO GET
			function ajaxGet(id) {
				var Table = document.getElementById("tdbody1");
				Table.innerHTML = "";
				$.ajax({
					type : "GET",
					url : "/homepage/area/" + id,
					success : function(data) {
						// fill data to Modal Body
						fillData(data);
					},
					error : function(e) {
						fillData(null);
					}
				});
			}

			function fillData(data) {
				if (data != null) {

					$.each(data,function(i, Area) {

								var customerRow = '<tr>' + '<td>' + Area.areaId 
										+ '</td>' + '<td>'
										+ Area.areaName + '</td>'
										+ '<td>' + Area.areaStatus + '</td>'
										+ '<td>' + Area.areaNote
										+ '</td>'
										+ '</tr>';
								$('#dataTable1 tbody').append(customerRow);

							});
				} else {
					$(".modal-body #greetingId").text(
							"Can Not Get Data from Server!");
				}
			}
		});
		
		