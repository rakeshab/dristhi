package org.ei.drishti.common.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerUtilTest {
	private IntegerUtil integerUtil;
	
	 @Before
     public void setUp(){
		 integerUtil = new IntegerUtil();
     }
    @Test
    public void shouldParseIntSafely() throws Exception {
        assertEquals(0, IntegerUtil.tryParse("", 0));
        assertEquals(2, IntegerUtil.tryParse(null, 2));
        assertEquals(0, IntegerUtil.tryParse("0", 1));
        assertEquals(3, IntegerUtil.tryParse("3", 3));
    }
    
    @Test
    public void parseValidIntegersAndDefaultInvalidOnesToEmptyStringtest() throws Exception {
     
        assertEquals("3", IntegerUtil.parseValidIntegersAndDefaultInvalidOnesToEmptyString("3"));
        assertNotNull("null", IntegerUtil.parseValidIntegersAndDefaultInvalidOnesToEmptyString("null1"));
        
  }
}
