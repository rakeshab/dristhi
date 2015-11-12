/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ei.drishti.reporting.service;

import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.LinkedList;
import java.util.List;
import org.ei.drishti.reporting.domain.HealthCenter;
import org.ei.drishti.reporting.domain.SP_ANM;
import org.ei.drishti.reporting.repository.AllLocationsRepository;
import org.ei.drishti.reporting.repository.AllSP_ANMsRepository;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 *
 * @author shridevi
 */
public class ANMServiceTest {

    @Mock
    private AllSP_ANMsRepository allANMsRepository;
    @Mock
    private AllLocationsRepository allLocationsRepository;
    
    private ANMService anmservice;

    @Before
    public void testinjectMocks() {

        initMocks(this);
        anmservice = new ANMService(allANMsRepository, allLocationsRepository);
    }

    @Test
    public void testFindAll() throws Exception {
        List all = new LinkedList();

        when(allANMsRepository.fetchAll()).thenReturn(all);

    }

    @Test
    public void testanmvillages() throws Exception {
        List al = new LinkedList();

        when(allLocationsRepository.fetchVillagesForANM("")).thenReturn(al);

    }

    @Test
    public void testanmsInTheSameSC() throws Exception {
        List alO = new LinkedList();

        when(allANMsRepository.fetchAllANMSInSameSC("")).thenReturn(alO);

    }

    @Test
    public void testanmsInTheSamePHC() throws Exception {
        List alOa = new LinkedList();

        when(allANMsRepository.fetchAllANMSInSamePHC("")).thenReturn(alOa);

    }

    @Test
    public void testgetANMVillages() throws Exception {
        List alOap = new LinkedList();

        when(allLocationsRepository.fetchANMVillages("")).thenReturn(alOap);

    }
    
    
    @Test
    public void testgetanmPhoneNumber() throws Exception {
        List als = new LinkedList();

        when(allLocationsRepository.fetchANMphonenumber("")).thenReturn(als);

    }
    
    @Test
    public void testgetPhoneNumber() throws Exception {
        List alf = new LinkedList();

        when(allLocationsRepository.fetchphonenumber("")).thenReturn(alf);

    }
    
     @Test
    public void testgetPHCDetails() throws Exception {
        List alg = new LinkedList();

        when(allLocationsRepository.fetchphc(32)).thenReturn(alg);

    }
    

}
