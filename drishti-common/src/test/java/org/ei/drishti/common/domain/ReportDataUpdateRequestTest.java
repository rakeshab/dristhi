package org.ei.drishti.common.domain;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ReportDataUpdateRequestTest {
	
	private ReportDataUpdateRequest reportDataUpdateRequest;

	@Before
	public void setUp(){
		reportDataUpdateRequest = new ReportDataUpdateRequest();
	}
	
	@Test
	public void indicatorTest(){
		reportDataUpdateRequest.indicator();		
	}
	
	@Test
	public void startDateTest(){
		reportDataUpdateRequest.startDate();	
	}
	
	@Test
	public void endDateTest(){
		reportDataUpdateRequest.endDate();	
	}
	
	@Test
	public void typeTest(){
		reportDataUpdateRequest.type();
	}
	
	@Test
	public void reportingDataTest(){
		reportDataUpdateRequest.reportingData();
	}
	
	@Test
	public void withIndicatorTest(){
		reportDataUpdateRequest.withIndicator("indicator");
	}
	
	@Test
	public void withStartDateTest(){
		reportDataUpdateRequest.withStartDate("startDate");
	}
	
	@Test
	public void withTypeTest(){
		reportDataUpdateRequest.withType("type");
	}
	
	@Test
	public void withEndDateTest(){
		reportDataUpdateRequest.withEndDate("endDate");
	}
	
	@Test
	public void withReportingDataTest(){
		List<ReportingData> reportingData = null;
		reportDataUpdateRequest.withReportingData(reportingData);
	}
	
}
