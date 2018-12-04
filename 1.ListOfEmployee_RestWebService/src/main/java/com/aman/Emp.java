package com.aman;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"dateDob","empAddress"})
@JsonPropertyOrder({"name","id", "dateDob","empAddress"})
public class Emp {
	
	private int id;
	
	@JsonProperty("employee_name")
	private String name;
	private Date dateDob;
	private Address empAddress;

	public Emp() {}
	
	public Address getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(Address empAddress) {
		this.empAddress = empAddress;
	}
	
	public Date getDateDob() {
		return dateDob;
	}

	public void setDateDob(Date dateDob) {
		this.dateDob = dateDob;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

