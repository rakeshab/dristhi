package org.ei.drishti.reporting.repository;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.sql.Timestamp;
import java.util.List;

import org.ei.drishti.dto.VillagesDTO;
import org.ei.drishti.reporting.domain.ANMVillages;
import org.ei.drishti.reporting.domain.Location;
import org.ei.drishti.reporting.domain.PHC;
import org.ei.drishti.reporting.domain.POC_Table;
import org.ei.drishti.reporting.repository.it.ServicesProvidedIntegrationTestBase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

public class AllServicesProvidedRepositoryTest extends ServicesProvidedIntegrationTestBase{
	@Mock
	  private DataAccessTemplate dataAccessTemplate;
	private AllServicesProvidedRepository allServicesProvidedRepository;
	
	
	 @Before
	    public void setUp() throws Exception {
	        initMocks(this);
	        allServicesProvidedRepository = new AllServicesProvidedRepository(dataAccessTemplate);
	    }
	 
	 
	 @Test
	    public void pocsaveTest() throws Exception {
		 java.util.Date date = new java.util.Date();
	        Timestamp timestamp1 = new Timestamp(date.getTime());
		POC_Table poc=new POC_Table("123", "234324", "anm123", "1", "0", "0", "test", "phc", "0", "doc", timestamp1, "wife");
	
			
	    }

}
