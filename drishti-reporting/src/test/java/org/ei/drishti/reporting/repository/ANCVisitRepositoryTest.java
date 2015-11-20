/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ei.drishti.reporting.repository;
import org.ei.drishti.reporting.domain.ANCVisitDue;
import org.ei.drishti.reporting.domain.ANMVillages;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 *
 * @author shridevi
 */
public class ANCVisitRepositoryTest {

    @Mock
    private AllServicesProvidedRepository servicesProvidedRepository;

    private ANCVisitRepository ancvisitRepository;

    @Before
    public void testAncvisit() {

        initMocks(this);
        ancvisitRepository = new ANCVisitRepository(servicesProvidedRepository);
    }

    
    @Test
    public void testinsert() throws Exception{     
   
    	ANCVisitDue ancvisitDue = new ANCVisitDue("entityid","patientnum","anmnum","visittype",122,"lmpdate", "womenname","visitdate","anmid");

    	
    	
    }


	
    
    
  
    
    
}
