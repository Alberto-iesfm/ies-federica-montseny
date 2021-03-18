package org.iesfm.discos;

import java.util.List;
import java.util.Objects;

public class Member {
    private String name;
    private String surnames;
    private String nif;
    private int postCode;
    private List<Order> orders;

    public Member(String name, String surnames, String nif, int postCode, List<Order> orders) {
        this.name = name;
        this.surnames = surnames;
        this.nif = nif;
        this.postCode = postCode;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return postCode == member.postCode && Objects.equals(name, member.name) && Objects.equals(surnames, member.surnames) && Objects.equals(nif, member.nif) && Objects.equals(orders, member.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surnames, nif, postCode, orders);
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", surnames='" + surnames + '\'' +
                ", nif='" + nif + '\'' +
                ", postCode=" + postCode +
                ", orders=" + orders +
                '}';
    }
}
