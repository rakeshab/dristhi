package org.ei.drishti.common.domain;
import org.junit.Before;
import org.junit.Test;

public class UserDetailTest {
	
	private UserDetail userDetail;
	
	 @Before
    public void setUp(){
		 userDetail = new UserDetail(null, null);
    }
   @Test
   public void userNametest() throws Exception {
	   
	   userDetail.userName();
   }
   
   @Test
   public void rolestest() throws Exception {
	   
	   userDetail.roles();
   }

}
