package iit.ipro497.thermal.domain;

import iit.ipro497.thermal.model.FormData;
import iit.ipro497.thermal.model.RouteData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RouteFinder {
	private static final long DAY = 60*60*24;
	
	Random random = new Random();

	public List<RouteData> findRoutes(FormData form) {
		// TODO: Hard coded routes
		List<RouteData> routes = new ArrayList<RouteData>();
		
		
		Date date = new Date(new Date().getTime() + randomLong(40000, 50000));
		String arrivalTime = formatDate(date);
		String duration = duration(new Date(), date);
		Long miles = randomLong(800, 1200);
		Double minTemp = randomDouble(10, 50);
		Double maxTemp = randomDouble(51, 110);
		Double finalTemp = randomDouble(minTemp, maxTemp);
		RouteData route1 = new RouteData("Route 1", arrivalTime, duration, miles, minTemp, maxTemp, finalTemp);
		
		
		routes.add(route1);
		return routes;
	}

	private Double randomDouble(double min, double max) {
		return (random.nextDouble() % (max-min)) + min;
	}

	private Long randomLong(long min, long max) {
		return (random.nextLong() % (max-min)) + min;
	}

	private String duration(Date date1, Date date2) {
		long diff = date2.getTime() - date1.getTime();
		String str = "";
		if (diff > DAY) {
			long days = diff % DAY;
			str += days  + " days";
			diff -= days*DAY;
		}
		// TODO: finish this code
	}

	private String formatDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

}
