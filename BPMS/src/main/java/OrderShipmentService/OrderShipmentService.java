package OrderShipmentService;


import OrderShipmentService.DTO.OrderShipment;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface OrderShipmentService {

    List<OrderShipment> insertOrderShipment(OrderShipment orderShipment);
}
