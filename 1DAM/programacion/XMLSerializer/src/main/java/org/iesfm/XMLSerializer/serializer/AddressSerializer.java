package org.iesfm.XMLSerializer.serializer;

import org.iesfm.XMLSerializer.Address;

public class AddressSerializer implements XMLSerializer<Address> {
    @Override
    public String toXml(Address address) {
        String street = "<street>" + address.getStreet() + "</street>";
        String number = "<number>" + address.getNumber() + "</number>";
        String door = "<door>" + address.getDoor() + "</door>";
        String city = "<city>" + address.getCity() + "</city>";
        return "<Address>" + street + number + door + city + "</Address>";
    }
}
