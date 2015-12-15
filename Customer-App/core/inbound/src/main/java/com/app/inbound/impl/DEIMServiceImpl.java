package com.app.inbound.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.camel.CamelContext;
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
		logger.error("askljdfhlsakf");
		// if not valid build response
		// if valid create object and create message with both and header
		// will get a response. is all good send back a 200
		// catch exception

		Response response = null;
		// TODO Auto-generated method stub
		return response;
	}

}
