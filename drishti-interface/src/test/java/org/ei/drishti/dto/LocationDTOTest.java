package org.ei.drishti.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LocationDTOTest {
	
	private LocationDTO locationDTO;

	@Before
	public void setUp(){
		locationDTO = new LocationDTO(null, null, null, null, null);
	}
	
	@Test
	public void equalsTest(){
		Object o = null;
		boolean t = locationDTO.equals(o);
		boolean x = false;
		assertEquals(t,x);
	}

	@Test
	public void hashCodeTest() {
		locationDTO.hashCode();
	}

	@Test
	public void toStringTest() {
		locationDTO.toString();
	}
	
}
