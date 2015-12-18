package com.customer.app.transfomer;

import org.apache.camel.Exchange;
import org.apache.camel.TypeConversionException;
import org.apache.camel.support.TypeConverterSupport;
import org.apache.log4j.Logger;

import com.customer.app.Person;
import com.sun.mdm.index.webservice.CallerInfo;
import com.sun.mdm.index.webservice.ExecuteMatchUpdate;
import com.sun.mdm.index.webservice.PersonBean;
import com.sun.mdm.index.webservice.SystemPerson;

//@Converter
public class DeimToNextGateTypeConverter extends TypeConverterSupport {

	public final static Logger logger = Logger.getLogger(DeimToNextGateTypeConverter.class);

	// @Converter
	// public ExecuteMatchUpdate convertTo(Person value) throws
	// TypeConversionException {
	// logger.error("from the coverter");
	// // TODO Auto-generated method stub
	// ExecuteMatchUpdate matchUpdate = null;
	// try {
	// matchUpdate = new ExecuteMatchUpdate();
	// Person person = (Person) value;
	// SystemPerson person2 = new SystemPerson();
	// PersonBean personBean = new PersonBean();
	//
	// personBean.setFirstName(person.getLegalname().getGiven());
	// personBean.setLastName(person.getLegalname().getFamily());
	// personBean.setDOB(person.getDateofbirth().toString());
	// personBean.setGender(person.getGender().toString());
	//
	// person2.setPerson(personBean);
	// matchUpdate.setSysObjBean(person2);
	// CallerInfo callerInfo = new CallerInfo();
	// callerInfo.setApplication("app");
	// callerInfo.setApplicationFunction("app2");
	// callerInfo.setAuthPassword("pass");
	// callerInfo.setAuthUser("admin");
	// callerInfo.setUser("bob");
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// throw new TypeConversionException(value, ExecuteMatchUpdate.class, e);
	//
	// }
	// return matchUpdate;
	// }

	@Override
	public <T> T convertTo(Class<T> type, Exchange exchange, Object value) throws TypeConversionException {
		logger.error("from the coverter");
		// TODO Auto-generated method stub
		ExecuteMatchUpdate matchUpdate = null;
		try {
			matchUpdate = new ExecuteMatchUpdate();
			Person person = (Person) value;
			SystemPerson person2 = new SystemPerson();
			PersonBean personBean = new PersonBean();

			personBean.setFirstName(person.getLegalname().getGiven());
			personBean.setLastName(person.getLegalname().getFamily());
			personBean.setDistrictOfResidence(person.getDistrictofresidence());
			person2.setPerson(personBean);
			matchUpdate.setSysObjBean(person2);
			CallerInfo callerInfo = new CallerInfo();
			callerInfo.setApplication("app");
			callerInfo.setApplicationFunction("app2");
			callerInfo.setAuthPassword("pass");
			callerInfo.setAuthUser("admin");
			callerInfo.setUser("bob");
			matchUpdate.setCallerInfo(callerInfo);

		} catch (Exception e) {
			e.printStackTrace();
			throw new TypeConversionException(value, ExecuteMatchUpdate.class, e);

		}
		return (T) matchUpdate;
	}

}
