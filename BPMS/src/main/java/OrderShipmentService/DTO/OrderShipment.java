package OrderShipmentService.DTO;


public class OrderShipment {

    private int orderId;
    private String ryhmaName;
    private String trackingNumber;
    private String courierName;
    private int approximateDeliveryTime;
    private double transportPrice;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getRyhmaName() {
        return ryhmaName;
    }

    public void setRyhmaName(String ryhmaName) {
        this.ryhmaName = ryhmaName;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public int getApproximateDeliveryTime() {
        return approximateDeliveryTime;
    }

    public void setApproximateDeliveryTime(int approximateDeliveryTime) {
        this.approximateDeliveryTime = approximateDeliveryTime;
    }

    public double getTransportPrice() {
        return transportPrice;
    }

    public void setTransportPrice(double transportPrice) {
        this.transportPrice = transportPrice;
    }
}
