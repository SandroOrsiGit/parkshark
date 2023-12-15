package com.switchfully.parkshark.parking_lot.dto;

import com.switchfully.parkshark.address.domain.Address;
import com.switchfully.parkshark.parking_lot.domain.Category;
import com.switchfully.parkshark.parking_lot.domain.ContactPerson;

import java.util.List;

public class CreateParkingLotDto {

	private String name;
	private Category category;

	private Integer maxCapacity;

	private Double pricePerHour;

	private Address address;

	private List<ContactPerson> contactPersons;



	public CreateParkingLotDto(String name, Category category, Integer maxCapacity, Double pricePerHour, Address address, List<ContactPerson> contactPersons) {
		this.name = name;
		this.category = category;
		this.maxCapacity = maxCapacity;
		this.pricePerHour = pricePerHour;
		this.address = address;
		this.contactPersons = contactPersons;
	}


	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

	public Integer getMaxCapacity() {
		return maxCapacity;
	}

	public Double getPricePerHour() {
		return pricePerHour;
	}

	public Address getAddress() {
		return address;
	}

	public List<ContactPerson> getContactPersons() {
		return contactPersons;
	}


}
