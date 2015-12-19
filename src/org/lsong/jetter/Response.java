package org.lsong.jetter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Response implements IResponse {
	
	private static final String EOL = "\n";
	
	private OutputStreamWriter stream;

	public Response(OutputStream stream) {
		this.stream = new OutputStreamWriter(stream);
	}

	public void send(String content) throws IOException {
		this.header("statusCode", 200);
		this.write(EOL);
		this.write(content);
		this.end();
	}

	private void end() throws IOException {
		this.stream.flush();
		this.stream.close();
	}

	private void header(String key, int value) throws IOException {
		if(key.equalsIgnoreCase("statusCode")){
			stream.write("HTTP/1.1 200 OK");
			return;
		}
		stream.write( key + ": " + value);
	}

	private void write(String content) throws IOException {
		stream.write(content + EOL);
	}

}
