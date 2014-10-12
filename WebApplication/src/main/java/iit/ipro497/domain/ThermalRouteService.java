package iit.ipro497.domain;

import iit.ipro497.domain.client.GoogleDirectionsClient;
import iit.ipro497.domain.data.Route;
import iit.ipro497.domain.data.RouteSummary;
import iit.ipro497.domain.data.TemperatureSummary;
import iit.ipro497.exception.BadRequestException;
import iit.ipro497.thermal.model.FormData;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.util.DistanceConverter;

@Service
public class ThermalRouteService {
	@Autowired
	private GoogleDirectionsClient googleDirectionsClient;
	@Autowired
	private RouteReducer routeReducer;
	@Autowired
	private RouteTemperatureCalculator routeTemperatureCalculator;

	public List<RouteSummary> findRoutes(FormData form) throws BadRequestException {
		// get directions from google
		List<Route> routeList = googleDirectionsClient.getDirections(form.getOrigin(), form.getDestination());
		// TODO: get directions with waypoints

		// reduce routes
		List<Route> reducedRouteList = new ArrayList<Route>();
		for (Route route : routeList) {
			Route reducedRoute = routeReducer.reduceRoute(route, DistanceConverter.milesToMeters(50));
			reducedRouteList.add(reducedRoute);
		}

		// compute thermal information for route
		List<RouteSummary> routeSummaryList = new ArrayList<RouteSummary>();
		for (Route reduced : reducedRouteList) {
			TemperatureSummary tempuratureSummary = routeTemperatureCalculator.computeTempertature(reduced, form);
			RouteSummary routeSummary = new RouteSummary(reduced, tempuratureSummary);
			routeSummaryList.add(routeSummary);
		}

		return routeSummaryList;
	}

}