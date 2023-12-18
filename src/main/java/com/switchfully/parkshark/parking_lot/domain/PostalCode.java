package com.switchfully.parkshark.parking_lot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.transaction.annotation.Transactional;

@Entity
public class PostalCode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postal_code_id")
	private long id;

	@Column(name = "postal_code")
	private String postalCode;

	private String location;

	protected PostalCode() {
	}

	public PostalCode(String postalCode, String location) {
		this.postalCode = postalCode;
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getLocation() {
		return location;
	}
}
