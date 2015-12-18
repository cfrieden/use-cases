package com.customer.app.outbound.test;

import java.io.InputStream;

import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

public class OutboundCamelTest extends ExtendedBlueprintTestSupport {

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();

		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				from("direct:start").log("blarg").to("mq:q.empi.nextgate.out");
				from("mq:q.empi.nextgate.dlq").to("mock:dlq");
			}

		});
	}

	@Test
	public void shouldSendPayloadToSOAP() throws InterruptedException {

		String testXml = getSampleMessage("/matchExecution.xml");

		template.sendBody("direct:start", testXml);
		Thread.sleep(1000);

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
