package OrderService;

import OrderService.DTO.Order;

import javax.jws.WebService;

@WebService
public interface OrderService {
    Order getOrderById(int id);
}
