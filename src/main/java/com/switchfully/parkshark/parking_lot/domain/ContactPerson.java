package com.switchfully.parkshark.parking_lot.domain;

import com.switchfully.parkshark.address.domain.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class ContactPerson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_person_id")
	private long id;

	private String name;

	@Column(name = "mobile_phone_number")
	private String mobilePhoneNumber;

	@Column(name = "telephone_number")
	private String telephoneNumber;

	private String email;

	@OneToOne
	@JoinColumn(name = "fk_address_id")
	private Address address;

	protected ContactPerson() {
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public Address getAddress() {
		return address;
	}
}
