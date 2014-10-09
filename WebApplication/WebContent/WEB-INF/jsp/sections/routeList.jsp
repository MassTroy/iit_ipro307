<%@page import="iit.ipro497.thermal.util.RoundingUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="iit.ipro497.thermal.model.RouteData"%>
<%@page import="java.util.List"%>
<%@page import="iit.ipro497.thermal.model.DisplayModel"%>
<%
DisplayModel model = (DisplayModel)request.getAttribute("model");
List<RouteData> routeList = new ArrayList<RouteData>();
if (model != null && model.getRouteList() != null) {
	routeList = model.getRouteList();
}
final int DECIMALS = 1;
%>
	<div class="routeList">
		<legend>Routes</legend>
	
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Route</th>
					<th>ETA</th>
					<th>Time</th>
					<th>Miles</th>
					<!--<th>Cost (estimated)</th>-->
					<th>Min Temp</th>
					<th>Max Temp</th>
					<th>Final Temp</th>
					<th>Avg Temp</th>
				</tr>
			</thead>
			<tbody>
				<% for (RouteData route : routeList) { %>
				<tr>
					<td><a href=#><%= route.getTitle() %></a></td>
					<td><%= route.getArrivalTime() %></td>
					<td><%= route.getDuration() %></td>
					<td><%= route.getMiles() %> miles</td>
					<!--<td>???</td>-->
					<td><%= RoundingUtil.round(route.getMinTemp(), DECIMALS) %></td>
					<td><%= RoundingUtil.round(route.getMaxTemp(), DECIMALS) %></td>
					<td><%= RoundingUtil.round(route.getFinalTemp(), DECIMALS) %></td>
					<td><%= RoundingUtil.round(route.getAverageTemp(), DECIMALS) %></td>
				</tr>
				<% } %>
				
			</tbody>
		</table>
	</div>
