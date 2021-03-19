package org.iesfm.discos;

import java.util.Date;
import java.util.Objects;

public class Order {
    private double price;
    private Date date;

    public Order(double price, Date date) {
        this.price = price;
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.price, price) == 0 && Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, date);
    }

    @Override
    public String toString() {
        return "Order{" +
                "price=" + price +
                ", date=" + date +
                '}';
    }
}
