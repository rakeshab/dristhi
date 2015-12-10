package org.ei.drishti.common.audit;
import org.junit.Before;
import org.junit.Test;

public class ForbiddenFieldInAuditMessageTest {
	
	private ForbiddenFieldInAuditMessage forbiddenFieldInAuditMessage;
	
	 @Before
    public void setUp(){
		 forbiddenFieldInAuditMessage = new ForbiddenFieldInAuditMessage(null, "sdaf", "sadf");
    }
   @Test
   public void ForbiddenFieldInAuditMessagetest() throws Exception {
	
      
   }

}
