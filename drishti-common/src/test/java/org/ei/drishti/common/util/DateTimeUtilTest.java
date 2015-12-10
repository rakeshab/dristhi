package org.ei.drishti.common.util;
import org.ei.drishti.common.util.DateTimeUtil;
import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

public class DateTimeUtilTest {
	
	private DateTimeUtil dateTimeUtil;
	
@Before
 public void setUp(){
		 dateTimeUtil = new DateTimeUtil();
 }

@Test
public void fakeIttest() throws Exception {
	
	LocalDateTime fakeDateTime = null;
	dateTimeUtil.fakeIt(fakeDateTime);
	
}
@Test
public void ttest() throws Exception {

	dateTimeUtil.now();
  
}


}
