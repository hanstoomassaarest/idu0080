package OfferService;

import Common.Address;
import CourierServiceClient.Courier;
import CourierServiceClient.CourierService;
import OfferService.DTO.Order;
import OfferService.DTO.TransportServiceOffer;

import javax.jws.WebService;

@WebService(endpointInterface = "OfferService.OfferServiceImpl",
        portName = "OfferServicePort",
        serviceName = "OfferService")
public class OfferServiceImpl implements OfferService {

    public TransportServiceOffer getOffer(int courierId, Order order) {
        CourierService courierService = new CourierService();
        Courier courier = courierService.getCourierServicePort().getById(courierId);

        TransportServiceOffer offer = new TransportServiceOffer();
        offer.setOfferId(generateOfferId());
        offer.setPrice(this.calculatePrice(courier,order));
        offer.setApproximateDeliveryTime(randInt(1,7));
        return offer;
    }

    public double calculatePrice(Courier courier,Order order){
        float discount = 0;
        for(CourierServiceClient.Address address : courier.getAddresses()) {
            if(order.getDeliveryAddress().getCounty().equalsIgnoreCase(address.getCounty())) {
                discount += 30;
                break;
            }
        }
        for(CourierServiceClient.Address address : courier.getAddresses()) {
            for (Address sellerAddr : order.getSeller().getAddresses()) {
                if(sellerAddr.getCounty().equalsIgnoreCase(address.getCounty())) {
                    discount += 30;
                    break;
                }
            }
        }
        return (courier.getPercentFromOrder()*order.getOrderCost())/100*(100-discount)/100;
    }
    private static int randInt(int min, int max) {
        java.util.Random rand = new java.util.Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public String generateOfferId() {
        String id = "";
        java.util.Random r = new java.util.Random();
        java.util.Random randomBoolean = new java.util.Random();
        // 'a'=97, 'z'=122
        for(int i = 0; i < 11; i ++ ) {
            boolean b = randomBoolean.nextBoolean();
            if(b) {
                int j = 97 + r.nextInt(122-97);
                id += (char) j +"";
            } else {
                int j = randInt(1,9);
                id += j + "";
            }
        }
        return id.toUpperCase();
    }

}
