package org.lsong.jetter.example;

import java.io.IOException;

import org.lsong.jetter.*;

public class Home extends Controller {
	
	public void index(IRequest request, IResponse response) throws IOException{
		response.send("hi");
	}
}
