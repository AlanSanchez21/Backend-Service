package com.project.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Client")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "First_Name")
    private String name;

    @Column(name = "Last_Name")
    private String lastname;

    @Column(name = "DNI")
    private int dni;

    @JsonManagedReference
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Sell> sell;

    @JsonManagedReference
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> product;

    public Client(int id, String name, String lastname, int dni, List<Sell> sell, List<Product> product) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.sell = sell;
        this.product = product;
    }

    public Client(String name, String lastname, int dni, List<Sell> sell, List<Product> product) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.sell = sell;
        this.product = product;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public List<Sell> getSell() {
        return sell;
    }

    public void setSell(List<Sell> sell) {
        this.sell = sell;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && dni == client.dni && Objects.equals(name, client.name) && Objects.equals(lastname, client.lastname) && Objects.equals(sell, client.sell) && Objects.equals(product, client.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, dni, sell, product);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dni=" + dni +
                ", sell=" + sell +
                ", product=" + product +
                '}';
    }
}
