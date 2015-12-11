package org.ei.drishti.dto.register;

import org.junit.Before;
import org.junit.Test;

public class CondomRegisterEntryDTOTest {
	
	private CondomRegisterEntryDTO condomRegisterEntryDTO;
	
	@Before
	public void setUp(){
		condomRegisterEntryDTO = new CondomRegisterEntryDTO();
	}
	
	@Test
	public void ecNumberTest(){
		condomRegisterEntryDTO.ecNumber();
	}
	
	@Test
	public void wifeNameTest(){
		condomRegisterEntryDTO.wifeName();
	}
	
	@Test
	public void husbandNameTest(){
		condomRegisterEntryDTO.husbandName();
	}
	
	@Test
	public void villageTest(){
		condomRegisterEntryDTO.village();
	}
	
	@Test
	public void subCenterTest(){
		condomRegisterEntryDTO.subCenter();
	}
	
	@Test
	public void wifeAgeTest(){
		condomRegisterEntryDTO.wifeAge();
	}
	
	@Test
	public void casteTest(){
		condomRegisterEntryDTO.caste();
	}
	
	@Test
	public void religionTest(){
		condomRegisterEntryDTO.religion();
	}
	
	@Test
	public void numberOfLivingMaleChildrenTest(){
		condomRegisterEntryDTO.numberOfLivingMaleChildren();
	}
	
	@Test
	public void numberOfLivingFemaleChildrenTest(){
		condomRegisterEntryDTO.numberOfLivingFemaleChildren();
	}
	
	@Test
	public void wifeEducationLevelTest(){
		condomRegisterEntryDTO.wifeEducationLevel();
	}
	
	@Test
	public void husbandEducationLevelTest(){
		condomRegisterEntryDTO.husbandEducationLevel();
	}
	
	@Test
	public void fpDetailsTest(){
		condomRegisterEntryDTO.fpDetails();
	}
	
	@Test
	public void withEcNumberTest(){
		condomRegisterEntryDTO.withEcNumber("ecNumber");
	}
	
	@Test
	public void withWifeNameTest(){
		condomRegisterEntryDTO.withWifeName("wifeName");
	}
	
	@Test
	public void withHusbandNameTest(){
		condomRegisterEntryDTO.withHusbandName("husbandName");
	}
	
	@Test
	public void withVillageTest(){
		condomRegisterEntryDTO.withVillage("village");
	}
	
	@Test
	public void withSubCenterTest(){
		condomRegisterEntryDTO.withSubCenter("subCenter");
	}
	
	@Test
	public void withWifeAgeTest(){
		condomRegisterEntryDTO.withWifeAge("wifeAge");
	}
	
	@Test
	public void withCasteTest(){
		condomRegisterEntryDTO.withCaste("caste");
	}
	
	@Test
	public void withReligionTest(){
		condomRegisterEntryDTO.withReligion("religion");
	}
	
	@Test
	public void withNumberOfLivingMaleChildrenTest(){
		condomRegisterEntryDTO.withNumberOfLivingMaleChildren("numberOfLivingMaleChildren");
	}
	
	@Test
	public void withNumberOfLivingFemaleChildrenTest(){
		condomRegisterEntryDTO.withNumberOfLivingFemaleChildren("numberOfLivingFemaleChildren");
	}
	
	@Test
	public void withWifeEducationLevelTest(){
		condomRegisterEntryDTO.withWifeEducationLevel("wifeEducationLevel");
	}
	
	@Test
	public void withHusbandEducationLevelTest(){
		condomRegisterEntryDTO.withHusbandEducationLevel("husbandEducationLevel");
	}
	
	@Test
	public void withFpDetailsTest(){
		CondomFPDetailsDTO fpDetails = null;
		condomRegisterEntryDTO.withFpDetails(fpDetails);
	}

}
