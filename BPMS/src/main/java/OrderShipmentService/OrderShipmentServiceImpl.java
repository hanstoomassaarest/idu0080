package OrderShipmentService;


import OrderShipmentService.DTO.OrderShipment;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "OrderShipmentService.OrderShipmentServiceImpl",
        portName = "OrderShipmentServicePort",
        serviceName = "OrderShipmentService")
public class OrderShipmentServiceImpl {

    private List<OrderShipment> orderShipmentList;

    public OrderShipmentServiceImpl() {
        this.orderShipmentList = new ArrayList<OrderShipment>();
    }

    public List<OrderShipment> insertOrderShipment(OrderShipment orderShipment){
            orderShipmentList.add(orderShipment);
        return orderShipmentList;
    }
}
