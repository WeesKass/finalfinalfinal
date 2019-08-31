package com.neobis.project.kotlinfinal.services;

import com.neobis.project.kotlinfinal.models.Address;
import com.neobis.project.kotlinfinal.models.AddressUserAndCustomer;
import com.neobis.project.kotlinfinal.models.Customer;
import com.neobis.project.kotlinfinal.repositories.CustomerRepository;
import com.neobis.project.kotlinfinal.repositories.UserRepository;
import com.neobis.project.kotlinfinal.services.CustomerService;
import com.neobis.project.kotlinfinal.repositories.AddressRepository;
import com.neobis.project.kotlinfinal.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;



    public Address getAddressById(int addressId) throws Exception {
        return new Address(addressRepository.findById(addressId).orElseThrow(RecordNotFoundException::new));
    }

    public Address saveAddress(AddressUserAndCustomer addressUserAndCustomer) {
        try {
            userService.getUserById(addressUserAndCustomer.getUserId());
            customerService.getCustomerById(addressUserAndCustomer.getUserId());
        } catch (Exception e) {
            userRepository.save(addressUserAndCustomer.extractUser().convertToEntity());
            customerRepository.save(addressUserAndCustomer.extractCustomer().convertToEntity());

        }
        return new Address(addressRepository.save(addressUserAndCustomer.extractAddress().convertToEntity()));
    }
    
    public void deleteAddressById(int addressId) {
        addressRepository.deleteById(addressId);
    }
}
