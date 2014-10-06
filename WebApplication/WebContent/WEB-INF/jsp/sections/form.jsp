
<div class="addressForm">
	<legend>Origin / Destination</legend>
	<form class="form-horizontal" name="form" action="submit" method="POST">
		<fieldset>

			<div class="form-group">
				<label class="col-md-2 control-label" for="start">Origin</label>
				<div class="col-md-8">
					<input id="origin" name="origin" type="search" placeholder=""
						class="form-control input-md" required="">

				</div>
			</div>

			<!-- Search input-->
			<div class="form-group">
				<label class="col-md-2 control-label" for="dest">Destination</label>
				<div class="col-md-8">
					<input id="destination" name="destination" type="search" placeholder=""
						class="form-control input-md" required="">

				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-2 control-label" for="startTemp">
					Starting Temperature</label>
				<div class="col-md-2">
					<input id="startTemp" name="startTemp" type="text" placeholder=""
						class="form-control input-md">
				</div>
				
				
				<label class="col-md-2 control-label" for="unit">Unit</label>
				<div class="col-md-4" style="margin-left: 15px;">
					<label class="radio" for="unit-fahrenheit">
					<input type="radio" name="unit" id="unit-fahrenheit"
						value="Fahrenheit" checked="checked" required="required">
						Fahrenheit
					</label>
					<label class="radio" for="unit-celsius">
						<input type="radio" name="unit" id="unit-celsius"
							value="Celsius" required="required">
							Celsius
					</label>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label" for="startTemp">
					Min Temperature</label>
				<div class="col-md-2">
					<input id="minTemp" name="minTemp" type="text" placeholder=""
						class="form-control input-md">
				</div>
				
				<label class="col-md-2 control-label" for="startTemp">
					Max Temperature</label>
				<div class="col-md-2">
					<input id="maxTemp" name="maxTemp" type="text" placeholder=""
						class="form-control input-md">
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-2"></div>
				<div class="col-md-2">
					<button id="submit" name="submit"
						class="btn btn-primary pull-right">Submit</button>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group"></div>

		</fieldset>
	</form>
</div>
