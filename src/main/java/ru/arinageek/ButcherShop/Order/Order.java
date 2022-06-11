package ru.arinageek.ButcherShop.Order;

import ru.arinageek.ButcherShop.meat.Meat;

import java.util.Set;

public class Order {
    private Set<Meat> meat;
    private String email;
    private String address;
    private String time;

    public Order() {}

    public Order(Set<Meat> meat, String email, String address, String time) {
        this.meat = meat;
        this.email = email;
        this.address = address;
        this.time = time;
    }

    public Set<Meat> getMeat() {
        return meat;
    }

    public void setMeat(Set<Meat> meat) {
        this.meat = meat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "meat=" + meat +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
