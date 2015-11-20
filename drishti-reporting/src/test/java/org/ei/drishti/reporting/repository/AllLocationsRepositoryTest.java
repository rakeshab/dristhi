package org.ei.drishti.reporting.repository;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.List;

import org.ei.drishti.reporting.domain.ANCVisitDue;
import org.ei.drishti.reporting.domain.ANMVillages;
import org.ei.drishti.reporting.domain.Location;
import org.ei.drishti.reporting.domain.PHC;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class AllLocationsRepositoryTest {
	@Mock
	private DataAccessTemplate dataAccessTemplate;

	private AllLocationsRepository allLocationsrepository;

	@Before
	public void setUp() throws Exception {
		initMocks(this);
		allLocationsrepository = new AllLocationsRepository(dataAccessTemplate);
	}

	@Test
	public void fetchByANMIdentifierTest() throws Exception {
		
		

	

	}

}
