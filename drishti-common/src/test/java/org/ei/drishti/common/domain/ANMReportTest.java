package org.ei.drishti.common.domain;
import org.junit.Before;
import org.junit.Test;

public class ANMReportTest {
	
	private ANMReport anmreport;
	
	 @Before
   public void setUp(){
		 anmreport = new ANMReport(null, null);
   }
  @Test
  public void summariestest() throws Exception {
	   
	  anmreport.summaries();
  }

  @Test
  public void anmIdentifiertest() throws Exception {
	   
	  anmreport.anmIdentifier();
  }


}
