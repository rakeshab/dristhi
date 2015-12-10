package org.ei.drishti.common.util;
import org.junit.Before;
import org.junit.Test;

public class EasyMapTest {
	
private EasyMap easyMap;
	
	@Before 
	public void setUp(){
		easyMap = new EasyMap();
	}
	
	@Test
	public void EasyMapTest(){
		easyMap.map();
	}
	
	@Test
	public void mapOfTest(){
		Object value = null;
		Object key = null;
		easyMap.mapOf(key, value);
	}

	@Test
	public void createTest(){
		Object value = null;
		Object key = null;
		easyMap.create(key, value);
	}
	
	@Test
	public void putTest(){
		Object value = null;
		Object key = null;
		easyMap.put(key, value);
	}
	
	/*@Test
	public void putAllTest(){
		Map map = null;
		easyMap.putAll(map);
	}*/
}
