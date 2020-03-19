package com.epam.rd.july2019.spring_internet_provider.models;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;


public class Favour {

    private Integer idFavour;
    @NotEmpty
    private String nameFavour;

    public Favour(Integer idFavour, String nameFavour) {
        this.idFavour = idFavour;
        this.nameFavour = nameFavour;
    }

    public Favour(String nameFavour) {
        this.nameFavour = nameFavour;
    }

    public Favour() {
    }

    public Integer getIdFavour() {
        return idFavour;
    }

    public void setIdFavour(Integer idFavour) {
        this.idFavour = idFavour;
    }

    public String getNameFavour() {
        return nameFavour;
    }

    public void setNameFavour(String nameFavour) {
        this.nameFavour = nameFavour;
    }

    @Override
    public String toString() {
        return "Favour{" +
                "idFavour=" + idFavour +
                ", nameFavour='" + nameFavour + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favour favour = (Favour) o;
        return Objects.equals(idFavour, favour.idFavour) &&
                Objects.equals(nameFavour, favour.nameFavour);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idFavour, nameFavour);
    }
}
