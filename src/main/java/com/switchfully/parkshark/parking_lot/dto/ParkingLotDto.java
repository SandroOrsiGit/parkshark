package com.switchfully.parkshark.parking_lot.dto;

import com.switchfully.parkshark.parking_lot.domain.Address;
import com.switchfully.parkshark.parking_lot.domain.Category;
import com.switchfully.parkshark.parking_lot.domain.ContactPerson;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

public class ParkingLotDto {

	private long id;
	private String name;
	private Category category;

	private Integer maxCapacity;

	private Double pricePerHour;

	private Address address;

	private List<ContactPerson> contactPersons;



	public ParkingLotDto(long id, String name, Category category, Integer maxCapacity, Double pricePerHour, Address address, List<ContactPerson> contactPersons) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.maxCapacity = maxCapacity;
		this.pricePerHour = pricePerHour;
		this.address = address;
		this.contactPersons = contactPersons;
	}

	public long getId() {
		return id;
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
