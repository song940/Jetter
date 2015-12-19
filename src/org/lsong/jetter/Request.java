package org.lsong.jetter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Request implements IRequest {
	
	private static final char EOL = '\n';
	private static final int FIRST_LINE = 0;
	
	private String method;
	private String path;
	
	public Request(InputStream stream) throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(stream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		String line = "";
		int lineNumber = 0;
		StringBuilder buffer = new StringBuilder();
		while((line = bufferedReader.readLine()) != null && line.length() > 0){
			buffer.append(line + EOL);
			if(lineNumber == FIRST_LINE){
				String[] parts = line.split(" ");
				if(parts.length == 3){
					this.method 	= parts[0];
					this.path 		= parts[1];
				}
			}
			lineNumber++;
		}
	}

	public String params(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String method() {
		return method;
	}

	@Override
	public String path() {
		// TODO Auto-generated method stub
		return path;
	}
}
