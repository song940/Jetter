package org.lsong.jetter;

import java.io.IOException;

public interface IResponse {

	void send(String content) throws IOException;

}
