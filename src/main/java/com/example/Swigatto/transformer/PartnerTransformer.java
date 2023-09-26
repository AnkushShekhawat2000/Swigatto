package com.example.Swigatto.transformer;

import com.example.Swigatto.dto.request.DeliveryPartnerRequest;
import com.example.Swigatto.model.DeliveryPartner;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

public class PartnerTransformer {

    public static DeliveryPartner PartnerRequestToDeliveryPartner(@RequestBody DeliveryPartnerRequest deliveryPartnerRequest){


        return DeliveryPartner.builder()
                .name(deliveryPartnerRequest.getName())
                .mobileNo(deliveryPartnerRequest.getMobileNo())
                .gender(deliveryPartnerRequest.getGender())
                .orders(new ArrayList<>())
                .build();


    }
}
