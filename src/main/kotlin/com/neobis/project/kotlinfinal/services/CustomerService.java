package com.neobis.project.kotlinfinal.services;

import com.neobis.project.kotlinfinal.entities.CustomerEntity;
import com.neobis.project.kotlinfinal.models.AddressUserAndCustomer;
import com.neobis.project.kotlinfinal.models.Customer;

import com.neobis.project.kotlinfinal.repositories.AddressRepository;
import com.neobis.project.kotlinfinal.repositories.CustomerRepository;
import com.neobis.project.kotlinfinal.exception.RecordNotFoundException;

import com.neobis.project.kotlinfinal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    public Customer getCustomerById(int customerId) throws Exception {
        return new Customer(customerRepository.findById(customerId).orElseThrow(RecordNotFoundException::new));
    }public Customer getCustomerByUserId(int customerId){
        return new Customer(customerRepository.findByUserId(customerId));
    }

    public Customer saveCustomer(AddressUserAndCustomer addressUserAndCustomer) {

        try {
            userService.getUserById(addressUserAndCustomer.getUserId());
            addressService.getAddressById(addressUserAndCustomer.getAddressId());
        } catch (Exception e) {
            userRepository.save(addressUserAndCustomer.extractUser().convertToEntity());
            addressRepository.save(addressUserAndCustomer.extractAddress().convertToEntity());
        }

        return new Customer(customerRepository.save(addressUserAndCustomer.extractCustomer().convertToEntity()));
    }


    public void deleteCustomerById(int customerId) {
        customerRepository.deleteById(customerId);
    }

}
