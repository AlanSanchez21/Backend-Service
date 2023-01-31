package com.project.backend.requests;

import java.util.List;
import java.util.Objects;

public class SellRequest {
    private String costumerId;
    private List<ProductInSellRequest> quantity;
    private int totalPrice;

    public SellRequest() {
    }

    public SellRequest(String name, List<ProductInSellRequest> quantity, int totalPrice) {
        this.costumerId = name;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(String costumerId) {
        this.costumerId = costumerId;
    }

    public List<ProductInSellRequest> getQuantity() {
        return quantity;
    }

    public void setQuantity(List<ProductInSellRequest> quantity) {
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
        return totalPrice == that.totalPrice && Objects.equals(costumerId, that.costumerId) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(costumerId, quantity, totalPrice);
    }
}
