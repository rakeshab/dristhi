/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ei.drishti.reporting.service;

import java.util.LinkedList;
import java.util.List;
import org.ei.drishti.reporting.repository.AllVisitDueRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
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
    public void setUp() throws Exception {
        initMocks(this);
        visitService = new VisitService(allVisitDueRepository);
    }
 @Test
    public void testgetVisitDueTest() throws Exception {
    
          List alO = new LinkedList();

        when(allVisitDueRepository.fetchvisitDueDetails("")).thenReturn(alO);
    }
   
    @Test
    public void testgetVisitconf() throws Exception {
    
          List alb = new LinkedList();

        when(allVisitDueRepository.fetchvisitconf()).thenReturn(alb);
    }
}
