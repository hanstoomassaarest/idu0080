package CourierService.DTO;


import Common.Address;

import java.util.List;

public class Courier {
    private int id;
    private String name;
    private List<Address> addresses;
    private double percentFromOrder;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public double getPercentFromOrder() {
        return percentFromOrder;
    }

    public void setPercentFromOrder(double percentFromOrder) {
        this.percentFromOrder = percentFromOrder;
    }
}
