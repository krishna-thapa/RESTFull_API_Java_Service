package com.worldpay.offer.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "offer")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "merchant_id")
    private long merchandId;

    @Column(name = "description")
    private String description;

    @Column(name = "currency")
    private String currency;

    @Column(name = "price", precision=5, scale=2)
    private BigDecimal price;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "expiry_time")
    private long expiryTimeMin;

    @Column(name = "status")
    private Status status;

    public Offer(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMerchandId() {
        return merchandId;
    }

    public void setMerchandId(long merchandId) {
        this.merchandId = merchandId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public long getExpiryTimeMin() {
        return expiryTimeMin;
    }

    public void setExpiryTimeMin(long expiryTimeMin) {
        this.expiryTimeMin = expiryTimeMin;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}


/*

INSERT INTO OFFER (ID,CREATED_DATE,DESCRIPTION,EXPIRY_TIME,MERCHANT_ID,PRICE)
VALUES (1, '2019-01-04 00:00:00.00', 'First class', '2019-01-04 20:00:00.00',1,24.53)

Select * from OFFER

 */