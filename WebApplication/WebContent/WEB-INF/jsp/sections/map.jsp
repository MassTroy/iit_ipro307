<%@page import="iit.ipro497.thermal.model.DisplayModel"%>
<%
DisplayModel model = (DisplayModel)request.getAttribute("model");
String origin = "";
String destination = "";
if (model != null && model.getForm() != null) {
	origin = model.getForm().getOrigin();
	destination = model.getForm().getDestination();
}
%>
	<div class="routeMap">
	
		<legend>Map</legend>
		
		<iframe
			width="100%"
			height="600"
			frameborder="0" style="border:0"
			src="https://www.google.com/maps/embed/v1/directions?key=AIzaSyAdorDhOfuE0hwHw9lcQgAwLSq1rAzNdvs&origin=<%= origin %>&destination=<%= destination %>&mode=driving">
		</iframe>
	</div>