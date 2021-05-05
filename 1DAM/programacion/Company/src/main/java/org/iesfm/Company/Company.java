package org.iesfm.Company;

import org.iesfm.Company.exceptions.CustomerNotFoundException;
import org.iesfm.Company.exceptions.OrderNotFoundException;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Company implements ICompany{
    private String name;
    private String cif;
    private Map<String, Customer> customers;

    public Company(String name, String cif, Map<String, Customer> customers) {
        this.name = name;
        this.cif = cif;
        this.customers = customers;
    }

    @Override
    public Set<Order> getCustomerOrders(String customerId) throws CustomerNotFoundException {
        if (!customers.containsKey(customerId)){
            throw new CustomerNotFoundException();
        }
        return customers.get(customerId).getOrders();
    }

    @Override
    public Set<Item> getCustomerItems(String customerId) throws CustomerNotFoundException {
        Set<Item> customerItems = new HashSet<>();
        for (Order order:getCustomerOrders(customerId)){
            customerItems.addAll(order.getItems());
        }
        return customerItems;
    }

    @Override
    public double getOrderPrice(String customerId, int orderNumber) throws CustomerNotFoundException, OrderNotFoundException {
        Order searchedOrder = null;
        for (Order order:getCustomerOrders(customerId)){
            if (order.getNumber() == orderNumber){
                searchedOrder = order;
            }
        }
        if (searchedOrder == null){
            throw new OrderNotFoundException();
        }
        return searchedOrder.getPrice();
    }

    @Override
    public double getCustomerSpending(String customerId) throws CustomerNotFoundException {
        double spending = 0;
        for (Order order:getCustomerOrders(customerId)){
            spending += order.getPrice();
        }
        return spending;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Map<String, Customer> customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) && Objects.equals(cif, company.cif) && Objects.equals(customers, company.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cif, customers);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", cif='" + cif + '\'' +
                ", customers=" + customers +
                '}';
    }
}
