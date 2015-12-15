package com.app.inbound.service;

import javax.ws.rs.core.Response;

import com.customer.app.Person;

public interface DEIMService {

	public Response addCustomer(Person person);
}
