package com.customer.app.outbound.builder;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Body;

import com.sun.mdm.index.webservice.ExecuteMatchUpdate;

public class RouteSupport {

	public List<Object> buildAddUpdateNextgateRequest(@Body ExecuteMatchUpdate executeMatch) {
		final List<Object> list = new ArrayList<Object>();
		list.add(executeMatch.getCallerInfo());
		list.add(executeMatch.getSysObjBean());
		return list;
	}

}
