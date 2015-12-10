package org.ei.drishti.common.util;

import static org.junit.Assert.*;

import org.ei.drishti.common.util.HttpResponse;
import org.junit.Before;
import org.junit.Test;

public class HttpResponseTest {
	
	private HttpResponse httpResponse;
	 @Before
  public void setUp(){
		 httpResponse = new HttpResponse(false, null);
  }

 @Test
 public void bodytest() throws Exception {
	 
	   Object body = null;
	assertEquals(body,httpResponse.body()); 
 }

 @Test
 public void isSuccesstest() throws Exception {
	 assertEquals("isSuccess", false, httpResponse.isSuccess());
	 

 }


}
