/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ei.drishti.reporting.controller;

import static java.util.Arrays.asList;
import java.util.List;
import org.ei.drishti.common.util.DateUtil;
import org.ei.drishti.dto.form.FormSubmissionDTO;
import org.ei.drishti.reporting.handler.FormDatahandler;
import org.ei.drishti.reporting.service.ANMService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import org.springframework.http.ResponseEntity;

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

    @Test

    public void formDataTest() throws Exception {

//        Object formsumb = providedData("ANMX", "TC1", "BCG", "sdf", "bherya", "Sub Center", "PHC X", "entityid1");
//
//        formdatacontroller.formData((List<FormSubmissionDTO>) formsumb);
//
//     //  List verify = verify(anmService.getPhoneNumber("anm123").;   
//        when(formSubmissionDTO.anmId()).thenReturn("anm123");
//
//        when(formSubmissionDTO.instanceId()).thenReturn("anm");
//
//        when(formSubmissionDTO.entityId()).thenReturn("sadf");
//
//        when(formSubmissionDTO.formName()).thenReturn("weqr");
//
//        when(formSubmissionDTO.formDataDefinitionVersion()).thenReturn("jklk");
//
//        when(formSubmissionDTO.clientVersion()).thenReturn("jklkee");
//        when(formSubmissionDTO.serverVersion()).thenReturn("jklkrr");
        
        
      //   ResponseEntity<FormSubmissionDTO> response = formdatacontroller.phoneNumber();//phoneNumber(3234);//villagesForANM("demo1");

      //  VillagesDTO villagesDTO = new VillagesDTO("district", "PHCX", "phc1", "sc", asList("village1", "village2"));
       // assertEquals(villagesDTO, response.getBody());

       //  when(anmService.getPhoneNumber("anm123").thenReturn(formsumb);//getLocation("demo1")).thenReturn(location);
        // when(location.phc()).thenReturn(phc);
    }

//    private Object providedData(String anmx, String tC1, String bcg, String sdf, String bherya, String sub_Center, String phc_x, String entityid1) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
