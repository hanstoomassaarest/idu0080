package Common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class AddressGenerator {

    private HashMap<Town, Address> addresses = new HashMap<Town, Address>();

    public AddressGenerator() {
        addresses.put(Town.TALLINN, generateAddress(1, "Estonia", "Harjumaa", "Tallinn", "Ehitajate tee", "5", "2"));
        addresses.put(Town.TARTU, generateAddress(2, "Estonia", "Tartumaa", "Tartu", "Riia mnt", "10", "1"));
        addresses.put(Town.PARNU, generateAddress(3, "Estonia", "Pärnumaa", "Pärnu", "Rüütli", "3", "3"));
        addresses.put(Town.HAAPSALU, generateAddress(4, "Estonia", "Läänemaa", "Haapsalu", "Vallikraavi", "7", "4"));
    }

    private Address generateAddress(int id, String country, String county, String town, String street, String house, String department) {
        Address address = new Address();
        address.setAddressId(id);
        address.setCountry(country);
        address.setCounty(county);
        address.setTown(town);
        address.setStreet(street);
        address.setHouseNumber(house);
        address.setDepartmentNumber(department);
        return address;
    }

    protected List<Address> getAddressesAsList(Address address1, Address address2) {
        List<Address> addresses = new ArrayList<Address>();
        addresses.add(address1);
        addresses.add(address2);
        return addresses;
    }

    protected Address getAddressByTown(Town town) {
        return addresses.get(town);
    }
}
