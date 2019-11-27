package com.xcgn.marry.business.utils;

import java.util.HashMap;

public class HttpResponseData extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public HttpResponseData() {
	}

	public static HttpResponseData error() {
		return error(1, "操作失败");
	}

	public static HttpResponseData error(String msg) {
		return error(500, msg);
	}

	public static HttpResponseData error(int code, String msg) {
		HttpResponseData r = new HttpResponseData();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static HttpResponseData return_data(Integer rCode, Object js) {
		HttpResponseData r = new HttpResponseData();
		r.put("code",rCode);
		if (js != null) {
			r.put("data", js);
		}
		return r;
	}
	public static HttpResponseData return_data(Integer rCode, String msg, Object js) {
		HttpResponseData r = new HttpResponseData();
		r.put("code",rCode);
		r.put("msg",msg);
		if (js != null) {
			r.put("data", js);
		}
		return r;
	}
}
