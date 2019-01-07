package com.worldpay.offer.controller;

import com.worldpay.offer.model.ApiResponse;
import com.worldpay.offer.model.Offer;
import com.worldpay.offer.model.Status;
import com.worldpay.offer.service.OfferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public ApiResponse getOffersList(){
        logger.info("Inside the Get Offers method");
        apiResponse = new ApiResponse();

        apiResponse = offerService.getOffers();

        if(apiResponse.getResponseCode() != 200){
            logger.error("Error on the service: " + apiResponse.getResponseMsg());
        }else{
            logger.info("Success on completing the getOffers call");
        }

        /*try{
            apiResponse = offerService.getOffers();
            apiResponse.setResponseCode(Constant.RES_CODE_SUCC);
            apiResponse.setResponseMsg(Constant.SUCCESS_MSG);
            //apiResponse.setLstRespObj(apiResponse.getLstRespObj());
        }catch (Exception e){
            apiResponse.setResponseCode(Constant.RES_CODE_ERROR);
            apiResponse.setResponseMsg(Constant.ERROR_MSG+e.getMessage());
        }*/
        return apiResponse;
    }

    @GetMapping("/{offerId}")
    public ApiResponse getOffer(@PathVariable long offerId){
        logger.info("Inside the Get offer per id method");
        apiResponse = new ApiResponse();

        apiResponse = offerService.getOffer(offerId);

        if(apiResponse.getResponseCode() != 200){
            logger.error("Error on the Service: " + apiResponse.getResponseMsg());
        }else{
            logger.info("Success on completing the getOffers call");
        }
        return apiResponse;
    }

    @GetMapping("/status")  ///api/offers/status?id=ACTIVE
    public ApiResponse getStatusOffers(@RequestParam("id") Status status){
        logger.info("Inside the Get Status offer/s method");
        apiResponse = new ApiResponse();
        apiResponse = offerService.getOffersStatus(status);

        if(apiResponse.getResponseCode() != 200){
            logger.error("Error on the service: " + apiResponse.getResponseMsg());
        }else{
            logger.info("Success on completing the getStatusOffers call");
        }
        return apiResponse;
    }

    @PostMapping("/{offerId}/status")  ///api/offers/2/status?id=EXPIRED
    public void updateStatus(@PathVariable long offerId, @RequestParam("id") Status status){
        logger.info("Inside the Update status per offer id method");
        apiResponse = new ApiResponse();

        apiResponse = offerService.getOffer(offerId);

        if(apiResponse.getResponseCode() != 200){
            logger.error("Error on the Service: " + apiResponse.getResponseMsg());
        }else{
            Offer offer = (Offer) apiResponse.getRespObj();
            offer.setStatus(status);
            offerService.updateStatus(offer);
            logger.info("Success on completing the getOffers call");
        }
    }

    @PostMapping("/createOffer")
    public ApiResponse createOffer(@RequestBody Offer offer){
        logger.info("Inside the create offer method");
        apiResponse = new ApiResponse();

        apiResponse = offerService.createOffer(offer);

        if(apiResponse.getResponseCode() != 200){
            logger.error("Error on the service: " + apiResponse.getResponseMsg());
        }else{
            logger.info("Success on completing the createOffer call");
        }
        return apiResponse;
    }

}
