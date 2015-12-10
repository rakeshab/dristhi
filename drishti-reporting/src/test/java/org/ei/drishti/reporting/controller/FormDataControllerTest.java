package org.ei.drishti.reporting.controller;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.List;

import org.ei.drishti.common.util.DateUtil;
import org.ei.drishti.dto.form.FormSubmissionDTO;
import org.ei.drishti.reporting.handler.FormDatahandler;
import org.ei.drishti.reporting.service.ANMService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.google.gson.JsonArray;

import static java.util.Arrays.asList;

public class FormDataControllerTest {
	
	@Mock
	private ANMService anmService;
	@Mock
	private FormDatahandler formDataHandler;
	@Mock
	private SMSController smsController;
	@Mock
	private DateUtil dateUtil;

	private FormDataController formDataController;
	
	 @Before
	    public void setUp() throws Exception {
	        initMocks(this);
	        formDataController = new FormDataController(anmService,formDataHandler, smsController,dateUtil);
	    }
	 
	 public static JSONObject data() throws JSONException {

			JSONArray list = new JSONArray();
			JSONArray list1 = new JSONArray();
			JSONArray li = new JSONArray();
			JSONArray instances = new JSONArray();
			JSONObject formte = new JSONObject();
			JSONObject formt = new JSONObject();
			JSONObject ec = new JSONObject();
			JSONObject weight = new JSONObject();
			weight.put("weight", 5);
			instances.put(weight);
			formt.put("instances", instances);
			formte.put("name", "ecId");
			formte.put("value", "ecId");
			ec.put("name", "ecid");
			ec.put("value", "ecid");
			li.put(ec);
			list.put(formte);
			list1.put(formt);
			JSONObject form = new JSONObject();
			form.put("fields", list);
			form.put("sub_forms", list1);
			JSONObject formInstance = new JSONObject();
			formInstance.put("form", form);
			JsonArray arr = new JsonArray();
			JSONObject test1 = new JSONObject();
			test1.put("anmId", "anmId");
			test1.put("instanceId", "instance");
			test1.put("entityId", "entity");
			test1.put("formName", "name");
			test1.put("formInstance", formInstance);
			test1.put("clientVersion", "client");
			test1.put("formDataDefinitionVersion", "formDataDefinition");
			return test1;
		}
	 
	 @Test
	    public void formDatatest() throws Exception {
		 
		 JSONObject dataobject = data();
		// FormSubmissionDTO formSubmissionsDTO = new FormSubmissionDTO("anmId","instanceId","entityId","formName","formInstance","clientVersion","formDataDefinitionVersion");
		//formDataController.formData(asList(formSubmissionsDTO));
	//	when(anmService.getanmPhoneNumber("32423")).thenReturn(
		//		asList(formSubmissionsDTO));
	 }
	 
	 
	 

}
