package com.epam.rd.july2019.spring_internet_provider.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;


public class Tariff {
    private Integer idTariff;
    @NotEmpty
    private String nameTariff;
    @NotNull
    private Double price;
    @Pattern(regexp = "^\\w:/\\w+\\.\\w+$|\\w:/\\w+\\.\\w+\\s+$|\\w:\\\\\\w+\\.\\w+$|\\w:\\\\\\w+\\.\\w+\\s+$")
    private String pathFile;

    public Tariff(int idTariff, String nameTariff, Double price) {
        this.idTariff = idTariff;
        this.nameTariff = nameTariff;
        this.price = price;
    }

    public Tariff(String nameTariff, Double price) {
        this.nameTariff = nameTariff;
        this.price = price;
    }

    public Tariff(String nameTariff, Double price, String pathFile) {
        this.nameTariff = nameTariff;
        this.price = price;
        this.pathFile = pathFile;
    }

    public Tariff() {
    }

    public int getIdTariff() {
        return idTariff;
    }

    public void setIdTariff(int idTariff) {
        this.idTariff = idTariff;
    }

    public String getNameTariff() {
        return nameTariff;
    }

    public void setNameTariff(String nameTariff) {
        this.nameTariff = nameTariff;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public Tariff(int idTariff, String nameTariff, Double price, String pathFile) {
        this.idTariff = idTariff;
        this.nameTariff = nameTariff;
        this.price = price;
        this.pathFile = pathFile;
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "idTariff=" + idTariff +
                ", nameTariff='" + nameTariff + '\'' +
                ", price=" + price +
                ", pathFile='" + pathFile + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tariff tariff = (Tariff) o;
        return idTariff == tariff.idTariff &&
                Double.compare(tariff.price, price) == 0 &&
                Objects.equals(nameTariff, tariff.nameTariff) &&
                Objects.equals(pathFile, tariff.pathFile);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTariff, nameTariff, price, pathFile);
    }
}
