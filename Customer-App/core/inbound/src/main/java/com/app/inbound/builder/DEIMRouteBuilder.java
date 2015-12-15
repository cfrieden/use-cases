package com.app.inbound.builder;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class DEIMRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		// from internal deim rs uri property set route id ,log, marshal data
		// format, to new route
		// in only q for deim.in, log, transform("done"
		from("direct:test").log(LoggingLevel.ERROR, "hello everybody");
	}

}
