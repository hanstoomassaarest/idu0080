package CourierService;

import CourierService.DTO.Courier;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface CourierService {
    Courier getById(int id);

    List<Courier> getAllCouriers();
}
