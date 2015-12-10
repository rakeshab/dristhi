package org.ei.drishti.common.monitor;
import org.junit.Before;
import org.junit.Test;

public class ProbeTest {
	private Probe prob;

	@Before
	public void setUp() {
		prob = new Probe(null);
	}

	@Test
	public void metrictest() throws Exception {

		prob.metric();

	}

	@Test
	public void valuetest() throws Exception {

		prob.value();

	}
}
