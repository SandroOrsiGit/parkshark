package com.switchfully.parkshark.parking_lot.domain;

import com.switchfully.parkshark.address.domain.Address;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ParkingLot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parking_lot_id")
	private long id;
	private String name;
	@Enumerated (EnumType.STRING)
	private Category category;
	@Column(name = "max_capacity")
	private Integer maxCapacity;
	@Column(name = "price_per_hour")
	private Double pricePerHour;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_address_id")
	private Address address;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "parking_lot_contact_person",
			joinColumns = {@JoinColumn (name = "fk_parking_lot_id")},
	inverseJoinColumns = {@JoinColumn( name = "fk_contact_person_id")})
	private List<ContactPerson> contactPersons;

	protected ParkingLot() {
	}

	public ParkingLot(String name, Category category, Integer maxCapacity, Double pricePerHour, Address address, List<ContactPerson> contactPersons) {
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
