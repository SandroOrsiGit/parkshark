package com.switchfully.parkshark.parking_lot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "street_name")
	private String streetName;

	@Column(name = "street_number")
	private String streetNumber;

	@OneToOne
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
