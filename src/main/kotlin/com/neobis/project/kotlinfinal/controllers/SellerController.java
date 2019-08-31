package com.neobis.project.kotlinfinal.controllers;

import com.neobis.project.kotlinfinal.models.Seller;
import com.neobis.project.kotlinfinal.models.SellerAndUser;
import com.neobis.project.kotlinfinal.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

//Done

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @RequestMapping("/")
    public String defaultSeller() {
        return "Default seller endpoint";
    }


    // get seller by seller_id

    @RequestMapping(method = RequestMethod.GET)
    public Seller getSellerById(@PathParam("id") int id) throws Exception {
        return sellerService.getSellerById(id);
    }


    // update seller information

    @RequestMapping(method = RequestMethod.PUT)
    public void updateSeller(@RequestBody SellerAndUser sellerAndUser){
        sellerService.saveSeller(sellerAndUser);
    }


    // create new seller

    @RequestMapping(method = RequestMethod.POST)
    public Seller createSeller(@RequestBody SellerAndUser sellerAndUser){
        return sellerService.saveSeller(sellerAndUser);
    }


    // delete seller

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteSellerById(@PathParam("id") int id) throws Exception {
        sellerService.deleteSellerById(id);
    }
}

