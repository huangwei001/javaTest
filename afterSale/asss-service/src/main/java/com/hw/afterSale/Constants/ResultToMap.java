/*
 * Copyright (C) 2016 南京思创信息技术有限公司
 * <p>
 * 版权所有。
 * <p>
 * 功能概要    :
 * 做成日期    : 2016/12/30
 */
package com.hw.afterSale.Constants;

import org.hibernate.transform.ResultTransformer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class ResultToMap implements ResultTransformer {
	private static final long serialVersionUID = -6126968741247252813L;

	public Object transformTuple(Object[] tuple, String[] aliases) {
		Map<String, Object> result = new LinkedHashMap<>(aliases.length);
		for (int i = 0; i < aliases.length; i++) {
			result.put(aliases[i], tuple[i]);
		}
		return result;
	}

	@SuppressWarnings("rawtypes")
	public List transformList(List collection) {
		return collection;
	}

}
