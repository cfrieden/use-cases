package com.customer.app.outbound.builder;

import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.model.dataformat.JaxbDataFormat;

public class OutboundRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		JaxbDataFormat nextGate = new JaxbDataFormat();
		nextGate.setContextPath("com.sun.mdm.index.webservice");
		nextGate.setPrettyPrint(true);

		from("mq:q.empi.nextgate.out").log("received message from mq").unmarshal(nextGate).log("unmarshalled")
				.beanRef("routeSupportBean?buildAddUpdateNextgateRequest").log("transformed")
				.setHeader(CxfConstants.OPERATION_NAME).constant("executeMatchUpdate").log("set header")
				.to(ExchangePattern.OutOnly, "{{ws-outbound}}");

		// routeSupportBean?buildAddUpdateNextgateRequest
		// RouteSupportBean(@Body ExecuteMatcHUpdateRequest Exchange)
		// final List<Object> params = new ArrayList<Object>();
		// params.add(executeObject.getCallerInfo());
		// params.add(executeMatchUpdate.getSysObjectBean());
		// return params;
		// for soap envolope CxfConstants.OPERNATION_NAME
		// constant="executeMatchUpdate"
		// "cxf:{{uri}}?serviceClass=...ExecuteMatchUpdate"

	}

}
