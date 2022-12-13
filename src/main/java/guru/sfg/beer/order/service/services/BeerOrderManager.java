package guru.sfg.beer.order.service.services;

import guru.sfg.beer.order.service.sm.domain.BeerOrder;

public interface BeerOrderManager {

    BeerOrder newBeerOrder(BeerOrder beerOrder);
}
