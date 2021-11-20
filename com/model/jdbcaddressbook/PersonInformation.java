package com.model.jdbcaddressbook;

import java.util.Objects;

public class PersonInformation {
	public int id;
	public String first_name;
	public String last_name;
	public String address;
	public String city;
	public String state;
	public int zip;
	public int mobilenumber;
	public String email;

	public PersonInformation() {
	}

	public PersonInformation(String first_name, String last_name, String address, String city, String state, int zip, int mobilenumber, String email) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.mobilenumber = mobilenumber;
		this.email = email;
	}

	public PersonInformation(int id,String first_name, String last_name, String address, String city, String state, int zip, int mobilenumber, String email) {
		this(first_name, last_name, address, city, state, zip, mobilenumber, email);
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PersonInformation that = (PersonInformation) o;
		return id == that.id && Objects.equals(first_name, that.first_name) && Objects.equals(state, that.state);
	}
}


