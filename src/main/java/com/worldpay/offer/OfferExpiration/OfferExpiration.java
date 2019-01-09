package com.worldpay.offer.OfferExpiration;

import com.worldpay.offer.model.ApiResponse;
import com.worldpay.offer.model.Offer;
import com.worldpay.offer.model.Status;
import com.worldpay.offer.service.OfferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * An offer is time-bounded, with the length of time an offer is valid for
 * defined as part of the offer, and should expire automatically
 */
@Component
public class OfferExpiration {

    static Logger logger = LoggerFactory.getLogger(OfferExpiration.class);

    ApiResponse apiResponse = new ApiResponse();

    @Autowired
    OfferService offerService;

    /**
     *
     */
    @Scheduled(fixedRate = 60000)
    public void startOfferExpiration(){
        List<Offer> offerList = new ArrayList<>();
        apiResponse = new ApiResponse();
        LocalDateTime currentTime = LocalDateTime.now();

        apiResponse = offerService.getOffersStatus(Status.ACTIVE);
        apiResponse.getLstRespObj().forEach(offer -> offerList.add((Offer) offer));

        //https://stackoverflow.com/questions/21242110/convert-java-util-date-to-java-time-localdate
        for(Offer eachOffer : offerList){
            Date offerTime = eachOffer.getCreatedDate();
            LocalDateTime offerreatedTime = LocalDateTime.ofInstant(offerTime.toInstant(), ZoneId.systemDefault());
            if(eachOffer.getExpiryTimeMin() >= Duration.between(currentTime,offerreatedTime).toMinutes()){
                logger.info("Offer with offer Id: " + eachOffer.getId()+ ", is expired!");
                eachOffer.setStatus(Status.EXPIRED);
                offerService.updateStatus(eachOffer);
            }
        }
    }
}
