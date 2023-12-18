package com.switchfully.parkshark.parking_lot.domain;

import com.switchfully.parkshark.address.domain.Address;
import jakarta.persistence.*;

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

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_address_id")
	private Address address;

	protected ContactPerson() {
	}

	public ContactPerson(String name, String mobilePhoneNumber, String telephoneNumber, String email, Address address) {
		this.name = name;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
		this.address = address;
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
