
<!DOCTYPE html>
<html>
<head>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- Google font for open sans -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet">

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
</head>
<body>
<div class=content style="max-width: 1100px; margin: 0 auto;">
	
	<h1>Passive Thermal Route Finder</h1>

	<div class="addressForm">
		<form class="form-horizontal">
		<fieldset>

		<!-- Form Name -->
		<legend>Origin / Destination</legend>

		<!-- Search input-->
		<div class="form-group">
		  <label class="col-md-3 control-label" for="start">Origin</label>
		  <div class="col-md-8">
		    <input id="start" name="start" type="search" placeholder="" class="form-control input-md" required="" value="Denver, CO">
		    
		  </div>
		</div>

		<!-- Search input-->
		<div class="form-group">
		  <label class="col-md-3 control-label" for="dest">Destination</label>
		  <div class="col-md-8">
		    <input id="dest" name="dest" type="search" placeholder="" class="form-control input-md" required="" value="Chicago, IL">
		    
		  </div>
		</div>

		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-3 control-label" for="temperature">Temperature</label>  
		  <div class="col-md-4">
		  <input id="temperature" name="temperature" type="text" placeholder="fahrenheit" class="form-control input-md" required="" value="65">
		    
		  </div>

		  <div class="col-md-4">
		    <button id="submit" name="submit" class="btn btn-primary pull-right">Submit</button>
		  </div>
		</div>

		<!-- Button -->
		<div class="form-group">
		</div>

		</fieldset>
		</form>
	</div>
	
	
	<div class="routeList">
	
		<legend>Routes</legend>
	
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Route</th>
					<th>ETA</th>
					<th>Time</th>
					<th>Miles</th>
					<th>Cost (estimated)</th>
					<th>Delta Temperuature +/-</th>
				</tr>
			</thead>
			<tbody>
				
				<tr>
					<td><a href=#>Route 1</a></td>
					<td>5:03 pm - September 25, 2014</td>
					<td>20 hours 3 minutes</td>
					<td>1313 miles</td>
					<td>$89.32</td>
					<td>+ 3</td>
				</tr>
				
				<tr>
					<td><a href=#>Route 2</a></td>
					<td>3:16 pm - September 25, 2014</td>
					<td>19 hours 47 minutes</td>
					<td>1229 miles</td>
					<td>$65.22</td>
					<td>- 4</td>
				</tr>
				
				<tr>
					<td><a href=#>Route 3</a></td>
					<td>4:22 pm - September 25, 2014</td>
					<td>19 hours 32 minutes</td>
					<td>1333 miles</td>
					<td>$84.93</td>
					<td>+ 5</td>
				</tr>
				
				<tr>
					<td><a href=#>Route 4</a></td>
					<td>7:56 pm - September 25, 2014</td>
					<td>21 hours 14 minutes</td>
					<td>1403 miles</td>
					<td>$102.94</td>
					<td>- 6</td>
				</tr>
				
			</tbody>
		</table>
	</div>
	
	
	<div class="routeMap">
	
		<legend>Map</legend>
		
		<iframe
			width="100%"
			height="600"
			frameborder="0" style="border:0"
			src="https://www.google.com/maps/embed/v1/directions?key=AIzaSyAdorDhOfuE0hwHw9lcQgAwLSq1rAzNdvs&origin=Albuquerque,+NM&destination=Chicago,+IL&mode=driving">
		</iframe>
	</div>
</div><!-- / content -->
