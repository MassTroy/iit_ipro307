<%@page import="java.text.Normalizer.Form"%>
<%@page import="iit.ipro497.domain.data.TemperatureUnit"%>
<%@page import="iit.ipro497.thermal.model.FormData"%>
<%@page import="iit.ipro497.thermal.model.DisplayModel"%>
<%
DisplayModel model = (DisplayModel)request.getAttribute("model");
String origin = "";
String destination = "";
String startTemp = "";
String minTemp = "";
String maxTemp = "";
TemperatureUnit unit = TemperatureUnit.Fahrenheit;

if (model != null && model.getForm() != null) {
	FormData form = model.getForm();
	origin = form.getOrigin();
	destination = form.getDestination();
	if (form.getStartTemp() != null)
		startTemp = form.getStartTemp().toString();
	if (form.getMinTemp() != null)
		minTemp = form.getMinTemp().toString();
	if (form.getMaxTemp() != null)
		maxTemp = form.getMaxTemp().toString();
	if (form.getUnit() != null)
		unit = form.getUnit();
}
%>

<div class="addressForm">
	<legend>Origin / Destination</legend>
	<form class="form-horizontal" name="form" action="submit" method="POST">
		<fieldset>

			<div class="form-group">
				<label class="col-md-2 control-label" for="start">Origin</label>
				<div class="col-md-8">
					<input id="origin" name="origin" type="search" placeholder=""
						class="form-control input-md" required="" value="<%= origin %>">

				</div>
			</div>

			<!-- Search input-->
			<div class="form-group">
				<label class="col-md-2 control-label" for="dest">Destination</label>
				<div class="col-md-8">
					<input id="destination" name="destination" type="search" placeholder=""
						class="form-control input-md" required="" value="<%= destination %>">

				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-2 control-label" for="startTemp">
					Starting Temperature</label>
				<div class="col-md-2">
					<input id="startTemp" name="startTemp" type="text" placeholder=""
						class="form-control input-md" value="<%= startTemp %>">
				</div>
				
				
				<label class="col-md-2 control-label" for="unit">Unit</label>
				<div class="col-md-4" style="margin-left: 15px;">
					<label class="radio" for="unit-fahrenheit">
					<input type="radio" name="unit" id="unit-fahrenheit"
						value="Fahrenheit" <%= unit == TemperatureUnit.Fahrenheit ? "checked=\"checked\"" : "" %> required="required">
						Fahrenheit
					</label>
					<label class="radio" for="unit-celsius">
						<input type="radio" name="unit" id="unit-celsius"
							value="Celsius" <%= unit == TemperatureUnit.Celsius ? "checked=\"checked\"" : "" %> required="required">
							Celsius
					</label>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label" for="minTemp">
					Min Temperature</label>
				<div class="col-md-2">
					<input id="minTemp" name="minTemp" type="text" placeholder=""
						class="form-control input-md" value="<%= minTemp %>">
				</div>
				
				<label class="col-md-2 control-label" for="maxTemp">
					Max Temperature</label>
				<div class="col-md-2">
					<input id="maxTemp" name="maxTemp" type="text" placeholder=""
						class="form-control input-md" value="<%= maxTemp %>">
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-2"></div>
				<div class="col-md-2">
					<button id="submit" name="submit"
						class="btn btn-primary pull-right">Submit</button>
				</div>
			</div>

		</fieldset>
	</form>
	
	<!-- TODO: add clear button -->
</div>
