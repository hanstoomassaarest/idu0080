package OfferService.DTO;

import java.util.Date;

public class TransportServiceOffer {

    private String offerId;
    private double price;
    private int approximateDeliveryTime;

    public String getOfferId() {
        return offerId;
    }

    public TransportServiceOffer setOfferId(String offerId) {
        this.offerId = offerId;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public TransportServiceOffer setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getApproximateDeliveryTime() {
        return approximateDeliveryTime;
    }

    public TransportServiceOffer setApproximateDeliveryTime(int approximateDeliveryTime) {
        this.approximateDeliveryTime = approximateDeliveryTime;
        return this;
    }
}
