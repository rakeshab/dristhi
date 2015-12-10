package org.ei.drishti.common.domain;
import org.junit.Before;
import org.junit.Test;

public class ReportDataDeleteRequestTest {
	
	private ReportDataDeleteRequest reportDataDeleteRequest;
	
	 @Before
    public void setUp(){
		 reportDataDeleteRequest = new ReportDataDeleteRequest();
    }
   @Test
   public void typetest() throws Exception {
	   
	   reportDataDeleteRequest.type();
   }

   
   @Test
   public void anmReportDataDeleteRequesttest() throws Exception {
	   
	   reportDataDeleteRequest.anmReportDataDeleteRequest("dristhiEntityId");
   }
   
   @Test
   public void serviceProvidedDataDeleteRequesttest() throws Exception {
	   
	   reportDataDeleteRequest.serviceProvidedDataDeleteRequest("dristhiEntityId");
   }
   
   @Test
   public void dristhiEntityIdtest() throws Exception {
	   
	   reportDataDeleteRequest.dristhiEntityId();
   }
   
   @Test
   public void withDristhiEntityIdtest() throws Exception {
	   
	   reportDataDeleteRequest.withDristhiEntityId("dristhiEntityId");//dristhiEntityId();
   }
   
   @Test
   public void withTypetest() throws Exception {
	   
	   reportDataDeleteRequest.withType("type");//withDristhiEntityId("dristhiEntityId");//dristhiEntityId();
   }
   
}
