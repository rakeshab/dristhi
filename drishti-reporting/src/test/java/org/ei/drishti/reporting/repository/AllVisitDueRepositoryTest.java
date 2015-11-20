package org.ei.drishti.reporting.repository;
import java.util.List;

import junit.framework.Assert;

import org.ei.drishti.reporting.domain.SP_ANM;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AllVisitDueRepositoryTest {

	@Mock
	private AllServicesProvidedRepository servicesProvidedRepository;

	private ANCVisitRepository ancvisitRepository;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);
		ancvisitRepository = new ANCVisitRepository(servicesProvidedRepository);

	}
	
	
	@Test
    public void fetchvisitconftest() throws Exception {
	          
	   }

}
