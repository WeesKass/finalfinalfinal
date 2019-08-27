package com.neobis.project.kotlinfinal.services;

import com.neobis.project.kotlinfinal.entities.SellerEntity;
import com.neobis.project.kotlinfinal.exception.RecordNotFoundException;
import com.neobis.project.kotlinfinal.models.Seller;
import com.neobis.project.kotlinfinal.models.SellerAndUser;
import com.neobis.project.kotlinfinal.models.User;
import com.neobis.project.kotlinfinal.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerService {
    @Autowired
    private UserService userService;

    @Autowired
    private SellerRepository sellerRepository;

    public Seller getSellerById(int sellerId) throws Exception{
        return new Seller(sellerRepository.findById(sellerId).orElseThrow(RecordNotFoundException::new));
    }


    public Seller saveSeller(SellerAndUser sellerAndUser) throws Exception{

        User user = userService.saveUser(sellerAndUser.extractUser());

        Seller seller = sellerAndUser.extractSeller();
        seller.setUserId(user.getUserId());

        SellerEntity saveResult = sellerRepository.save(seller.convertToEntity());
        return new Seller(saveResult);
    }

    public void deleteSellerById(int sellerId) {
        sellerRepository.deleteById(sellerId);
    }
}
