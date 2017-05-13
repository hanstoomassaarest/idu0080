
package CourierServiceClient;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CourierServiceImpl", targetNamespace = "http://CourierService/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CourierServiceImpl {


    /**
     * 
     * @param arg0
     * @return
     *     returns CourierServiceClient.Courier
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getById", targetNamespace = "http://CourierService/", className = "CourierServiceClient.GetById")
    @ResponseWrapper(localName = "getByIdResponse", targetNamespace = "http://CourierService/", className = "CourierServiceClient.GetByIdResponse")
    @Action(input = "http://CourierService/CourierServiceImpl/getByIdRequest", output = "http://CourierService/CourierServiceImpl/getByIdResponse")
    public Courier getById(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @return
     *     returns java.util.List<CourierServiceClient.Courier>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllCouriers", targetNamespace = "http://CourierService/", className = "CourierServiceClient.GetAllCouriers")
    @ResponseWrapper(localName = "getAllCouriersResponse", targetNamespace = "http://CourierService/", className = "CourierServiceClient.GetAllCouriersResponse")
    @Action(input = "http://CourierService/CourierServiceImpl/getAllCouriersRequest", output = "http://CourierService/CourierServiceImpl/getAllCouriersResponse")
    public List<Courier> getAllCouriers();

}