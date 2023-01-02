package com.project.backend.requests;

import java.util.Objects;

public class CostumerRequest {
    private String name;
    private String lastname;
    private int dni;

    public CostumerRequest() {
    }

    public CostumerRequest(String name, String lastname, int dni) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CostumerRequest that = (CostumerRequest) o;
        return dni == that.dni && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, dni);
    }

    @Override
    public String toString() {
        return "ClientRequest{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dni=" + dni +
                '}';
    }
}
