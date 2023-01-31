package com.project.backend.requests;

import java.util.Objects;

public class ProductRequest {
    private String name;
    private int code;
    private float price;

    public ProductRequest () {
    }

    public ProductRequest(String name, int code, int price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public int getPrice() {
        return (int) price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRequest that = (ProductRequest) o;
        return code == that.code && price == that.price && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, price);
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "name='" + name + '\'' +
                ", code=" + code +
                ", price=" + price +
                '}';
    }
}
