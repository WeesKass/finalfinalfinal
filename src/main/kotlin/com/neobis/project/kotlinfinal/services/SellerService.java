package com.neobis.project.kotlinfinal.services;

import com.neobis.project.kotlinfinal.entities.SellerEntity;
import com.neobis.project.kotlinfinal.exception.RecordNotFoundException;
import com.neobis.project.kotlinfinal.models.Seller;
import com.neobis.project.kotlinfinal.models.SellerAndUser;
import com.neobis.project.kotlinfinal.models.User;
import com.neobis.project.kotlinfinal.repositories.SellerRepository;
import com.neobis.project.kotlinfinal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SellerRepository sellerRepository;

    public Seller getSellerById(int sellerId) throws Exception{
        return new Seller(sellerRepository.findById(sellerId).orElseThrow(RecordNotFoundException::new));
    }


    public Seller saveSeller(SellerAndUser sellerAndUser) {

        userRepository.save(sellerAndUser.extractUser().convertToEntity());

        Seller seller = sellerAndUser.extractSeller();
        seller.setUserId(sellerAndUser.getUserId());

        SellerEntity saveResult = sellerRepository.save(seller.convertToEntity());
        return new Seller(saveResult);
    }

    public void deleteSellerById(int sellerId) throws Exception {
        int temp = getSellerById(sellerId).getUserId();
        sellerRepository.deleteById(sellerId);
        userRepository.deleteById(temp);
    }
}
