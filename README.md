# RESTFull_API_Java_Service
Based on Java 8 with Spring RestController Framework. REST API call with inbuilt memory of H2.

# Background
Per Wikipedia, "an offer is a proposal to sell a specific product orservice under specific conditions". As a merchant I offer goods for
sale. I want to create an offer so that I can share it with my customers.

All my offers have shopper friendly descriptions. I price all my offers up front in a defined currency.
An offer is time-bounded, with the length of time an offer is valid for defined as part of the offer, and should expire automatically. 

Offers may also be explicitly cancelled before they expire. 

# Assignment
You are required to create a simple RESTful software service that will allow a merchant to create a new simple offer. 
Offers, once created, may be queried. 
After the period of time defined on the offer it should expire and further requests to query the offer should reflect that somehow. 
Before an offer has expired users may cancel it. 

# Use of technologies:
1. IntelliJ IDEA
2. Java 8
3. Spring RestController framework
4. ORM Hibernate with JPA specification
5. Inbuild in memory DB using H2
