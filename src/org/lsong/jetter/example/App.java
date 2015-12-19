package org.lsong.jetter.example;

import org.lsong.jetter.*;

public class App {

	public static void main(String[] args) throws Exception{
		Jetter server = new Jetter();
		
		server.use(new Middleware());
		
		server.routes.add(new Route("get", "/", Home.class, "index"));
		
		server.listen(3000);
		System.out.println("Server is running .");
	}
}
