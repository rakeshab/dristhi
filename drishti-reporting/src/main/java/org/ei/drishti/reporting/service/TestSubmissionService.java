package org.ei.drishti.reporting.service;
import java.util.List;
import org.ei.drishti.reporting.controller.TestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ei.drishti.reporting.repository.TestSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestSubmissionService {
	
	
    private TestSubmissionRepository testSubmissionRepository;
   
 private static Logger logger = LoggerFactory
			.getLogger(TestController.class.toString());


    protected TestSubmissionService() {
    }
  
    @Autowired
    public TestSubmissionService(TestSubmissionRepository testSubmissionRepository) {
        this.testSubmissionRepository = testSubmissionRepository;
    }
   

    @Transactional("service_provided")
    public void requestConsultationTest(String visittype,String visitentityid, String entityidEC, String anmid) {
         logger.info(" This is my TestSubmissionService");
        testSubmissionRepository.requestConsultationTest(visittype, visitentityid, entityidEC, anmid);
 logger.info(" This is my TestSubmissionService");
}
}