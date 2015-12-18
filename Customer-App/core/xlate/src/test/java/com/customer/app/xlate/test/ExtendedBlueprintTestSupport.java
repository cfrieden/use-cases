package com.customer.app.xlate.test;

import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.junit.Rule;

public class ExtendedBlueprintTestSupport extends CamelBlueprintTestSupport {

	private static final String BROKER_NAME = "test_broker";

	@Rule
	public EmbeddedActiveMQBroker broker = new EmbeddedActiveMQBroker(BROKER_NAME);

	@Override
	protected String getBlueprintDescriptor() {
		return "OSGI-INF/blueprint/camelContext.xml," + "OSGI-INF/blueprint/test-property-placeholder.xml,";

	}

}
