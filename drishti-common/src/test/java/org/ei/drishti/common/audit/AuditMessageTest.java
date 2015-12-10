package org.ei.drishti.common.audit;

import org.junit.Before;
import org.junit.Test;

public class AuditMessageTest {
	
	private AuditMessage auditMessage;
	
	 @Before
   public void setUp(){
		 auditMessage = new AuditMessage(null, 0, null, null);
   }
  @Test
  public void typetest() throws Exception {
	
	  auditMessage.type();
  }

  @Test
  public void indextest() throws Exception {
	
	  auditMessage.index();
  }
  
  @Test
  public void datatest() throws Exception {
	
	  auditMessage.data();
  }

  @Test
  public void timetest() throws Exception {
	
	  auditMessage.time();
  }


}
