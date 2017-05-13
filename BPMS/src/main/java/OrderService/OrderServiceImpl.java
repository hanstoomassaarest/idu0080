package OrderService;

import Common.Address;
import Common.AddressGenerator;
import Common.Town;
import OrderService.DTO.Order;
import OrderService.DTO.Seller;

import javax.jws.WebService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebService(endpointInterface = "OrderService.OrderServiceImpl",
        portName = "OrderServicePort",
        serviceName = "OrderService")
public class OrderServiceImpl extends AddressGenerator implements OrderService {

    public Order getOrderById(int id) {
        Seller seller = new Seller();
        seller.setAddresses(getSelleAddresses(id));
        Order order = new Order();
        order.setOrderId(id);
        Random random = new Random();
        order.setOrderCost(BigDecimal.valueOf(1000 * random.nextDouble()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        order.setDeliveryAddress(getAddressByOrderId(id));
        order.setSeller(seller);
        return order;
    }

    private Address getAddressByOrderId(int id) {
        switch (id) {
            case 1:
                return getAddressByTown(Town.TALLINN);
            case 2:
                return getAddressByTown(Town.TARTU);
            case 3:
                return getAddressByTown(Town.PARNU);
            case 4:
                return getAddressByTown(Town.HAAPSALU);
            default:
                return null;
        }
    }

    /**
     * Sellers will be in different towns and not in same town where order was placed
     */
    private List<Address> getSelleAddresses(int orderId) {
        List<Address> addresses = new ArrayList<Address>();
        Random random = new Random();
        int numberInList = 0;
        do {
            int randomNumber = random.nextInt(4) + 1;
            if (randomNumber == orderId || randomNumber == numberInList) {
                continue;
            }
            numberInList = randomNumber;
            addresses.add(getAddressByOrderId(randomNumber));
        } while (addresses.size() < 2);
        return addresses;
    }

}