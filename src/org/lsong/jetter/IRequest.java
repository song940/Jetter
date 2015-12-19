package org.lsong.jetter;

public interface IRequest {

	Object params(String name);

	String method();

	String path();

}
