
package MyCourierServiceClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the MyCourierServiceClient package.
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

    private final static QName _MalformedURLException_QNAME = new QName("http://MyCourierService/", "MalformedURLException");
    private final static QName _GetCouriersResponse_QNAME = new QName("http://MyCourierService/", "getCouriersResponse");
    private final static QName _GetCouriers_QNAME = new QName("http://MyCourierService/", "getCouriers");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: MyCourierServiceClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MalformedURLException }
     * 
     */
    public MalformedURLException createMalformedURLException() {
        return new MalformedURLException();
    }

    /**
     * Create an instance of {@link GetCouriersResponse }
     * 
     */
    public GetCouriersResponse createGetCouriersResponse() {
        return new GetCouriersResponse();
    }

    /**
     * Create an instance of {@link GetCouriers }
     * 
     */
    public GetCouriers createGetCouriers() {
        return new GetCouriers();
    }

    /**
     * Create an instance of {@link Courier }
     * 
     */
    public Courier createCourier() {
        return new Courier();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MalformedURLException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://MyCourierService/", name = "MalformedURLException")
    public JAXBElement<MalformedURLException> createMalformedURLException(MalformedURLException value) {
        return new JAXBElement<MalformedURLException>(_MalformedURLException_QNAME, MalformedURLException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCouriersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://MyCourierService/", name = "getCouriersResponse")
    public JAXBElement<GetCouriersResponse> createGetCouriersResponse(GetCouriersResponse value) {
        return new JAXBElement<GetCouriersResponse>(_GetCouriersResponse_QNAME, GetCouriersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCouriers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://MyCourierService/", name = "getCouriers")
    public JAXBElement<GetCouriers> createGetCouriers(GetCouriers value) {
        return new JAXBElement<GetCouriers>(_GetCouriers_QNAME, GetCouriers.class, null, value);
    }

}
