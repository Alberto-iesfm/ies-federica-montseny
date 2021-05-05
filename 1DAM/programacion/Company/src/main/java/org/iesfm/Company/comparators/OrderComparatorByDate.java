package org.iesfm.Company.comparators;

import org.iesfm.Company.Order;

import java.util.Comparator;

public class OrderComparatorByDate implements Comparator<Order> {
    @Override
    public int compare(Order order1, Order order2) {
        return -(order1.getDate().compareTo(order2.getDate()));
    }
}
