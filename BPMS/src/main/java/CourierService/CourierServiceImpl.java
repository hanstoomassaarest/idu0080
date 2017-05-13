package CourierService;

import Common.Address;
import Common.Town;
import CourierService.DTO.Courier;
import Common.AddressGenerator;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebService(endpointInterface = "CourierService.CourierServiceImpl",
        portName = "CourierServicePort",
        serviceName = "CourierService")
public class CourierServiceImpl extends AddressGenerator implements CourierService {
    private static Logger logger = Logger.getLogger("CourierServiceLogger");
    private List<Courier> couriers;

    public CourierServiceImpl() {
        Address tallinn = getAddressByTown(Town.TALLINN);
        Address tartu = getAddressByTown(Town.TARTU);
        Address parnu = getAddressByTown(Town.PARNU);
        Address haapsalu = getAddressByTown(Town.HAAPSALU);
        couriers = new ArrayList<Courier>();
        couriers.add(generateCourier(1, "DHL", getAddressesAsList(tallinn, tartu), 5));
        couriers.add(generateCourier(2, "SmartPost", getAddressesAsList(tartu, parnu), 15));
        couriers.add(generateCourier(3, "Omniva", getAddressesAsList(parnu, haapsalu), 25));
        couriers.add(generateCourier(4, "Post24", getAddressesAsList(haapsalu, tallinn), 30));
    }

    private Courier generateCourier(int id, String name, List<Address> addresses, int percentFromOrder) {
        Courier courier = new Courier();
        courier.setId(id);
        courier.setName(name);
        courier.setAddresses(addresses);
        courier.setPercentFromOrder(percentFromOrder);
        return courier;
    }

    public Courier getById(int id) {
        logger.info("CourierService: getById: " + id);
        for (Courier courier : this.couriers) {
            if (courier.getId() == id) {
                return courier;
            }
        }
        return null;
    }

    public List<Courier> getAllCouriers() {
        logger.info("CourierService: getAll");
        return this.couriers;
    }

}
