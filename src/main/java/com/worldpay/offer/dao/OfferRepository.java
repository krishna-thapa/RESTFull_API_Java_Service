package com.worldpay.offer.dao;

import com.worldpay.offer.model.Offer;
import com.worldpay.offer.model.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfferRepository extends CrudRepository<Offer, Long> {

    List<Offer> findAllByStatus(Status status);
}
