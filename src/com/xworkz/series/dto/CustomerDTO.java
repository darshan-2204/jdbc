package com.xworkz.series.dto;

import java.io.Serializable;

import com.xworkz.series.constants.Education;

public class CustomerDTO implements Serializable {
	
	private int id;
	private String name;
	private String from;
	private String to;
	private String address;
	private boolean married;
	private int passportNo;
	private Education education;
	
	public CustomerDTO() {
		
	}

  public CustomerDTO(int id) {
	  this.id = id;
	}

	

	public CustomerDTO( String name, String from, String to, String address, boolean married, int passportNo,
			Education education) {
		super();
		
		this.name = name;
		this.from = from;
		this.to = to;
		this.address = address;
		this.married = married;
		this.passportNo = passportNo;
		this.education = education;
	}

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", name=" + name + ", from=" + from + ", to=" + to + ", address=" + address
				+ ", married=" + married + ", passportNo=" + passportNo + ", education=" + education + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		if (id != other.id)
			return false;
		return true;
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



	public String getFrom() {
		return from;
	}



	public void setFrom(String from) {
		this.from = from;
	}



	public String getTo() {
		return to;
	}



	public void setTo(String to) {
		this.to = to;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public boolean isMarried() {
		return married;
	}



	public void setMarried(boolean married) {
		this.married = married;
	}



	public int getPassportNo() {
		return passportNo;
	}



	public void setPassportNo(int passportNo) {
		this.passportNo = passportNo;
	}



	public Education getEducation() {
		return education;
	}



	public void setEducation(Education education) {
		this.education = education;
	}

}
