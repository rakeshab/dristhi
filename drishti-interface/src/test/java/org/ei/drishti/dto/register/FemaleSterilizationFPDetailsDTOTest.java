package org.ei.drishti.dto.register;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FemaleSterilizationFPDetailsDTOTest {
	
	private FemaleSterilizationFPDetailsDTO femaleSterilizationFPDetailsDTO;

	@Before
	public void setUp(){
		femaleSterilizationFPDetailsDTO = new FemaleSterilizationFPDetailsDTO(null, null, null);
	}
	
	@Test
	public void equalsTest(){
		Object o = null;
		boolean t = femaleSterilizationFPDetailsDTO.equals(o);
		boolean x = false;
		assertEquals(t,x);
	}

	@Test
	public void hashCodeTest() {
		femaleSterilizationFPDetailsDTO.hashCode();
	}

	@Test
	public void toStringTest() {
		femaleSterilizationFPDetailsDTO.toString();
	}
}
