
package OrderShipmentServiceClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the OrderShipmentServiceClient package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InsertOrderShipment_QNAME = new QName("http://OrderShipmentService/", "insertOrderShipment");
    private final static QName _InsertOrderShipmentResponse_QNAME = new QName("http://OrderShipmentService/", "insertOrderShipmentResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: OrderShipmentServiceClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertOrderShipment }
     * 
     */
    public InsertOrderShipment createInsertOrderShipment() {
        return new InsertOrderShipment();
    }

    /**
     * Create an instance of {@link InsertOrderShipmentResponse }
     * 
     */
    public InsertOrderShipmentResponse createInsertOrderShipmentResponse() {
        return new InsertOrderShipmentResponse();
    }

    /**
     * Create an instance of {@link OrderShipment }
     * 
     */
    public OrderShipment createOrderShipment() {
        return new OrderShipment();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertOrderShipment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://OrderShipmentService/", name = "insertOrderShipment")
    public JAXBElement<InsertOrderShipment> createInsertOrderShipment(InsertOrderShipment value) {
        return new JAXBElement<InsertOrderShipment>(_InsertOrderShipment_QNAME, InsertOrderShipment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertOrderShipmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://OrderShipmentService/", name = "insertOrderShipmentResponse")
    public JAXBElement<InsertOrderShipmentResponse> createInsertOrderShipmentResponse(InsertOrderShipmentResponse value) {
        return new JAXBElement<InsertOrderShipmentResponse>(_InsertOrderShipmentResponse_QNAME, InsertOrderShipmentResponse.class, null, value);
    }

}
