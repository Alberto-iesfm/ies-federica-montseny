package org.iesfm.Company;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Order {
    private int number;
    private LocalDateTime date;
    private List<Item> items;

    public Order(int number, LocalDateTime date, List<Item> items) {
        this.number = number;
        this.date = date;
        this.items = items;
    }

    public double getPrice(){
        double price = 0;
        for (Item item:items){
            price += item.getTotalPrice();
        }
        return price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return number == order.number && Objects.equals(date, order.date) && Objects.equals(items, order.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, date, items);
    }

    @Override
    public String toString() {
        return "Order{" +
                "number=" + number +
                ", date=" + date +
                ", items=" + items +
                '}';
    }
}
