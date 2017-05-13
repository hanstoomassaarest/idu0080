
package OrderShipmentServiceClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for orderShipment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="orderShipment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="approximateDeliveryTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="courierName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ryhmaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trackingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transportPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderShipment", propOrder = {
    "approximateDeliveryTime",
    "courierName",
    "orderId",
    "ryhmaName",
    "trackingNumber",
    "transportPrice"
})
public class OrderShipment {

    protected int approximateDeliveryTime;
    protected String courierName;
    protected int orderId;
    protected String ryhmaName;
    protected String trackingNumber;
    protected double transportPrice;

    /**
     * Gets the value of the approximateDeliveryTime property.
     * 
     */
    public int getApproximateDeliveryTime() {
        return approximateDeliveryTime;
    }

    /**
     * Sets the value of the approximateDeliveryTime property.
     * 
     */
    public void setApproximateDeliveryTime(int value) {
        this.approximateDeliveryTime = value;
    }

    /**
     * Gets the value of the courierName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCourierName() {
        return courierName;
    }

    /**
     * Sets the value of the courierName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCourierName(String value) {
        this.courierName = value;
    }

    /**
     * Gets the value of the orderId property.
     * 
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets the value of the orderId property.
     * 
     */
    public void setOrderId(int value) {
        this.orderId = value;
    }

    /**
     * Gets the value of the ryhmaName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRyhmaName() {
        return ryhmaName;
    }

    /**
     * Sets the value of the ryhmaName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRyhmaName(String value) {
        this.ryhmaName = value;
    }

    /**
     * Gets the value of the trackingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackingNumber() {
        return trackingNumber;
    }

    /**
     * Sets the value of the trackingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackingNumber(String value) {
        this.trackingNumber = value;
    }

    /**
     * Gets the value of the transportPrice property.
     * 
     */
    public double getTransportPrice() {
        return transportPrice;
    }

    /**
     * Sets the value of the transportPrice property.
     * 
     */
    public void setTransportPrice(double value) {
        this.transportPrice = value;
    }

}
