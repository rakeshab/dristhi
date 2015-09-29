package org.ei.drishti.reporting.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "user_masters")



public class User_masters {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "user_role")
	private String user_role;

	@Column(name = "user_id")
	private String user_id;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	@Column(name = "confirm_password")
	private String confirm_password;

	@Column(name = "phone_number")
	private String phone_number;

	@Column(name = "email")
	private String email;

	@Column(name = "country")
	private String country;

	@Column(name = "county")
	private String county;

	@Column(name = "district")
	private String district;
	@Column(name = "subdistrict")
	private String subdistrict;

	@Column(name = "subcenter")
	private String subcenter;

	@Column(name = "vilages")
	private String vilages;

	@Column(name = "hospital")
	private String hospital;
	public User_masters(Integer id, String user_role, String user_id,
			String name, String password, String confirm_password,
			String phone_number, String email, String country, String county,
			String district, String subdistrict, String subcenter,
			String vilages, String hospital, String lastname, boolean active) {
		super();
		this.id = id;
		this.user_role = user_role;
		this.user_id = user_id;
		this.name = name;
		this.password = password;
		this.confirm_password = confirm_password;
		this.phone_number = phone_number;
		this.email = email;
		this.country = country;
		this.county = county;
		this.district = district;
		this.subdistrict = subdistrict;
		this.subcenter = subcenter;
		this.vilages = vilages;
		this.hospital = hospital;
		this.lastname = lastname;
		this.active = active;
	}

	public User_masters() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "active")
	private boolean active;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getSubdistrict() {
		return subdistrict;
	}

	public void setSubdistrict(String subdistrict) {
		this.subdistrict = subdistrict;
	}

	public String getSubcenter() {
		return subcenter;
	}

	public void setSubcenter(String subcenter) {
		this.subcenter = subcenter;
	}

	public String getVilages() {
		return vilages;
	}

	public void setVilages(String vilages) {
		this.vilages = vilages;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

}
