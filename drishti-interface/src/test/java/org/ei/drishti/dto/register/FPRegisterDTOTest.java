package org.ei.drishti.dto.register;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FPRegisterDTOTest {
	
	private FPRegisterDTO fpRegisterDTO;
	
	@Before
	public void setUp(){
		fpRegisterDTO = new FPRegisterDTO(null, null, null, null, null, null);
	}
	
	@Test
	public void equalsTest(){
		Object o = null;
		boolean t = fpRegisterDTO.equals(o);
		boolean x = false;
		assertEquals(t,x);
	}

	@Test
	public void hashCodeTest() {
		fpRegisterDTO.hashCode();
	}

	@Test
	public void toStringTest() {
		fpRegisterDTO.toString();
	}

}
