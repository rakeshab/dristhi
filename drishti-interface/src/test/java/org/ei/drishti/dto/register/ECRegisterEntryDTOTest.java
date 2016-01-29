package org.ei.drishti.dto.register;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ECRegisterEntryDTOTest {
	
	private ECRegisterEntryDTO ecRegisterEntryDTO;
	
	@Before
	public void setUp(){
		ecRegisterEntryDTO = new ECRegisterEntryDTO();
	}
		
	@Test
	public void withRegistrationDateTest(){
		ecRegisterEntryDTO.withRegistrationDate("registrationDate");
	}
	
	@Test
	public void withECNumberTest(){
		ecRegisterEntryDTO.withECNumber("ecNumber");
	}
	
	@Test
	public void withWifeNameTest(){
		ecRegisterEntryDTO.withWifeName("wifeName");
	}
	
	@Test
	public void withHusbandNameTest(){
		ecRegisterEntryDTO.withHusbandName("husbandName");
	}
	
	@Test
	public void withWifeAgeTest(){
		ecRegisterEntryDTO.withWifeAge("wifeAge");
	}
	
	@Test
	public void withHusbandAgeTest(){
		ecRegisterEntryDTO.withHusbandAge("husbandAge");
	}
	
	@Test
	public void withHouseholdAddressTest(){
		ecRegisterEntryDTO.withHouseholdAddress("householdAddress");
	}
	
	@Test
	public void withWifeEducationLevelTest(){
		ecRegisterEntryDTO.withWifeEducationLevel("wifeEducationLevel");
	}
	
	@Test
	public void withHouseholdNumberTest(){
		ecRegisterEntryDTO.withHouseholdNumber("householdNumber");
	}
	
	@Test
	public void withHeadOfHouseholdTest(){
		ecRegisterEntryDTO.withHeadOfHousehold("headOfHousehold");
	}
	
	@Test
	public void withSubCenterTest(){
		ecRegisterEntryDTO.withSubCenter("subCenter");
	}
	
	@Test
	public void withPHCTest(){
		ecRegisterEntryDTO.withPHC("phc");
	}
	
	@Test
	public void withVillageTest(){
		ecRegisterEntryDTO.withVillage("village");
	}
	
	@Test
	public void withHusbandEducationLevelTest(){
		ecRegisterEntryDTO.withHusbandEducationLevel("husbandEducationLevel");
	}
	
	@Test
	public void withCasteTest(){
		ecRegisterEntryDTO.withCaste("caste");
	}
	
	@Test
	public void withReligionTest(){
		ecRegisterEntryDTO.withReligion("religion");
	}
	
	@Test
	public void withEconomicStatusTest(){
		ecRegisterEntryDTO.withEconomicStatus("economicStatus");
	}
	
	@Test
	public void withGravidaTest(){
		ecRegisterEntryDTO.withGravida("gravida");
	}
	
	@Test
	public void withParityTest(){
		ecRegisterEntryDTO.withParity("parity");
	}
	
	@Test
	public void withNumberOfLivingChildrenTest(){
		ecRegisterEntryDTO.withNumberOfLivingChildren("numberOfLivingChildren");
	}
	
	@Test
	public void withNumberOfStillBirthsTest(){
		ecRegisterEntryDTO.withNumberOfStillBirths("numberOfStillBirths");
	}
	
	@Test
	public void withNumberOfAbortionsTest(){
		ecRegisterEntryDTO.withNumberOfAbortions("numberOfAbortions");
	}
	
	@Test
	public void withNumberOfLivingMaleChildrenTest(){
		ecRegisterEntryDTO.withNumberOfLivingMaleChildren("numberOfLivingMaleChildren");
	}
	
	@Test
	public void withNumberOfLivingFemaleChildrenTest(){
		ecRegisterEntryDTO.withNumberOfLivingFemaleChildren("numberOfLivingFemaleChildren");
	}
	
	@Test
	public void withYoungestChildAgeTest(){
		ecRegisterEntryDTO.withYoungestChildAge("youngestChildAge");
	}
	
	@Test
	public void withCurrentFPMethodTest(){
		ecRegisterEntryDTO.withCurrentFPMethod("fpMethod");
	}
	
	@Test
	public void withCurrentFPMethodStartDateTest(){
		ecRegisterEntryDTO.withCurrentFPMethodStartDate("startDate");
	}
	
	@Test
	public void withPregnancyStatusTest(){
		ecRegisterEntryDTO.withPregnancyStatus("isPregnant");
	}
	
	@Test
	public void equalsTest(){
		Object o = null;
		boolean t= ecRegisterEntryDTO.equals(o);
		boolean x = false;
		assertEquals(t,x);
	}

	@Test
	public void hashCodeTest() {
		ecRegisterEntryDTO.hashCode();
	}

	@Test
	public void toStringTest() {
		ecRegisterEntryDTO.toString();
	}
}
