package com.neobis.project.kotlinfinal.services;

import com.neobis.project.kotlinfinal.entities.CustomerEntity;
import com.neobis.project.kotlinfinal.models.Customer;
import com.neobis.project.kotlinfinal.models.CustomerAndUser;
import com.neobis.project.kotlinfinal.models.User;
import com.neobis.project.kotlinfinal.repositories.CustomerRepository;
import com.neobis.project.kotlinfinal.exception.RecordNotFoundException;
import com.neobis.project.kotlinfinal.models.Customer;
import com.neobis.project.kotlinfinal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;


    public Customer getCustomerById(int customerId) throws Exception {
        return new Customer(customerRepository.findById(customerId).orElseThrow(RecordNotFoundException::new));
    }

    public Customer saveCustomer(Customer customer) throws Exception {
        return new Customer(customerRepository.save(customer.convertToEntity()));
    }

    public Customer saveCustomer(CustomerAndUser customerAndUser) throws Exception {

        // check customer id
//        try {
//            customerService.getCustomerById(orderAndShipping.getCustomerId());
//        } catch (RecordNotFoundException e) {
//            throw new BadRequestException();
//        }

        // add shipping
        User user = userService.saveUser(customerAndUser.extractUser());

        // set the new id
        Customer customer = customerAndUser.extractCustomer();
        customer.setUserId(user.getUserId());

        CustomerEntity saveResult = customerRepository.save(customer.convertToEntity());
        return new Customer(saveResult);
    }

    public void deleteCustomerById(int customerId) {
        customerRepository.deleteById(customerId);
    }

    public void deleteCustomerByAddressId(int addressId) {
        customerRepository.deleteCustomerEntitiesByAddressId(addressId);

    }
}
