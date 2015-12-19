package org.lsong.jetter;

import java.util.List;
import java.util.ArrayList;
import java.net.Socket;
import java.net.ServerSocket;

public class Jetter {

	public ServerSocket server;
	public List<Route> routes;
	
	public Jetter(){
		routes = new ArrayList<Route>();
	}
	
	public void listen(int port) throws Exception {
		server = new ServerSocket(port);
		while(this.process(server.accept())){}
	}
	
	private boolean process(Socket client) throws Exception {
		
		IRequest 	request 	= new Request(client.getInputStream());
		IResponse 	response 	= new Response(client.getOutputStream());
		
		Route route = Route.match(routes, request);
		if(route != null){
			request.params(route.parse(request));
			route.invoke(request, response);
		}
	
		return true;
	}

	public void use(IMiddleware middleware) {
		// TODO Auto-generated method stub
		
	}

}
