package org.iesfm.Company;

import org.iesfm.Company.exceptions.CustomerNotFoundException;
import org.iesfm.Company.exceptions.OrderNotFoundException;

import java.util.Set;

public interface ICompany {
    Set<Order> getCustomerOrders (String customerId) throws CustomerNotFoundException;

    Set<Item> getCustomerItems (String customerId) throws CustomerNotFoundException;

    double getOrderPrice (String customerId, int orderNumber) throws CustomerNotFoundException, OrderNotFoundException;

    double getCustomerSpending (String customerId) throws CustomerNotFoundException;
}
