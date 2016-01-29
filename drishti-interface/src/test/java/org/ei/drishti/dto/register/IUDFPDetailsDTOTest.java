package org.ei.drishti.dto.register;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class IUDFPDetailsDTOTest {
	
	private IUDFPDetailsDTO iudFPDetailsDTO;

	@Before
	public void setUp(){
		iudFPDetailsDTO = new IUDFPDetailsDTO(null, null, null, null);
	}
	
	@Test
	public void equalsTest(){
		Object o = null;
		boolean t = iudFPDetailsDTO.equals(o);
		boolean x = false;
		assertEquals(t,x);
	}

	@Test
	public void hashCodeTest() {
		iudFPDetailsDTO.hashCode();
	}

	@Test
	public void toStringTest() {
		iudFPDetailsDTO.toString();
	}
}
