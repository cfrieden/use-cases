package com.customer.app.xlate;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JaxbDataFormat;

import com.customer.app.Person;
import com.customer.app.transfomer.DeimToNextGateTypeConverter;
import com.sun.mdm.index.webservice.ExecuteMatchUpdate;

public class XLateRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		getContext().getTypeConverterRegistry().addTypeConverter(ExecuteMatchUpdate.class, Person.class,
				new DeimToNextGateTypeConverter());

		JaxbDataFormat jaxb = new JaxbDataFormat();
		jaxb.setContextPath("com.customer.app");
		jaxb.setPrettyPrint(true);
		jaxb.setPartClass("com.customer.app.Person");

		JaxbDataFormat nextGate = new JaxbDataFormat();
		nextGate.setContextPath("com.sun.mdm.index.webservice");
		nextGate.setPrettyPrint(true);

		// OnException Handler
		// TypeConversionException
		// retry 3 times
		// send to q.empi.transform.dlq
		onException(Exception.class).maximumRedeliveries(3).redeliveryDelay(1000).handled(true)
				.to("mq:q.empi.transform.dlq");
		// from q.empi.deim.in
		// unmarshall
		// transform to Soapws
		// marshallto xml
		// send to queue q.empi.nextgate.out
		from("mq:q.empi.deim.in").log("recvieved message from queue").unmarshal(jaxb).log("unmarshalled the person")
				.convertBodyTo(ExecuteMatchUpdate.class).marshal(nextGate).to("mq:q.empi.nextgate.out");
		// .log("coverted to${body}").marshal(nextGate).log("marshalled");

	}

}
