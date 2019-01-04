package com.worldpay.offer.service;

import com.worldpay.offer.dao.OfferRepository;
import com.worldpay.offer.model.ApiResponse;
import com.worldpay.offer.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    OfferRepository offerRepository;

    private ApiResponse apiResponse = null;

    @Override
    public ApiResponse getOffers() {
        List<Offer> offers = new ArrayList<>();
        apiResponse = new ApiResponse();
        try{
            System.out.println("I am hereeeeeeeeeeeee");
            //System.out.println("$$$$$$$$$$ "+ offerRepository.findAll());
            offerRepository.findAll().forEach(offer -> offers.add(offer));
           // List Offer = offerRepository.findAll();
            apiResponse.setLstRespObj(offers);
        }catch (Exception e){
            e.printStackTrace();
            apiResponse.setResponseMsg(e.getMessage());
        }
        return apiResponse;
    }
}
