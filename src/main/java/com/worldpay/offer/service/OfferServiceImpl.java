package com.worldpay.offer.service;

import com.worldpay.offer.constants.Constant;
import com.worldpay.offer.dao.OfferRepository;
import com.worldpay.offer.model.ApiResponse;
import com.worldpay.offer.model.Offer;
import com.worldpay.offer.model.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    static Logger logger = LoggerFactory.getLogger(OfferServiceImpl.class);

    @Autowired
    OfferRepository offerRepository;

    private ApiResponse apiResponse = null;

    @Override
    public ApiResponse getOffers() {
        logger.info("Inside the getOffers service method");
        List<Offer> offers = new ArrayList<>();
        apiResponse = new ApiResponse();
        try{
            offerRepository.findAll().forEach(offer -> offers.add(offer));
            apiResponse.setResponseCode(Constant.RES_CODE_SUCC);
            apiResponse.setLstRespObj(offers);
            apiResponse.setResponseMsg(Constant.SUCCESS_MSG);
        }catch (Exception e){
            apiResponse.setResponseCode(Constant.RES_CODE_ERROR);
            apiResponse.setResponseMsg(e.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse getOffer(long offerId) {
        logger.info("Inside the getOffer per Id service method");
        apiResponse = new ApiResponse();
        try{
            Offer offer = offerRepository.findById(offerId).get();
            if(offer != null){
                apiResponse.setRespObj(offer);
                apiResponse.setResponseCode(Constant.RES_CODE_SUCC);
                apiResponse.setResponseMsg(Constant.SUCCESS_MSG);
            }
        }catch (Exception e){
            apiResponse.setResponseCode(Constant.RES_CODE_ERROR);
            apiResponse.setResponseMsg(e.getMessage() + " on the offer list");
        }
        return apiResponse;
    }

    @Override
    public ApiResponse getOffersStatus(Status status) {
        logger.info("Inside the getOffersStatus service method");
        List<Offer> offers = new ArrayList<>();
        apiResponse = new ApiResponse();
        try{
            offerRepository.findAllByStatus(status).forEach(offer -> offers.add(offer));
            apiResponse.setResponseCode(Constant.RES_CODE_SUCC);
            apiResponse.setLstRespObj(offers);
            apiResponse.setResponseMsg(Constant.SUCCESS_MSG);
            if(offers.isEmpty()){
                apiResponse.setResponseMsg("No offers under given status: " + status);
            }else{

            }
        }catch (Exception e){
            apiResponse.setResponseCode(Constant.RES_CODE_ERROR);
            apiResponse.setResponseMsg(e.getMessage());
        }
        return apiResponse;
    }

    @Override
    public void updateStatus(Offer offer) {
        logger.info("Inside the getOffersStatus service method" + offer.getStatus());
        try{
            offerRepository.save(offer);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ApiResponse createOffer(Offer offer) {
        logger.info("Inside the createOffer service method");
        apiResponse = new ApiResponse();
        try{
            //offer.setId(0);
            offer.setCreatedDate(new Date());
            offerRepository.save(offer);
            apiResponse.setResponseCode(Constant.RES_CODE_SUCC);
            apiResponse.setResponseMsg(Constant.SUCCESS_MSG);
        }catch (Exception e){
            e.printStackTrace();
            apiResponse.setResponseCode(Constant.RES_CODE_ERROR);
            apiResponse.setResponseMsg(e.getMessage());
        }
        return apiResponse;
    }
}
