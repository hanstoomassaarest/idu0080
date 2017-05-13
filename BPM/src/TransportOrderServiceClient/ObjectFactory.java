
package TransportOrderServiceClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the TransportOrderServiceClient package.
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

    private final static QName _OrderTransportResponse_QNAME = new QName("http://TransportOrderService/", "orderTransportResponse");
    private final static QName _OrderTransport_QNAME = new QName("http://TransportOrderService/", "orderTransport");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: TransportOrderServiceClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OrderTransport }
     * 
     */
    public OrderTransport createOrderTransport() {
        return new OrderTransport();
    }

    /**
     * Create an instance of {@link OrderTransportResponse }
     * 
     */
    public OrderTransportResponse createOrderTransportResponse() {
        return new OrderTransportResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderTransportResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TransportOrderService/", name = "orderTransportResponse")
    public JAXBElement<OrderTransportResponse> createOrderTransportResponse(OrderTransportResponse value) {
        return new JAXBElement<OrderTransportResponse>(_OrderTransportResponse_QNAME, OrderTransportResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderTransport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TransportOrderService/", name = "orderTransport")
    public JAXBElement<OrderTransport> createOrderTransport(OrderTransport value) {
        return new JAXBElement<OrderTransport>(_OrderTransport_QNAME, OrderTransport.class, null, value);
    }

}
