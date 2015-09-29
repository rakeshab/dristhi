package org.ei.drishti.reporting.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Table(name = "health_centers")
//@NamedQuery name = Poc_table.FIND_BY_PHC_NAME, queryselect parent_hospital from report.health_centers where hospital_name=(select subcenter from report.user_masters where user_id='"+anmid+"') and hospital_type='Subcenter'";

public class Health_centers {
    
   public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHospital_name() {
		return hospital_name;
	}
	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}
	public String getHospital_type() {
		return hospital_type;
	}
	public void setHospital_type(String hospital_type) {
		this.hospital_type = hospital_type;
	}
	public String getHospital_address() {
		return hospital_address;
	}
	public void setHospital_address(String hospital_address) {
		this.hospital_address = hospital_address;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getCounty_name() {
		return county_name;
	}
	public void setCounty_name(String county_name) {
		this.county_name = county_name;
	}
	public String getDistrict_name() {
		return district_name;
	}
	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}
	public String getSubdistrict_name() {
		return subdistrict_name;
	}
	public void setSubdistrict_name(String subdistrict_name) {
		this.subdistrict_name = subdistrict_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getParent_hospital() {
		return parent_hospital;
	}
	public void setParent_hospital(String parent_hospital) {
		this.parent_hospital = parent_hospital;
	}
	public String getVillages() {
		return villages;
	}
	public void setVillages(String villages) {
		this.villages = villages;
	}
	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o, new String[] { "id" });
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, new String[] { "id" });
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "hospital_name")
    private String hospital_name;
    @Column(name = "hospital_type")
    private String hospital_type;
    @Column(name = "hospital_address")
    private String hospital_address;
    @Column(name = "country_name")
    private String country_name;
    @Column(name = "county_name")
    private String county_name;
    @Column(name = "district_name")
    private String district_name;
    @Column(name = "subdistrict_name")
    private String subdistrict_name;
    @Column(name = "location")
    private String location; 
    @Column(name = "parent_hospital")
    private String parent_hospital;
    @Column(name = "villages")
    private String villages;
    public Health_centers() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(name = "active")
    private boolean active;
	public Health_centers(Integer id, String hospital_name,
			String hospital_type, String hospital_address, String country_name,
			String county_name, String district_name, String subdistrict_name,
			String location, String parent_hospital, String villages,
			boolean active) {
		super();
		this.id = id;
		this.hospital_name = hospital_name;
		this.hospital_type = hospital_type;
		this.hospital_address = hospital_address;
		this.country_name = country_name;
		this.county_name = county_name;
		this.district_name = district_name;
		this.subdistrict_name = subdistrict_name;
		this.location = location;
		this.parent_hospital = parent_hospital;
		this.villages = villages;
		this.active = active;
	}
    
    
    
    
    

  
}
