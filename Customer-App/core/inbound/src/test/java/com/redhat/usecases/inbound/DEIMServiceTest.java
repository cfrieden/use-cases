package com.redhat.usecases.inbound;

import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

public class DEIMServiceTest extends CamelBlueprintTestSupport {

	public final static Logger logger = Logger.getLogger(DEIMServiceTest.class);

	@Override
	protected String getBlueprintDescriptor() {
		return "/OSGI-INF/blueprint/camelContext.xml," + "/OSGI-INF/blueprint/test-property-placeholder.xml";

	}

	@Test
	public void shouldParseXMLToJava() throws Exception {
		template.sendBody("direct:test", "blarg");

		HttpClient httpClient;
		String response;

		getMockEndpoint("mock:end").expectedMinimumMessageCount(1);

		httpClient = HttpClientBuilder.create().build();
		HttpPost postRequest = new HttpPost("http://localhost:8181/deim/add");
		// StringEntity input = new StringEntity(
		// ""/** getSampleMessage("PatientDemographicsData.xml") **/
		// );
		// input.setContentType("application/xml");
		// postRequest.setEntity(input);
		// HttpResponse httpResponse = httpClient.execute(postRequest);
		//
		// // Assert
		// Thread.sleep(5000);
		//
		// HttpEntity responseEntity = httpResponse.getEntity();
		// System.err.println(httpResponse.getStatusLine());
		// // if not null enityutils.tostring
		//
		// // assert equals 200 status code

	}

	// @Test
	public void shouldDoSomethingWithBadXML() {

	}

}
