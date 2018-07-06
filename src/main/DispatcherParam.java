package main;

import controller.Request;

public class DispatcherParam {

	private String classN, methodN;
	private Request request;
	
	public DispatcherParam(String classN, Request request) {
		this.classN = classN;
		this.methodN = null;
		this.request = request;
	}
	
	public DispatcherParam(String classN, String methodN, Request request) {
		this.classN = classN;
		this.methodN = methodN;
		this.setRequest(request);
	}

	public String getMethodN() {
		return methodN;
	}

	public void setMethodN(String methodN) {
		this.methodN = methodN;
	}
	public String getClassN() {
		return classN;
	}

	public void setClassN(String classN) {
		this.classN = classN;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

}
