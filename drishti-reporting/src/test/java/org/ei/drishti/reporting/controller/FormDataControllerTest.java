/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ei.drishti.reporting.controller;

import static java.util.Arrays.asList;

import java.util.Iterator;
import java.util.LinkedList;
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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.springframework.http.ResponseEntity;

import com.google.gson.JsonArray;

/**
 *
 * @author shridevi
 */
public class FormDataControllerTest {

    @Mock
    private ANMService anmService;
    @Mock

    private FormDatahandler formDataHandler;
    @Mock

    private SMSController smsController;

    @Mock
    private FormSubmissionDTO formSubmissionDTO;
    @Mock

    private DateUtil dateUtil;

    private FormDataController formdatacontroller;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        formdatacontroller = new FormDataController(anmService, formDataHandler, smsController);
    }
    
    
    

	public static JSONObject data() throws JSONException {

		JSONArray list = new JSONArray();
		
		JSONObject formte = new JSONObject();
		formte.put("data", "value");
		list.put(formte);

		JSONObject form = new JSONObject();
		form.put("fields", list);

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

    public void formDataTest() throws Exception {
		JSONObject dataobject = data();
		
		
      

    }

}
