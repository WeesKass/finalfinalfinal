package com.neobis.project.kotlinfinal.services;

import com.neobis.project.kotlinfinal.entities.ShippingEntity;
import com.neobis.project.kotlinfinal.models.Shipping;
import com.neobis.project.kotlinfinal.repositories.ShippingRepository;
import com.neobis.project.kotlinfinal.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    @Autowired
    private ShippingRepository shippingRepository;

    public Shipping getShippingById(int shippingId) throws Exception {
        return new Shipping(shippingRepository.findById(shippingId).orElseThrow(RecordNotFoundException::new));
    }

    public Shipping saveShipping(Shipping shipping) {
        ShippingEntity saveResult = shippingRepository.save(shipping.convertToEntity());
        return new Shipping(saveResult);
    }

    public void deleteShippingById(int shippingId) {
        shippingRepository.deleteById(shippingId);
    }

}
