/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ei.drishti.reporting.service;

import java.util.Arrays;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

import org.ei.drishti.common.util.HttpResponse;
import org.ei.drishti.dto.aggregatorResponse.AggregatorResponseDTO;
import org.ei.drishti.reporting.domain.ANCVisitDue;
import org.ei.drishti.reporting.domain.EcRegDetails;
import org.ei.drishti.reporting.domain.HealthCenter;
import org.ei.drishti.reporting.domain.PHC;
import org.ei.drishti.reporting.domain.SP_ANM;
import org.ei.drishti.reporting.domain.Location;
import org.ei.drishti.reporting.domain.ANMVillages;
import org.ei.drishti.reporting.repository.AllLocationsRepository;
import org.ei.drishti.reporting.repository.AllSP_ANMsRepository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.MockitoAnnotations;

import com.mchange.util.AssertException;

import static org.mockito.MockitoAnnotations.initMocks;

/**
 * 
 * @author shrideviLocation
 */
public class ANMServiceTest {

	@Mock
	private AllSP_ANMsRepository allANMsRepository;

	@Mock
	private SP_ANM spanm;

	@Mock
	private Location location;

	@Mock
	private ANMVillages anmvillages;

	@Mock
	private AllLocationsRepository allLocationsRepository;

	private ANMService anmservice;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);
		anmservice = new ANMService(allANMsRepository, allLocationsRepository);

	}

	@Test
	public void getLocationTest() throws Exception {

		PHC phc = null;
		Location location = new Location(123, "sdaf", "sadf", phc, "taluka",
				"district", "sdaf");
		when(allLocationsRepository.fetchByANMIdentifier("anm123")).thenReturn(
				location);
		Location location1 = anmservice.getLocation("anm123");
		assertEquals(location, location1);

	}

	@Test
	public void getANMLocationTest() throws Exception {

		ANMVillages anmvillages = new ANMVillages(2314, "SFD", "sda", "ewr",
				"rew", "tre", 324, 234, 43, 43, 54, 453);
		when(allLocationsRepository.fetchLocationByANMIdentifier("anm123"))
				.thenReturn(anmvillages);

		ANMVillages anmvillages1 = anmservice.getANMLocation("anm123");
		assertEquals(anmvillages, anmvillages1);

	}

	@Test
	public void alltest() throws Exception {

		List<SP_ANM> spanmlist = allANMsRepository.fetchAll();
		List<SP_ANM> spanm = anmservice.all();
		Assert.assertEquals(spanmlist, spanm);
	}

	@Test
	public void getVillagesForANMTest() {
		PHC phc = null;
		Location location = new Location(213, "village", "subCenter", phc,
				"taluka", "district", "state");

		List<Location> detailsa = anmservice.getVillagesForANM("anm123");
		assertEquals(location, detailsa);
	}

	@Test
	public void anmsInTheSamePHCTest() {

		SP_ANM spanm = new SP_ANM("identifier", "name", "subCenter", 23423);

		List<SP_ANM> detailsaa = anmservice.anmsInTheSamePHC("anm123");
		assertEquals(location, detailsaa);
	}

	@Test
	public void getANMVillagesTest() {

		ANMVillages anmvillages = new ANMVillages(123, "villages", "role",
				"user_id", "name", "phone_number", 1234, 456, 789, 53753, 2341,
				3215);

		List<SP_ANM> detailsaa = anmservice.getANMVillages("anm123");
		assertEquals(anmvillages, detailsaa);
	}

	@Test
	public void getanmPhoneNumberTest() {

		ANMVillages anmvillages = new ANMVillages(123, "villages", "role",
				"user_id", "name", "phone_number", 1234, 456, 789, 53753, 2341,
				3215);

		List<ANMVillages> detailsaa = anmservice.getanmPhoneNumber("user1");
		assertEquals(anmvillages, detailsaa);
	}

	@Test
	public void getPhoneNumberTest() {

		EcRegDetails ecRegDetails = new EcRegDetails("entityid", "222");

		List<EcRegDetails> detasaa = anmservice.getPhoneNumber("entityid");
		assertEquals(ecRegDetails, detasaa);
	}

	@Test
	public void getPHCDetailsTest() {
		HealthCenter healthCenter = new HealthCenter(125, "hospital_name",
				"hospital_type", "hospital_address", "parent_hospital",
				"villages", 4555, 522, 56, 855);

		List<HealthCenter> detilsaa = anmservice.getPHCDetails(12123);
		assertEquals(healthCenter, detilsaa);
	}

	@Test
	public void anmsInTheSameSCTest() {
		SP_ANM spanm = new SP_ANM("ientifier", "nme", "suCenter", 2423);

		List<SP_ANM> dtilsaa = anmservice.anmsInTheSameSC("anm123");
		assertEquals(spanm, dtilsaa);
	}

}
