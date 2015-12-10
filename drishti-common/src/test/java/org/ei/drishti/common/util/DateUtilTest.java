package org.ei.drishti.common.util;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class DateUtilTest {

	private DateUtil dateUtil;
	

	@Before
	public void setUp() {
		dateUtil = new DateUtil();
	}

	@Test
	public void dateFormattest() throws Exception {

		dateUtil.dateFormat("2015-12-12", 231);

	}

	@Test
	public void datetimenowtest() throws Exception {

		dateUtil.datetimenow();

	}

	@Test
	public void tryParsetest() throws Exception {

		LocalDate defaultValue = null;
		dateUtil.tryParse("value", defaultValue);

	}

	@Test
	public void localDatetest() throws Exception {

		dateUtil.today();

	}

	@Test
	public void millistest() throws Exception {

		dateUtil.millis();

	}

}
