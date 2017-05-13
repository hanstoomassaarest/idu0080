
package CourierServiceClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the CourierServiceClient package.
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

    private final static QName _GetAllCouriers_QNAME = new QName("http://CourierService/", "getAllCouriers");
    private final static QName _GetByIdResponse_QNAME = new QName("http://CourierService/", "getByIdResponse");
    private final static QName _GetById_QNAME = new QName("http://CourierService/", "getById");
    private final static QName _GetAllCouriersResponse_QNAME = new QName("http://CourierService/", "getAllCouriersResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: CourierServiceClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetByIdResponse }
     * 
     */
    public GetByIdResponse createGetByIdResponse() {
        return new GetByIdResponse();
    }

    /**
     * Create an instance of {@link GetById }
     * 
     */
    public GetById createGetById() {
        return new GetById();
    }

    /**
     * Create an instance of {@link GetAllCouriersResponse }
     * 
     */
    public GetAllCouriersResponse createGetAllCouriersResponse() {
        return new GetAllCouriersResponse();
    }

    /**
     * Create an instance of {@link GetAllCouriers }
     * 
     */
    public GetAllCouriers createGetAllCouriers() {
        return new GetAllCouriers();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link Courier }
     * 
     */
    public Courier createCourier() {
        return new Courier();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCouriers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://CourierService/", name = "getAllCouriers")
    public JAXBElement<GetAllCouriers> createGetAllCouriers(GetAllCouriers value) {
        return new JAXBElement<GetAllCouriers>(_GetAllCouriers_QNAME, GetAllCouriers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://CourierService/", name = "getByIdResponse")
    public JAXBElement<GetByIdResponse> createGetByIdResponse(GetByIdResponse value) {
        return new JAXBElement<GetByIdResponse>(_GetByIdResponse_QNAME, GetByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://CourierService/", name = "getById")
    public JAXBElement<GetById> createGetById(GetById value) {
        return new JAXBElement<GetById>(_GetById_QNAME, GetById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCouriersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://CourierService/", name = "getAllCouriersResponse")
    public JAXBElement<GetAllCouriersResponse> createGetAllCouriersResponse(GetAllCouriersResponse value) {
        return new JAXBElement<GetAllCouriersResponse>(_GetAllCouriersResponse_QNAME, GetAllCouriersResponse.class, null, value);
    }

}
