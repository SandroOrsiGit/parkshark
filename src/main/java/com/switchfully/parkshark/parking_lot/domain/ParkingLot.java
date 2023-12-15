package com.switchfully.parkshark.parking_lot.domain;

import com.switchfully.parkshark.parking_lot.domain.Address;
import com.switchfully.parkshark.parking_lot.domain.Category;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class ParkingLot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parking_lot_id")
	private long id;
	private String name;
	private Category category;
	@Column(name = "max_capacity")
	private int maxCapacity;
	@Column(name = "price_per_hour")
	private double pricePerHour;
	@OneToOne
	@JoinColumn(name = "fk_address_id")
	private Address address;
	@ManyToMany
	@JoinTable(name = "parking_lot_contact_person",
			joinColumns = {@JoinColumn (name = "parking_lot_id")},
	inverseJoinColumns = {@JoinColumn( name = "contact_person_id")})
	private List<ContactPerson> contactPersons;

	protected ParkingLot() {
	}

	public ParkingLot(String name, Category category, int maxCapacity, double pricePerHour, Address address, List<ContactPerson> contactPersons) {
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

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public double getPricePerHour() {
		return pricePerHour;
	}

	public Address getAddress() {
		return address;
	}

	public List<ContactPerson> getContactPersons() {
		return contactPersons;
	}
}