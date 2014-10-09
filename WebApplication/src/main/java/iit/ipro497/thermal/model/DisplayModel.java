package iit.ipro497.thermal.model;

import iit.ipro497.domain.data.RouteData;

import java.util.List;

public class DisplayModel {
	FormData form;
	List<RouteData> routeList;
	// TODO: add google maps route data

	public DisplayModel() {
	}

	public DisplayModel(FormData form, List<RouteData> routeList) {
		this.form = form;
		this.routeList = routeList;
	}

	public FormData getForm() {
		return form;
	}

	public void setForm(FormData form) {
		this.form = form;
	}

	public List<RouteData> getRouteList() {
		return routeList;
	}

	public void setRouteList(List<RouteData> routeList) {
		this.routeList = routeList;
	}

	@Override
	public String toString() {
		return "DisplayModel [form=" + form + ", routeList=" + routeList + "]";
	}
}
