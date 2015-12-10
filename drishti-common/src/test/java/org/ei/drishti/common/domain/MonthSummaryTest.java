package org.ei.drishti.common.domain;
import org.junit.Before;
import org.junit.Test;

public class MonthSummaryTest {
	
	private MonthSummary monthSummary;
	 @Before
 public void setUp(){
		 monthSummary = new MonthSummary(null, null, null, null, null);
 }

@Test
public void monthtest() throws Exception {
	 
	monthSummary.month();
}

@Test
public void yeartest() throws Exception {
	 
	monthSummary.year();
}

@Test
public void currentProgresstest() throws Exception {
	 
	monthSummary.currentProgress();
}


@Test
public void aggregatedProgresstest() throws Exception {
	 
	monthSummary.aggregatedProgress();
}


@Test
public void externalIDstest() throws Exception {
	 
	monthSummary.externalIDs();
}

}
