package org.lsong.jetter;

import java.lang.reflect.Constructor;
import java.util.List;

public class Route {

	private String method;
	private String route;
	private String action;
	private Class<?> controller;

	public Route(String method, String route, Class<?> controller, String action) {
		this.method 	= method;
		this.route 		= route;
		this.action 	= action;
		this.controller = controller;
	}

	public static Route match(List<Route> routes, IRequest request) {
		for(Route route : routes) {
			if( request.method().equalsIgnoreCase(route.method()) 
		     && request.path().equals(route.route()) ) 
				return route;
		}
		return null;
	}

	private String method() {
		return method;
	}

	public String route() {
		return route;
	}


	public void invoke(IRequest request, IResponse response) throws Exception {
		Constructor<?> ctor = controller.getConstructor();
		Object obj = ctor.newInstance();
		controller.getMethod(action, IRequest.class, IResponse.class).invoke(obj, request, response);
	}

	public String parse(IRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
