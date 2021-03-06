package com.customer.app.outbound.test;

import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import com.sun.mdm.index.webservice.ApplicationConfigEntry;
import com.sun.mdm.index.webservice.CallerInfo;
import com.sun.mdm.index.webservice.CodeDescription;
import com.sun.mdm.index.webservice.CodeLookupException_Exception;
import com.sun.mdm.index.webservice.CustomLogicParameter;
import com.sun.mdm.index.webservice.CustomLogicResponse;
import com.sun.mdm.index.webservice.EnterprisePerson;
import com.sun.mdm.index.webservice.EoSearchOptions;
import com.sun.mdm.index.webservice.MatchColResult;
import com.sun.mdm.index.webservice.MatchWeight;
import com.sun.mdm.index.webservice.MergePersonResult;
import com.sun.mdm.index.webservice.ObjectDefinition;
import com.sun.mdm.index.webservice.OverlayDetectorResult;
import com.sun.mdm.index.webservice.PageException_Exception;
import com.sun.mdm.index.webservice.PersonBean;
import com.sun.mdm.index.webservice.PersonEJB;
import com.sun.mdm.index.webservice.PersonObject;
import com.sun.mdm.index.webservice.PotentialDuplicateResult;
import com.sun.mdm.index.webservice.PotentialDuplicateSearchObjectBean;
import com.sun.mdm.index.webservice.ProcessingException_Exception;
import com.sun.mdm.index.webservice.SbrOverWriteBean;
import com.sun.mdm.index.webservice.SbrPerson;
import com.sun.mdm.index.webservice.SbrPersonHistory;
import com.sun.mdm.index.webservice.ScoreElement;
import com.sun.mdm.index.webservice.SystemDefinition;
import com.sun.mdm.index.webservice.SystemObjectUIDBean;
import com.sun.mdm.index.webservice.SystemPerson;
import com.sun.mdm.index.webservice.SystemPersonHistory;
import com.sun.mdm.index.webservice.SystemPersonPK;
import com.sun.mdm.index.webservice.SystemPersonPKArray;
import com.sun.mdm.index.webservice.SystemUIDDefinition;
import com.sun.mdm.index.webservice.UserException_Exception;

public class CustomerEJBImpl implements PersonEJB {

	private CamelContext context;

	@Override
	public MatchColResult executeMatchUpdate(CallerInfo arg0, SystemPerson arg1)
			throws ProcessingException_Exception, UserException_Exception {
		MatchColResult result = new MatchColResult();
		result.setResultCode(1);

		ProducerTemplate template = context.createProducerTemplate();
		template.sendBody("mock:end", result);
		return result;
	}

	@Override
	public void activateEnterpriseRecord(CallerInfo arg0, String arg1)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void activateSystemRecord(CallerInfo arg0, String arg1, String arg2)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void addOrUpdateSystemRecord(CallerInfo arg0, String arg1, SystemPerson arg2, boolean arg3)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSystemRecord(CallerInfo arg0, String arg1, SystemPerson arg2)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void assignRefObjectNode(CallerInfo arg0, String arg1, String arg2, String arg3, SystemPerson arg4)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void assignRefObjectNodes(CallerInfo arg0, String arg1, String arg2, String arg3, List<String> arg4)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public OverlayDetectorResult checkForOverlay(PersonBean arg0, PersonBean arg1)
			throws ProcessingException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MatchWeight compareRecords(PersonBean arg0, PersonBean arg1) throws ProcessingException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deactivateEnterpriseRecord(CallerInfo arg0, String arg1)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deactivateSystemRecord(CallerInfo arg0, String arg1, String arg2)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public CustomLogicResponse executeCustomLogic(CallerInfo arg0, String arg1, List<CustomLogicParameter> arg2)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MatchColResult executeMatch(CallerInfo arg0, SystemPerson arg1)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getActiveEUID(CallerInfo arg0, String arg1)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCodeDescription(String arg0, String arg1) throws CodeLookupException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CodeDescription> getCodesByType(String arg0) throws CodeLookupException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MatchWeight getComparison(CallerInfo arg0, long arg1) throws ProcessingException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEUID(CallerInfo arg0, String arg1, String arg2)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getEUIDs(CallerInfo arg0, String arg1, String arg2, int arg3)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnterprisePerson getEnterpriseRecordByEUID(CallerInfo arg0, String arg1, boolean arg2)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnterprisePerson getEnterpriseRecordByLID(CallerInfo arg0, String arg1, String arg2)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEnterpriseRecordStatus(CallerInfo arg0, String arg1)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnterprisePerson> getEnterpriseRecords(CallerInfo arg0, List<String> arg1, boolean arg2)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemPersonPK> getLIDs(CallerInfo arg0, String arg1)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemPersonPK> getLIDsByStatus(CallerInfo arg0, String arg1, String arg2)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLastSysInfoLogEntry(CallerInfo arg0) throws ProcessingException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getMergedEUIDs(CallerInfo arg0, String arg1)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemPersonPKArray> getMultipleLIDs(CallerInfo arg0, List<String> arg1, boolean arg2)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getRevisionNumber(CallerInfo arg0, String arg1)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SbrPerson getSBR(CallerInfo arg0, String arg1)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SbrPersonHistory getSBRHistory(CallerInfo arg0, String arg1, String arg2)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnterprisePerson> getSBRs(CallerInfo arg0, List<String> arg1, boolean arg2)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SystemPerson getSystemRecord(CallerInfo arg0, String arg1, String arg2)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SystemPersonHistory getSystemRecordHistory(CallerInfo arg0, String arg1, String arg2, String arg3)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSystemRecordStatus(CallerInfo arg0, String arg1, String arg2)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemPerson> getSystemRecordsByEUID(CallerInfo arg0, String arg1)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemPerson> getSystemRecordsByEUIDStatus(CallerInfo arg0, String arg1, String arg2)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ApplicationConfigEntry> lookupApplicationConfig() throws ProcessingException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SystemPersonPK lookupLIDBySUID(CallerInfo arg0, String arg1, String arg2)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemPersonPK> lookupLIDs(CallerInfo arg0, String arg1, String arg2, String arg3, String arg4)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectDefinition lookupObjectDefinition()
			throws ProcessingException_Exception, UserException_Exception, PageException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PotentialDuplicateResult> lookupPotentialDuplicates(CallerInfo arg0,
			PotentialDuplicateSearchObjectBean arg1)
					throws ProcessingException_Exception, UserException_Exception, PageException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] lookupResource(CallerInfo arg0, String arg1)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SystemDefinition lookupSystemDefinition(String arg0) throws ProcessingException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemDefinition> lookupSystemDefinitions() throws ProcessingException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemObjectUIDBean> lookupSystemRecordUIDs(CallerInfo arg0, String arg1, String arg2)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemUIDDefinition> lookupSystemUIDDefinitions() throws ProcessingException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MergePersonResult mergeEnterpriseRecord(CallerInfo arg0, String arg1, String arg2, boolean arg3,
			boolean arg4) throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MergePersonResult mergeEnterpriseRecordWithImage(CallerInfo arg0, String arg1, EnterprisePerson arg2,
			boolean arg3, boolean arg4) throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MergePersonResult mergeEnterpriseRecordWithOverwrites(CallerInfo arg0, String arg1, String arg2,
			boolean arg3, boolean arg4, List<SbrOverWriteBean> arg5)
					throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MergePersonResult> mergeMultipleEnterpriseRecords(CallerInfo arg0, List<String> arg1,
			EnterprisePerson arg2, List<String> arg3, String arg4, boolean arg5, boolean arg6)
					throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MergePersonResult mergeSystemRecord(CallerInfo arg0, String arg1, String arg2, String arg3, boolean arg4)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MergePersonResult mergeSystemRecordWithImage(CallerInfo arg0, String arg1, String arg2, String arg3,
			PersonObject arg4, boolean arg5) throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MatchColResult recalculateMatch(CallerInfo arg0, String arg1)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resolvePotentialDuplicate(CallerInfo arg0, String arg1, boolean arg2)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ScoreElement> search(CallerInfo arg0, PersonBean arg1, EoSearchOptions arg2)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String splitSystemRecord(CallerInfo arg0, String arg1, String arg2, String arg3)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void transferSystemRecord(CallerInfo arg0, String arg1, String arg2, String arg3)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void transferSystemRecordUID(CallerInfo arg0, String arg1, String arg2, String arg3, String arg4)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public String undoAssumedMatch(CallerInfo arg0, String arg1)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void undoSystemObjectUpdate(CallerInfo arg0, String arg1, String arg2, String arg3)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public MergePersonResult unmergeEnterpriseRecord(CallerInfo arg0, String arg1, boolean arg2)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MergePersonResult unmergeSystemRecord(CallerInfo arg0, String arg1, String arg2, String arg3, boolean arg4)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unresolvePotentialDuplicate(CallerInfo arg0, String arg1)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEnterpriseRecord(CallerInfo arg0, EnterprisePerson arg1)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSystemRecord(CallerInfo arg0, SystemPerson arg1)
			throws ProcessingException_Exception, UserException_Exception {
		// TODO Auto-generated method stub

	}

	public CamelContext getContext() {
		return context;
	}

	public void setContext(CamelContext context) {
		this.context = context;
	}

}
