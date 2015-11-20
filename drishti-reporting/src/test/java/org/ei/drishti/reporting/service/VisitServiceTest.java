/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ei.drishti.reporting.service;

import java.util.LinkedList;
import java.util.List;

import org.ei.drishti.reporting.domain.ANCVisitDue;
import org.ei.drishti.reporting.domain.VisitConf;
import org.ei.drishti.reporting.repository.AllVisitDueRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.MockitoAnnotations;

import static org.mockito.MockitoAnnotations.initMocks;

/**
 * 
 * @author shridevi
 */
public class VisitServiceTest {

	@Mock
	private AllVisitDueRepository allVisitDueRepository;
	private VisitService visitService;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);
		visitService = new VisitService(allVisitDueRepository);

	}

	@Test
	public void getVisitDueTest() {
		ANCVisitDue anvvisitdue = new ANCVisitDue("entityid", "patientnum",
				"nmnum", "visittype", 32, "lmpdate", "womenname", "visitdate",
				"anmid");

		List details = visitService.getVisitDue("entityid");
		assertEquals(anvvisitdue, anvvisitdue);
	}

	@Test
	public void getVisitconfTest() {
		VisitConf visitConf = new VisitConf("nc_visit1_from_week",
				"anc_visit2_from_week", "anc_visit3_from_week",
				"anc_visit4_from_week");

		List details1 = visitService.getVisitconf();
		assertEquals(visitConf, details1);
	}

}
