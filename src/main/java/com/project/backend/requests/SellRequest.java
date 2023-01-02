package com.project.backend.requests;

import java.util.Objects;

public class SellRequest {
    private String name;
    private int quantity;
    private int totalPrice;

    public SellRequest() {
    }

    public SellRequest(String name, int quantity, int totalPrice) {
        this.name = name;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellRequest that = (SellRequest) o;
        return quantity == that.quantity && totalPrice == that.totalPrice && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity, totalPrice);
    }

    @Override
    public String toString() {
        return "SellRequest{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
