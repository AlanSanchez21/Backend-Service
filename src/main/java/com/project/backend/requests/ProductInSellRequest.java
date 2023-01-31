package com.project.backend.requests;

import java.util.Objects;

public class ProductInSellRequest {
    private Long ProdId;
    private float quantity;

    public ProductInSellRequest() {
    }

    public ProductInSellRequest(Long prodId, float quantity) {
        ProdId = prodId;
        this.quantity = quantity;
    }

    public Long getProdId() {
        return ProdId;
    }

    public void setProdId(Long prodId) {
        ProdId = prodId;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInSellRequest that = (ProductInSellRequest) o;
        return Float.compare(that.quantity, quantity) == 0 && Objects.equals(ProdId, that.ProdId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ProdId, quantity);
    }
}
