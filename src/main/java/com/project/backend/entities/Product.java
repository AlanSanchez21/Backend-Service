package com.project.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Products")
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

    @JsonBackReference(value = "client")
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    public Product() {
    }

    public Product(int id, String name, int code, int price, Client client) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
        this.client = client;
    }

    public Product(String name, int code, int price, Client client) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && code == product.code && price == product.price && Objects.equals(name, product.name) && Objects.equals(client, product.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, price, client);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", price=" + price +
                ", client=" + client +
                '}';
    }
}
