package com.app.inbound.builder;

import org.apache.camel.ExchangePattern;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;

public class DEIMRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		JaxbDataFormat jaxb = new JaxbDataFormat();
		jaxb.setContextPath("com.customer.app");
		jaxb.setPrettyPrint(true);
		onException(Exception.class).handled(true).to("mq:deadletterQ");
		// TODO Auto-generated method stub
		// from internal deim rs uri property set route id ,log, marshal data
		// format, to new route
		// in only q for deim.in, log, transform("done"
		from("direct:test").log(LoggingLevel.ERROR, "hello everybody");

		from("direct:deimInboud").log(LoggingLevel.INFO, "recived person object").marshal(jaxb)
				.to(ExchangePattern.InOnly, "mq:q.empi.deim.in").transform().constant("done");
		from("mq:q.empi.deim.in").to("mock:end");
	}

}
