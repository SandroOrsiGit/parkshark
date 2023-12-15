package com.switchfully.parkshark.address;

import com.switchfully.parkshark.address.domain.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

//    public Address createAddress()
}
