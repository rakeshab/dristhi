package org.ei.drishti.reporting.controller;

import org.ei.drishti.reporting.service.TestSubmissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	private TestSubmissionService testSubmissionService;
	
	private static Logger logger = LoggerFactory
			.getLogger(TestController.class.toString());


	@Autowired
	public TestController(TestSubmissionService testSubmissionService) {
		this.testSubmissionService = testSubmissionService;

	}
        

        
        @RequestMapping(method = { RequestMethod.GET, RequestMethod.OPTIONS }, value = "/consultationdetails")
	public void TestSave(@RequestParam("visisttype") String visittype,
			@RequestParam("visitentityid") String visitentityid,
			@RequestParam("entityidEC") String entityidEC,
			@RequestParam("anmid") String anmid) {
            
          
            
            logger.info(" This is my Test Controller");
		testSubmissionService.requestConsultationTest(visittype, visitentityid,
				entityidEC, anmid);
                 
	}

	
        
        
        

}
