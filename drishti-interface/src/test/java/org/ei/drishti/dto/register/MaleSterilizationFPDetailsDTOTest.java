package org.ei.drishti.dto.register;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MaleSterilizationFPDetailsDTOTest {
	
	private MaleSterilizationFPDetailsDTO maleSterilizationFPDetailsDTO;

	@Before
	public void setUp(){
		maleSterilizationFPDetailsDTO = new MaleSterilizationFPDetailsDTO(null, null, null);
	}
	
	@Test
	public void equalsTest(){
		Object o = null;
		boolean t = maleSterilizationFPDetailsDTO.equals(o);
		boolean x = false;
		assertEquals(t,x);
	}

	@Test
	public void hashCodeTest() {
		maleSterilizationFPDetailsDTO.hashCode();
	}

	@Test
	public void toStringTest() {
		maleSterilizationFPDetailsDTO.toString();
	}
}
