package com.neobis.project.kotlinfinal.services;

import com.neobis.project.kotlinfinal.entities.AddressEntity;
import com.neobis.project.kotlinfinal.models.Address;
import com.neobis.project.kotlinfinal.models.AddressUserAndCustomer;
import com.neobis.project.kotlinfinal.models.Customer;
import com.neobis.project.kotlinfinal.models.User;
import com.neobis.project.kotlinfinal.repositories.AddressRepository;
import com.neobis.project.kotlinfinal.exception.RecordNotFoundException;
import com.neobis.project.kotlinfinal.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AddressService {

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserService userService;

    @Autowired
    CustomerService customerService;

    @Autowired
    private AddressRepository addressRepository;
    private Address address;

    public Address getAddressById(int addressId) throws Exception {
        return new Address(addressRepository.findById(addressId).orElseThrow(RecordNotFoundException::new));
    }

    public Address saveAddress(AddressUserAndCustomer addressUserAndCustomer) throws Exception {

        User user = userService.saveUser(addressUserAndCustomer.extractUser());

        AddressEntity saveResult = addressRepository.save(address.convertToEntity());

        Customer customer = addressUserAndCustomer.extractCustomer();
        customer.setUserId(user.getUserId());
        customer.setAddressId(address.getAddressId());
        customerService.saveCustomer(customer);

        return new Address(saveResult);
    }
    
    public void deleteAddressById(int addressId) {
        addressRepository.deleteById(addressId);
    }
}
