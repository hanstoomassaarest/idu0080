package OfferService;

import OfferService.DTO.Order;
import OfferService.DTO.TransportServiceOffer;

import javax.jws.WebService;

@WebService
public interface OfferService {
   TransportServiceOffer getOffer(int courierId,Order order);
}
