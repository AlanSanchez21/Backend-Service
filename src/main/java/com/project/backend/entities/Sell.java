package com.project.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Sells")
public class Sell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name")
    private String name;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Total_Price")
    private int totalPrice;

    @JsonBackReference(value = "client")
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    public Sell(int id, String name, int quantity, int totalPrice, Client client) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.client = client;
    }

    public Sell(String name, int quantity, int totalPrice, Client client) {
        this.name = name;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
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
        Sell sell = (Sell) o;
        return id == sell.id && quantity == sell.quantity && totalPrice == sell.totalPrice && Objects.equals(name, sell.name) && Objects.equals(client, sell.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity, totalPrice, client);
    }

    @Override
    public String toString() {
        return "Sell{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", client=" + client +
                '}';
    }
}
