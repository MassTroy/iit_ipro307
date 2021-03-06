package iit.ipro307.domain;

import iit.ipro307.domain.client.GoogleDirectionsClient;
import iit.ipro307.domain.data.Route;
import iit.ipro307.domain.data.RouteSummary;
import iit.ipro307.domain.data.Temperature;
import iit.ipro307.domain.data.TemperatureSummary;
import iit.ipro307.exception.BadRequestException;
import iit.ipro307.thermal.model.FormData;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.util.DistanceConverter;
import common.util.PrefixLogger;

/**
 * Main application
 * @author Troy Mass
 */
@Service
public class ThermalRouteService {
	@Autowired
	private GoogleDirectionsClient googleDirectionsClient;
	@Autowired
	private RouteReducer routeReducer;
	@Autowired
	private RouteTemperatureCalculator routeTemperatureCalculator;
	@Autowired
	private PrefixLogger log;

	public List<RouteSummary> findRoutes(FormData form) throws BadRequestException {
		// get directions from google
		List<Route> routeList = googleDirectionsClient.getDirections(form.getOrigin(), form.getDestination());
		// TODO: get directions with waypoints

		// reduce routes
		List<Route> reducedRouteList = new ArrayList<Route>();
		for (Route route : routeList) {
			Route reducedRoute = routeReducer.reduceRoute(route, DistanceConverter.milesToMeters(100));
			reducedRouteList.add(reducedRoute);
		}

		// compute thermal information for route
		List<RouteSummary> routeSummaryList = new ArrayList<RouteSummary>();
		for (Route reduced : reducedRouteList) {
			TemperatureSummary tempuratureSummary = routeTemperatureCalculator.computeTempertature(reduced, new Temperature(form.getStartTemp(), form.getUnit()));
			RouteSummary routeSummary = new RouteSummary(reduced, tempuratureSummary, form.getUnit());
			routeSummaryList.add(routeSummary);
		}

		return routeSummaryList;
	}

}
