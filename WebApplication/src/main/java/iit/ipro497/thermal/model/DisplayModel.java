package iit.ipro497.thermal.model;

import iit.ipro497.domain.data.RouteSummary;

import java.util.List;

public class DisplayModel {
	FormData form;
	List<RouteSummary> routeList;

	// TODO: add google maps route data

	public DisplayModel() {
	}

	public DisplayModel(FormData form, List<RouteSummary> routeList) {
		this.form = form;
		this.routeList = routeList;
	}

	public FormData getForm() {
		return form;
	}

	public void setForm(FormData form) {
		this.form = form;
	}

	public List<RouteSummary> getRouteList() {
		return routeList;
	}

	public void setRouteList(List<RouteSummary> routeList) {
		this.routeList = routeList;
	}

	@Override
	public String toString() {
		return "DisplayModel [form=" + form + ", routeList=" + routeList + "]";
	}
}
