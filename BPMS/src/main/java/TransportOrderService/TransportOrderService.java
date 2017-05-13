package TransportOrderService;


import javax.jws.WebService;

@WebService
public interface TransportOrderService {
    String orderTransport(String offerId);
}
