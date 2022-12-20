package guru.sfg.beer.order.service.services;

import guru.sfg.beer.order.service.domain.BeerOrder;

import java.util.UUID;

public interface BeerOrderManager {

    BeerOrder newBeerOrder(BeerOrder beerOrder);

    void processValidationResult(UUID beerOrderId, Boolean isValid);
}

https://www.udemy.com/course/spring-boot-microservices-with-spring-cloud-beginner-to-guru/learn/practice/1152368/instructor-solution#overview