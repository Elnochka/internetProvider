package com.epam.rd.july2019.spring_internet_provider.models;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;


public class Subscriber {
    private Integer idSubscriber;
    @NotEmpty
    private String nameSubscriber;
    private Integer account;
    private boolean blocked;
    private Account accountObject;
    private Tariff tariff;

    public Subscriber(Integer idSubscriber, String nameSubscriber, boolean blocked, Account accountObject) {
        this.idSubscriber = idSubscriber;
        this.nameSubscriber = nameSubscriber;
        this.blocked = blocked;
        this.accountObject = accountObject;
    }

    public Subscriber(String nameSubscriber, boolean blocked, Account accountObject) {
        this.nameSubscriber = nameSubscriber;
        this.blocked = blocked;
        this.accountObject = accountObject;
    }

    public Subscriber(Integer idSubscriber, String nameSubscriber, Integer account, boolean blocked, Tariff tariff) {
        this.idSubscriber = idSubscriber;
        this.nameSubscriber = nameSubscriber;
        this.account = account;
        this.blocked = blocked;
        this.tariff = tariff;
    }

    public Subscriber(String nameSubscriber, Integer account, boolean blocked) {
        this.nameSubscriber = nameSubscriber;
        this.account = account;
        this.blocked = blocked;
    }

    public Subscriber(String nameSubscriber, Integer account) {
        this.nameSubscriber = nameSubscriber;
        this.account = account;
        this.blocked = false;
    }

    public Subscriber(Integer idSubscriber, String nameSubscriber, Integer account, boolean blocked) {
        this.idSubscriber = idSubscriber;
        this.nameSubscriber = nameSubscriber;
        this.account = account;
        this.blocked = blocked;
    }

    public Subscriber(String nameSubscriber, Integer account, boolean blocked, Tariff tariff) {
        this.nameSubscriber = nameSubscriber;
        this.account = account;
        this.blocked = blocked;
        this.tariff = tariff;
    }

    public Subscriber() {
    }

    public Subscriber(Integer idSubscriber, String nameSubscriber, Integer account) {
        this.idSubscriber = idSubscriber;
        this.nameSubscriber = nameSubscriber;
        this.account = account;
        this.blocked = false;
    }

    public Subscriber(Integer idSubscriber, String nameSubscriber, Integer account, Tariff tariff) {
        this.idSubscriber = idSubscriber;
        this.nameSubscriber = nameSubscriber;
        this.account = account;
        this.tariff = tariff;
    }

    public Account getAccountObject() {
        return accountObject;
    }

    public void setAccountObject(Account accountObject) {
        this.accountObject = accountObject;
    }

    public Integer getIdSubscriber() {
        return idSubscriber;
    }

    public void setIdSubscriber(Integer idSubscriber) {
        this.idSubscriber = idSubscriber;
    }

    public String getNameSubscriber() {
        return nameSubscriber;
    }

    public void setNameSubscriber(String nameSubscriber) {
        this.nameSubscriber = nameSubscriber;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "idSubscriber=" + idSubscriber +
                ", nameSubscriber='" + nameSubscriber + '\'' +
                ", account=" + account +
                ", blocked=" + blocked +
                ", accountObject=" + accountObject +
                ", tariff=" + tariff +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriber that = (Subscriber) o;
        return blocked == that.blocked &&
                Objects.equals(idSubscriber, that.idSubscriber) &&
                Objects.equals(nameSubscriber, that.nameSubscriber) &&
                Objects.equals(account, that.account) &&
                Objects.equals(accountObject, that.accountObject) &&
                Objects.equals(tariff, that.tariff);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idSubscriber, nameSubscriber, account, blocked, accountObject, tariff);
    }
}
