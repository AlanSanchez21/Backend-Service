package com.project.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "COSTUMER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "First_Name")
    private String name;

    @Column(name = "Last_Name")
    private String lastname;

    @Column(name = "DNI")
    private int dni;

    @JsonManagedReference
    @OneToMany(mappedBy = "costumer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Sell> sell;

    @JsonManagedReference
    @OneToMany(mappedBy = "costumer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> product;

    public Costumer() {
    }

    public Costumer(long id, String name, String lastname, int dni, List<Sell> sell, List<Product> product) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.sell = sell;
        this.product = product;
    }

    public Costumer(String name, String lastname, int dni) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        Costumer costumer = (Costumer) o;
        return id == costumer.id && dni == costumer.dni && Objects.equals(name, costumer.name) && Objects.equals(lastname, costumer.lastname) && Objects.equals(sell, costumer.sell) && Objects.equals(product, costumer.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, dni, sell, product);
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dni=" + dni +
                ", sell=" + sell +
                ", product=" + product +
                '}';
    }
}
