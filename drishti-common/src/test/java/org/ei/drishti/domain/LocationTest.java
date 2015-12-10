package org.ei.drishti.domain;

import static org.junit.Assert.assertEquals;

import org.ei.drishti.common.util.IntegerUtil;
import org.junit.Before;
import org.junit.Test;

public class LocationTest {
	
	private Location location;
	
	 @Before
    public void setUp(){
		 location = new Location(null, null, null);
    }
   @Test
   public void villageTest() throws Exception {
	   location.village();
   }

   
   @Test
   public void subCenterTest() throws Exception {
	   location.subCenter();
   }

   
   @Test
   public void phcTest() throws Exception {
	   location.phc();
   }

}
