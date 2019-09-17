// Set new default font family and font color to mimic Bootstrap's default styling
		Chart.defaults.global.defaultFontFamily = 'Nunito',
		'-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

// Pie Chart Example
var globalurl = "http://localhost:9092/";
/*
 * $(document).ready(function() {
 * 
 * $("#myPieChart").ready(function() { $.ajax({ type : "GET", url : globalurl +
 * "/adminpageApi/" }).success(function(data) { console.log(data); }); }); });
 */

var List =[];
$(document).ready(function() {

	$("#myPieChart").ready(function() {
		
		$.ajax({
			url : globalurl + "/adminpageApi/",
			type : "GET",
			
			success : function(data1) {
				for (var i = 0; i < data1.length; i++) { // Loop through the
															// data & construct
															// the options

					List[i] = data1[i];
					
					

				}
				console.log(List);

				var ctx = document.getElementById("myPieChart");
				var myPieChart = new Chart(ctx,
						{
					
					
							type : 'doughnut',
							data : {
								labels : [ "Images", "Videos", "Articles", "Talks" ],
								datasets : [ {
									data : [List[0], List[1], List[2], List[3]],
									backgroundColor : [ '#4e73df', '#1cc88a', '#36b9cc',
											'#f6c23e' ],
									hoverBackgroundColor : [ '#2e59d9', '#17a673', '#2c9faf',
											'#f6c23e' ], 
									hoverBorderColor : "rgba(234, 236, 244, 1)",
								} ],
							},
							options : {
								maintainAspectRatio : false,
								tooltips : {
									backgroundColor : "rgb(255,255,255)",
									bodyFontColor : "#858796",
									borderColor : '#dddfeb',
									borderWidth : 1,
									xPadding : 15,
									yPadding : 15,
									displayColors : false,
									caretPadding : 10,
								},
								legend : {
									display : false
								},
								cutoutPercentage : 80,
							},
						});
			
			}
		});

	});
});


