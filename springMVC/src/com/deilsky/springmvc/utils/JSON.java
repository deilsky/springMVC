package com.deilsky.springmvc.utils;

public class JSON {
	public static JSON json;
	private int status;
	private String msg;
	private Object data;

	private JSON() {
	}

	public static JSON getInstance() {
		json = new JSON();
		return json;
	}

	public int getStatus() {
		return status;
	}

	public String getMsg() {
		return msg;
	}

	public Object getData() {
		return data;
	}
	public JSON setData(Object data) {
		this.data = data;
		return json;
	}

	public JSON setStatus(int status) {
		this.status = status;
		return json;
	}

	public JSON setMsg(String msg) {
		this.msg = msg;
		return json;
	}

}
