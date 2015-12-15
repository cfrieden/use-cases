package com.app.inbound.impl;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.camel.CamelContext;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.cxf.jaxrs.ext.MessageContext;
import org.apache.log4j.Logger;

import com.app.inbound.service.DEIMService;
import com.customer.app.Person;

@Path("/deim")
public class DEIMServiceImpl implements DEIMService {

	public final static Logger logger = Logger.getLogger(DEIMServiceImpl.class);

	@Context
	MessageContext jaxrsContext;

	private CamelContext context;

	@Override
	@POST
	@Path("/add")
	@Consumes("application/xml")
	public Response addCustomer(Person person) {
		logger.error(jaxrsContext.toString());
		ResponseBuilder response;
		// if not valid build response

		// if valid create object and create message with both and header
		// will get a response. is all good send back a 200
		// catch exception
		ProducerTemplate template = context.createProducerTemplate();
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("done", true);
		try {
			String reply = (String) template.sendBodyAndHeaders("direct:deimInboud", ExchangePattern.InOut, person,
					headers);
			if (reply.equals("done")) {
				response = Response.ok().status(Status.OK);
			} else {
				response = Response.serverError();
			}
		} catch (Exception e) {
			response = Response.serverError();
		}
		return response.build();
	}

	public CamelContext getContext() {
		return context;
	}

	public void setContext(CamelContext context) {
		this.context = context;
	}

}
