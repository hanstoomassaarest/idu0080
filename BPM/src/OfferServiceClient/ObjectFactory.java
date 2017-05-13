
package OfferServiceClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the OfferServiceClient package.
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

    private final static QName _CalculatePrice_QNAME = new QName("http://OfferService/", "calculatePrice");
    private final static QName _CalculatePriceResponse_QNAME = new QName("http://OfferService/", "calculatePriceResponse");
    private final static QName _GenerateOfferId_QNAME = new QName("http://OfferService/", "generateOfferId");
    private final static QName _GenerateOfferIdResponse_QNAME = new QName("http://OfferService/", "generateOfferIdResponse");
    private final static QName _GetOfferResponse_QNAME = new QName("http://OfferService/", "getOfferResponse");
    private final static QName _GetOffer_QNAME = new QName("http://OfferService/", "getOffer");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: OfferServiceClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CalculatePrice }
     * 
     */
    public CalculatePrice createCalculatePrice() {
        return new CalculatePrice();
    }

    /**
     * Create an instance of {@link CalculatePriceResponse }
     * 
     */
    public CalculatePriceResponse createCalculatePriceResponse() {
        return new CalculatePriceResponse();
    }

    /**
     * Create an instance of {@link GenerateOfferId }
     * 
     */
    public GenerateOfferId createGenerateOfferId() {
        return new GenerateOfferId();
    }

    /**
     * Create an instance of {@link GenerateOfferIdResponse }
     * 
     */
    public GenerateOfferIdResponse createGenerateOfferIdResponse() {
        return new GenerateOfferIdResponse();
    }

    /**
     * Create an instance of {@link GetOfferResponse }
     * 
     */
    public GetOfferResponse createGetOfferResponse() {
        return new GetOfferResponse();
    }

    /**
     * Create an instance of {@link GetOffer }
     * 
     */
    public GetOffer createGetOffer() {
        return new GetOffer();
    }

    /**
     * Create an instance of {@link Seller }
     * 
     */
    public Seller createSeller() {
        return new Seller();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link TransportServiceOffer }
     * 
     */
    public TransportServiceOffer createTransportServiceOffer() {
        return new TransportServiceOffer();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculatePrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://OfferService/", name = "calculatePrice")
    public JAXBElement<CalculatePrice> createCalculatePrice(CalculatePrice value) {
        return new JAXBElement<CalculatePrice>(_CalculatePrice_QNAME, CalculatePrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculatePriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://OfferService/", name = "calculatePriceResponse")
    public JAXBElement<CalculatePriceResponse> createCalculatePriceResponse(CalculatePriceResponse value) {
        return new JAXBElement<CalculatePriceResponse>(_CalculatePriceResponse_QNAME, CalculatePriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateOfferId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://OfferService/", name = "generateOfferId")
    public JAXBElement<GenerateOfferId> createGenerateOfferId(GenerateOfferId value) {
        return new JAXBElement<GenerateOfferId>(_GenerateOfferId_QNAME, GenerateOfferId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateOfferIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://OfferService/", name = "generateOfferIdResponse")
    public JAXBElement<GenerateOfferIdResponse> createGenerateOfferIdResponse(GenerateOfferIdResponse value) {
        return new JAXBElement<GenerateOfferIdResponse>(_GenerateOfferIdResponse_QNAME, GenerateOfferIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOfferResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://OfferService/", name = "getOfferResponse")
    public JAXBElement<GetOfferResponse> createGetOfferResponse(GetOfferResponse value) {
        return new JAXBElement<GetOfferResponse>(_GetOfferResponse_QNAME, GetOfferResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOffer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://OfferService/", name = "getOffer")
    public JAXBElement<GetOffer> createGetOffer(GetOffer value) {
        return new JAXBElement<GetOffer>(_GetOffer_QNAME, GetOffer.class, null, value);
    }

}
