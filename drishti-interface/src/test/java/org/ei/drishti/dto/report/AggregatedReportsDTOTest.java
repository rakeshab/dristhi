package org.ei.drishti.dto.report;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AggregatedReportsDTOTest {
	
	private AggregatedReportsDTO aggregatedReportsDTO;

	@Before
	public void setUp(){
		aggregatedReportsDTO = new AggregatedReportsDTO(null, null);
	}
	
	@Test
	public void equalsTest(){
		Object o = null;
		boolean t = aggregatedReportsDTO.equals(o);
		boolean x = false;
		assertEquals(t,x);
	}

	@Test
	public void hashCodeTest() {
		aggregatedReportsDTO.hashCode();
	}

	@Test
	public void toStringTest() {
		aggregatedReportsDTO.toString();
	}
}
