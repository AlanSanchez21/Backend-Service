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
    private Costumer costumer;

    public Sell(String name, int quantity, int totalPrice) {
    }

    public Sell(int id, String name, int quantity, int totalPrice, Costumer costumer) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.costumer = costumer;
    }

    public Sell(String name, int quantity, int totalPrice, Costumer costumer) {
        this.name = name;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
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
        Sell sell = (Sell) o;
        return id == sell.id && quantity == sell.quantity && totalPrice == sell.totalPrice && Objects.equals(name, sell.name) && Objects.equals(costumer, sell.costumer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity, totalPrice, costumer);
    }

    @Override
    public String toString() {
        return "Sell{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", client=" + costumer +
                '}';
    }
}
