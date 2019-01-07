package com.worldpay.offer.service;

import com.worldpay.offer.model.ApiResponse;
import com.worldpay.offer.model.Offer;
import com.worldpay.offer.model.Status;

public interface OfferService {

    ApiResponse getOffers();
    ApiResponse getOffer(long offerId);
    ApiResponse getOffersStatus(Status status);
    void updateStatus(Offer offer);
    ApiResponse createOffer(Offer offer);

}
