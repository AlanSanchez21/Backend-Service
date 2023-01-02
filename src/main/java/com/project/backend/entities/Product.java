package com.project.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "PRODUCT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Code")
    private int code;

    @Column(name = "Price")
    private int price;

    @JsonBackReference(value = "costumer")
    @ManyToOne(fetch = FetchType.EAGER)
    private Costumer costumer;

    public Product(String name, int code, int price) {
    }


    public Product(int id, String name, int code, int price, Costumer costumer) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
        this.costumer = costumer;
    }

    public Product(String name, int code, int price, Costumer costumer) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.costumer = costumer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Costumer getClient() {
        return costumer;
    }

    public void setClient(Costumer costumer) {
        this.costumer = costumer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && code == product.code && price == product.price && Objects.equals(name, product.name) && Objects.equals(costumer, product.costumer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, price, costumer);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", price=" + price +
                ", client=" + costumer +
                '}';
    }
}
