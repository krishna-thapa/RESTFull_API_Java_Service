package com.worldpay.offer.dao;

import com.worldpay.offer.model.Offer;
import org.springframework.data.repository.CrudRepository;

public interface OfferRepository extends CrudRepository<Offer, Long> {

}
