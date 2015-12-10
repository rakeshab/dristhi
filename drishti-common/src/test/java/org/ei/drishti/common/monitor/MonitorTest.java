package org.ei.drishti.common.monitor;
import org.junit.Before;
import org.junit.Test;

public class MonitorTest {
	private Monitor monitor;
	private Metric metric;
	private Probe probe;
	
	 @Before
    public void setUp(){
		 monitor = new Monitor();
    }

   @Test
   public void starttest() throws Exception {
	 
	   monitor.start(metric);;
	
   }
  
  }
