package com.neobis.project.kotlinfinal.controllers;

import com.neobis.project.kotlinfinal.models.Address;
import com.neobis.project.kotlinfinal.models.AddressUserAndCustomer;
import com.neobis.project.kotlinfinal.services.AddressService;
import com.neobis.project.kotlinfinal.services.CustomerService;
import com.neobis.project.kotlinfinal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Done
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    CustomerService customerService;
    @Autowired
    UserService userService;
    @Autowired
    private AddressService addressService;

    @RequestMapping("/")
    public String defaultAddress() {
        return "Default address endpoint";
    }


    // get address by address_id
    @RequestMapping(method = RequestMethod.GET)
    public Address getAddress(@RequestParam("id") int id) throws Exception {
        return addressService.getAddressById(id);
    }


    // update address
    @RequestMapping(method = RequestMethod.PUT)
    public void putAddress(@RequestBody AddressUserAndCustomer addressUserAndCustomer) throws Exception {
        addressService.saveAddress(addressUserAndCustomer);
    }

    // create new address
    @RequestMapping(method = RequestMethod.POST)
    public Address postAddress(@RequestBody AddressUserAndCustomer addressUserAndCustomer) throws Exception {
        return addressService.saveAddress(addressUserAndCustomer);
    }


    // delete address
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAddress(@PathVariable int id) {
        addressService.deleteAddressById(id);
    }
}
