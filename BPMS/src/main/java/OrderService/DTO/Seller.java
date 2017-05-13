package OrderService.DTO;

import Common.Address;

import java.util.List;

public class Seller {
    private List<Address> addresses;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
