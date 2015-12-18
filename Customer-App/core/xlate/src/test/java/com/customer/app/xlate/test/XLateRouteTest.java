package com.customer.app.xlate.test;

import java.io.InputStream;

import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

public class XLateRouteTest extends ExtendedBlueprintTestSupport {

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();

		context().addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				from("direct:test").log("hello everyone").to("mq:q.empi.deim.in");
				from("mq:q.empi.nextgate.out").log("${body}").to("mock:end");
				from("mq:q.empi.transform.dlq").to("mock:dlq");
			}

		});

	}

	@Test
	public void shouldTransformToWSOAP() throws Exception {

		getMockEndpoint("mock:end").expectedMinimumMessageCount(1);
		getMockEndpoint("mock:dlq").expectedMinimumMessageCount(0);

		String xmlString = getSampleMessage("/PatientDemographics.xml");
		template.sendBody("direct:test", xmlString);

		Thread.sleep(5000);

		getMockEndpoint("mock:end").assertIsSatisfied();

		getMockEndpoint("mock:dlq").assertIsSatisfied();

	}

	@Test
	public void shouldSendBadXMLtoDLQ() throws Exception {

		getMockEndpoint("mock:end").expectedMinimumMessageCount(0);
		getMockEndpoint("mock:dlq").expectedMinimumMessageCount(1);

		String xmlString = getSampleMessage("/BadPatientDemographics.xml");
		template.sendBody("direct:test", xmlString);

		Thread.sleep(5000);

		getMockEndpoint("mock:end").assertIsSatisfied();

		getMockEndpoint("mock:dlq").assertIsSatisfied();

	}

	private String getSampleMessage(String filename) {
		InputStream is = this.getClass().getResourceAsStream(filename);

		String str = "";
		try {
			if (is != null) {
				str = IOUtils.toString(is);
			} else {
				throw new Exception("input stream is null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		return str;
	}
}
