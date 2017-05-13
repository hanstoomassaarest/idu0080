package MyCourierService;

import CourierServiceClient.Courier;
import CourierServiceClient.CourierService;

import javax.jws.WebService;
import java.net.MalformedURLException;
import java.util.List;
@WebService(endpointInterface = "MyCourierService.MyCourierServiceImpl",
        portName = "MyCourierServicePort",
        serviceName = "MyCourierService")
public class MyCourierServiceImpl implements MyCourierService {
    public List<Courier> getCouriers() throws MalformedURLException {
        CourierService courierService = new CourierService();
        return courierService.getCourierServicePort().getAllCouriers();
    }
}
