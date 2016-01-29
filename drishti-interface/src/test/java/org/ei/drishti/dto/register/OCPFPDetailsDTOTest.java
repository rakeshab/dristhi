package org.ei.drishti.dto.register;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class OCPFPDetailsDTOTest {
	
	private OCPFPDetailsDTO ocpFPDetailsDTO;
	
	@Before
	public void setUp(){
		ocpFPDetailsDTO = new OCPFPDetailsDTO(null, null, null, null);
	}
	
	@Test
	public void equalsTest(){
		Object o = null;
		boolean t = ocpFPDetailsDTO.equals(o);
		boolean x = false;
		assertEquals(t,x);
	}

	@Test
	public void hashCodeTest() {
		ocpFPDetailsDTO.hashCode();
	}

	@Test
	public void toStringTest() {
		ocpFPDetailsDTO.toString();
	}

}
