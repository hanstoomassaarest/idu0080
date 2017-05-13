package MyCourierService;

import CourierServiceClient.Courier;

import javax.jws.WebService;
import java.net.MalformedURLException;
import java.util.List;


@WebService
public interface MyCourierService {
    public List<Courier> getCouriers() throws MalformedURLException;
}
