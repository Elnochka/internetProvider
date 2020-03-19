package com.epam.rd.july2019.spring_internet_provider.models;

import java.util.Objects;


public class TariffFavour {
    private Integer idTariffFavour;
    private Integer idSubscriber;
    private Integer idTariff;
    private Integer idFavour;
    private Subscriber subscriber;
    private Tariff tariff;
    private Favour favour;

    public TariffFavour(Integer idTariffFavour, Integer idSubscriber, Integer idTariff, Integer idFavour) {
        this.idTariffFavour = idTariffFavour;
        this.idSubscriber = idSubscriber;
        this.idTariff = idTariff;
        this.idFavour = idFavour;
    }

    public TariffFavour(Integer idSubscriber, Integer idTariff, Integer idFavour) {
        this.idSubscriber = idSubscriber;
        this.idTariff = idTariff;
        this.idFavour = idFavour;
    }

    public TariffFavour(Integer idTariff, Integer idFavour) {
        this.idTariff = idTariff;
        this.idFavour = idFavour;
    }

    public TariffFavour(Subscriber subscriber, Tariff tariff, Favour favour) {
        this.subscriber = subscriber;
        this.tariff = tariff;
        this.favour = favour;
    }

    public TariffFavour(Integer idTariffFavour, Integer idSubscriber, Tariff tariff, Favour favour) {
        this.idTariffFavour = idTariffFavour;
        this.idSubscriber = idSubscriber;
        this.tariff = tariff;
        this.favour = favour;
    }

    public TariffFavour(Integer idTariffFavour, Subscriber subscriber, Tariff tariff, Favour favour) {
        this.idTariffFavour = idTariffFavour;
        this.subscriber = subscriber;
        this.tariff = tariff;
        this.favour = favour;
    }

    public TariffFavour() {
    }

    public Integer getIdSubscriber() {
        return idSubscriber;
    }

    public void setIdSubscriber(Integer idSubscriber) {
        this.idSubscriber = idSubscriber;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public Favour getFavour() {
        return favour;
    }

    public void setFavour(Favour favour) {
        this.favour = favour;
    }

    public Integer getIdTariffFavour() {
        return idTariffFavour;
    }

    public void setIdTariffFavour(Integer idTariffFavour) {
        this.idTariffFavour = idTariffFavour;
    }

    public Integer getIdTariff() {
        return idTariff;
    }

    public void setIdTariff(Integer idTariff) {
        this.idTariff = idTariff;
    }

    public Integer getIdFavour() {
        return idFavour;
    }

    public void setIdFavour(Integer idFavour) {
        this.idFavour = idFavour;
    }

    @Override
    public String toString() {
        return "TariffFavour{" +
                "idTariffFavour=" + idTariffFavour +
                ", idSubscriber=" + idSubscriber +
                ", idTariff=" + idTariff +
                ", idFavour=" + idFavour +
                ", subscriber=" + subscriber +
                ", tariff=" + tariff +
                ", favour=" + favour +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TariffFavour that = (TariffFavour) o;
        return Objects.equals(idTariffFavour, that.idTariffFavour) &&
                Objects.equals(idSubscriber, that.idSubscriber) &&
                Objects.equals(idTariff, that.idTariff) &&
                Objects.equals(idFavour, that.idFavour) &&
                Objects.equals(subscriber, that.subscriber) &&
                Objects.equals(tariff, that.tariff) &&
                Objects.equals(favour, that.favour);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTariffFavour, idSubscriber, idTariff, idFavour, subscriber, tariff, favour);
    }
}
