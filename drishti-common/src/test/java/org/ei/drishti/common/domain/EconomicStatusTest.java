package org.ei.drishti.common.domain;
import org.junit.Test;

public class EconomicStatusTest {
	
	@Test
	public void EconomicStatusTest(){
		assertThat(EconomicStatus.APL.values());
		assertThat(EconomicStatus.BPL.values());
		assertThat(EconomicStatus.NOT_SPECIFIED.values());

	}

	private void assertThat(EconomicStatus[] values) {
		// TODO Auto-generated method stub
		
	}
}
