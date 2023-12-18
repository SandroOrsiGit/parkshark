package com.switchfully.parkshark.address.domain;

import com.switchfully.parkshark.parking_lot.domain.PostalCode;
import jakarta.persistence.*;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private long id;

	@Column(name = "street_name")
	private String streetName;

	@Column(name = "street_number")
	private String streetNumber;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_postal_code_id")
	private PostalCode postalCode;

	protected Address() {
	}

	public Address(String streetName, String streetNumber, PostalCode postalCode) {
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
	}

	public long getId() {
		return id;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public PostalCode getPostalCode() {
		return postalCode;
	}
}
