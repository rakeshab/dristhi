package org.ei.drishti.dto.register;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PNCRegisterDTOTest {
	
	private PNCRegisterDTO pncRegisterDTO;

	@Before
	public void setUp(){
		pncRegisterDTO = new PNCRegisterDTO(null);
	}
	
	@Test
	public void equalsTest(){
		Object o = null;
		boolean t = pncRegisterDTO.equals(o);
		boolean x = false;
		assertEquals(t,x);
	}

	@Test
	public void hashCodeTest() {
		pncRegisterDTO.hashCode();
	}

	@Test
	public void toStringTest() {
		pncRegisterDTO.toString();
	}
}
