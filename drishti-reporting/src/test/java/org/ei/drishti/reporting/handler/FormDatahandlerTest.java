/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ei.drishti.reporting.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.ei.drishti.common.util.DateUtil;
import org.ei.drishti.dto.form.FormSubmissionDTO;
import org.ei.drishti.reporting.controller.SMSController;
import org.ei.drishti.reporting.repository.ANCVisitRepository;
import org.ei.drishti.reporting.service.ANMService;
import org.ei.drishti.reporting.service.VisitService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * 
 * @author shridevi
 */
public class FormDatahandlerTest {

	@Mock
	private SMSController smsController;
	@Mock
	private ANMService anmService;

	@Mock
	private ANCVisitRepository ancVisitRepository;
	@Mock
	private VisitService visitService;
	@Mock
	private DateUtil dateUtil;

	private FormDatahandler formDatahandler;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		formDatahandler = new FormDatahandler(dateUtil, ancVisitRepository,
				anmService, smsController, visitService);
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
	public <dataObject> void ecRegistrationtest() throws Exception {
		JSONObject dataobject = data();

		formDatahandler.ecRegistration(dataobject, "12645");

		verify(smsController).sendSMSEC("", "", "", "EC");
		verify(ancVisitRepository).ecinsert("entity", "");

	}

	@Test
	public <dataObject> void ecEdittest() throws Exception {
		JSONObject dataobject = data();

		formDatahandler.ecEdit(dataobject, "12645");

		verify(ancVisitRepository).ecUpdate(32432, "32423");

	}

	@Test
	public <dataObject> void ancEdittest() throws Exception {

		JSONObject dataobject = data();

		formDatahandler.ancEdit(dataobject, "12645");

		verify(ancVisitRepository).ancregUpdate(3232, "3423");

	}

	@Test
	public <dataObject> void ancRegistrationtest() throws Exception {

		JSONObject dataobject = data();

		formDatahandler.ancRegistration(dataobject, "sdaf", "12645");

		verify(ancVisitRepository).insert("entity", "2334", "12345", "sdaf",
				2312, "sdf", "ewqr", "12/7/2015", "anm123");

	}

	@Test
	public <dataObject> void ancVisittest() throws Exception {

		JSONObject dataobject = data();

		formDatahandler.ancVisit(dataobject, "SRNAGAR", "12645");

		verify(ancVisitRepository).ancUpdate(2121, "12/7/2015", 122);

	}

	@Test
	public <dataObject> void pncRegistrationtest() throws Exception {

		JSONObject dataobject = data();

		formDatahandler.ancVisit(dataobject, "SRNAGAR", "12645");

		verify(smsController).sendSMSEC("", "", "", "EC");
		verify(smsController).sendSMSPNC("", "", "", "EWC");
		// verify(ancVisitRepository).ancUpdate(2121,"12/7/2015",122);

	}

	@Test
	public <dataObject> void visitpoctest() throws Exception {

		JSONObject dataobject = data();

		formDatahandler.visitpoc(dataobject, "SRNAGAR", "12645");

		verify(ancVisitRepository).pocinsert("visittype", "visitentityid",
				"entityidEC", "anmid", "phc", "timestamp", "motherName");

		verify(ancVisitRepository).pocinsert("visittype", "visitentityid",
				"entityidEC", "anmid", "phc", "timestamp", "wifename");

	}

	@Test
	public <dataObject> void childRegistrationtest() throws Exception {

		JSONObject dataobject = data();

		formDatahandler.childRegistration(dataobject, "SRNAGAR", "12645");
		verify(smsController).sendSMSChild("32324", "asdf");

		verify(ancVisitRepository)
				.insert("entityId", "phoneNumber", "anmnum", "visittype", 3241,
						"lmpdate", "womenname", "visitdate", "anmid");
		verify(smsController).sendSMSChild("654546", "ECdsf");
		verify(ancVisitRepository).insert("entityId", "phoneNumber", "anmnum",
				"visittype", 321, "lmpdate", "womenname", "visitdate", "anmid");

	}

}
