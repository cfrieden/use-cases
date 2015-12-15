package com.redhat.usecases.inbound;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

public class DEIMServiceTest extends ExtendedBlueprintTestSupport {

	public final static Logger logger = Logger.getLogger(DEIMServiceTest.class);

	@Test
	public void shouldParseXMLToJava() throws Exception {
		template.sendBody("direct:test", "blarg");

		HttpClient httpClient;
		String response = "";

		getMockEndpoint("mock:end").expectedMinimumMessageCount(1);

		httpClient = HttpClientBuilder.create().build();
		HttpPost postRequest = new HttpPost("http://localhost:8181/deim/add");
		StringEntity input = new StringEntity(getSampleMessage("/PatientDemographics.xml"));
		input.setContentType("application/xml");
		postRequest.setEntity(input);
		HttpResponse httpResponse = httpClient.execute(postRequest);

		// Assert
		Thread.sleep(5000);

		HttpEntity responseEntity = httpResponse.getEntity();
		logger.debug("Recieved Status line: " + httpResponse.getStatusLine());
		assertTrue(httpResponse.getStatusLine().toString().contains("200"));

		getMockEndpoint("mock:end").assertIsSatisfied();

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

	// @Test
	public void shouldDoSomethingWithBadXML() {

	}

}
