package com.worldpay.offer.controller;

import com.worldpay.offer.constants.Constant;
import com.worldpay.offer.model.ApiResponse;
import com.worldpay.offer.service.OfferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/offers")
public class OfferController {

    static Logger logger = LoggerFactory.getLogger(OfferController.class);

    @Autowired
    OfferService offerService;

    private ApiResponse apiResponse = null;

    /**
     * Return all the offers stored in database
     * @return ApiRespone Object
     */
    @GetMapping("/getOffers")
    public ApiResponse getOffersList(){
        logger.info("Inside the Get Offers method");
        apiResponse = new ApiResponse();

        try{
            apiResponse = offerService.getOffers();
            apiResponse.setResponseCode(Constant.RES_CODE_SUCC);
            apiResponse.setResponseMsg(Constant.SUCCESS_MSG);
            apiResponse.setLstRespObj(apiResponse.getLstRespObj());
        }catch (Exception e){
            apiResponse.setResponseCode(Constant.RES_CODE_ERROR);
            apiResponse.setResponseMsg(Constant.ERROR_MSG+e.getMessage());
        }
        //System.out.println("------"+apiResponse.getLstRespObj().get(0).toString());
        return apiResponse;
    }

}
