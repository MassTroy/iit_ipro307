
	<div class="addressForm">
		<form class="form-horizontal" action="submit" method="POST">
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
