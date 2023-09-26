package com.example.Swigatto.service;

import com.example.Swigatto.dto.request.DeliveryPartnerRequest;
import com.example.Swigatto.model.DeliveryPartner;
import com.example.Swigatto.repository.DeliveryPartnerRepository;
import com.example.Swigatto.transformer.PartnerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;

@Service
public class DeliveryPartnerService {

    final DeliveryPartnerRepository deliveryPartnerRepository;

    @Autowired
    public DeliveryPartnerService(DeliveryPartnerRepository deliveryPartnerRepository) {
        this.deliveryPartnerRepository = deliveryPartnerRepository;
    }

    public String addPartner(DeliveryPartnerRequest deliveryPartnerRequest) {

        // dto entity

        DeliveryPartner deliveryPartner = PartnerTransformer.PartnerRequestToDeliveryPartner(deliveryPartnerRequest);

        // save
        DeliveryPartner savedPartner = deliveryPartnerRepository.save(deliveryPartner);

        return "You have been susscessfully resgistered!!!";

    }
}
