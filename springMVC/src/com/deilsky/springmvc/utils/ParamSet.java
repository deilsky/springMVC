package com.deilsky.springmvc.utils;

import java.util.ArrayList;

import org.hibernate.Query;

public class ParamSet {
	public static void setParams(Query query, ArrayList<Object> param) {
		if (param != null) {
			int len = param.size();
			for (int index = 0; index < len; index++) {
				query.setParameter(index, param.get(index));
			}
		}
	}
}
