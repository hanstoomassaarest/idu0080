package DTO;

import MyCourierServiceClient.Courier;
import OfferServiceClient.TransportServiceOffer;

public class FullOffer {
    private Courier courier;
    private TransportServiceOffer offer;
    private Double rate;
    private String trackingCode;

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public TransportServiceOffer getOffer() {
        return offer;
    }

    public void setOffer(TransportServiceOffer offer) {
        this.offer = offer;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }
}
