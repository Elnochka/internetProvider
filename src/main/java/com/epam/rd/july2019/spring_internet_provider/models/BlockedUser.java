package com.epam.rd.july2019.spring_internet_provider.models;

import java.util.Objects;


public class BlockedUser {
    private Integer idBlockedSubscriber;
    private Integer idBlockedTariff;
    private Integer idBlockedAccount;
    private Subscriber blockedSubscriber;
    private Tariff blockedTariff;
    private Account blockedAccount;
    private boolean userBlocked;
    private Double userPrice;
    private Double userBalance;

    public BlockedUser(Integer idBlockedSubscriber, boolean userBlocked, Double userPrice, Double userBalance) {
        this.idBlockedSubscriber = idBlockedSubscriber;
        this.userBlocked = userBlocked;
        this.userPrice = userPrice;
        this.userBalance = userBalance;
    }

    public BlockedUser(Integer idBlockedSubscriber, Integer idBlockedTariff, Integer idBlockedAccount) {
        this.idBlockedSubscriber = idBlockedSubscriber;
        this.idBlockedTariff = idBlockedTariff;
        this.idBlockedAccount = idBlockedAccount;
    }

    public BlockedUser(Subscriber blockedSubscriber, Tariff blockedTariff, Account blockedAccount) {
        this.blockedSubscriber = blockedSubscriber;
        this.blockedTariff = blockedTariff;
        this.blockedAccount = blockedAccount;
    }

    public BlockedUser() {
    }

    public Integer getIdBlockedSubscriber() {
        return idBlockedSubscriber;
    }

    public void setIdBlockedSubscriber(Integer idBlockedSubscriber) {
        this.idBlockedSubscriber = idBlockedSubscriber;
    }

    public Integer getIdBlockedTariff() {
        return idBlockedTariff;
    }

    public void setIdBlockedTariff(Integer idBlockedTariff) {
        this.idBlockedTariff = idBlockedTariff;
    }

    public Integer getIdBlockedAccount() {
        return idBlockedAccount;
    }

    public void setIdBlockedAccount(Integer idBlockedAccount) {
        this.idBlockedAccount = idBlockedAccount;
    }

    public Subscriber getBlockedSubscriber() {
        return blockedSubscriber;
    }

    public void setBlockedSubscriber(Subscriber blockedSubscriber) {
        this.blockedSubscriber = blockedSubscriber;
    }

    public Tariff getBlockedTariff() {
        return blockedTariff;
    }

    public void setBlockedTariff(Tariff blockedTariff) {
        this.blockedTariff = blockedTariff;
    }

    public Account getBlockedAccount() {
        return blockedAccount;
    }

    public void setBlockedAccount(Account blockedAccount) {
        this.blockedAccount = blockedAccount;
    }

    public boolean isUserBlocked() {
        return userBlocked;
    }

    public void setUserBlocked(boolean userBlocked) {
        this.userBlocked = userBlocked;
    }

    public Double getUserPrice() {
        return userPrice;
    }

    public void setUserPrice(Double userPrice) {
        this.userPrice = userPrice;
    }

    public Double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Double userBalance) {
        this.userBalance = userBalance;
    }

    @Override
    public String toString() {
        return "BlockedUser{" +
                "idBlockedSubscriber=" + idBlockedSubscriber +
                ", idBlockedTariff=" + idBlockedTariff +
                ", idBlockedAccount=" + idBlockedAccount +
                ", blockedSubscriber=" + blockedSubscriber +
                ", blockedTariff=" + blockedTariff +
                ", blockedAccount=" + blockedAccount +
                ", userBlocked=" + userBlocked +
                ", userPrice=" + userPrice +
                ", userBalance=" + userBalance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlockedUser that = (BlockedUser) o;
        return Objects.equals(idBlockedSubscriber, that.idBlockedSubscriber) &&
                Objects.equals(idBlockedTariff, that.idBlockedTariff) &&
                Objects.equals(idBlockedAccount, that.idBlockedAccount) &&
                Objects.equals(blockedSubscriber, that.blockedSubscriber) &&
                Objects.equals(blockedTariff, that.blockedTariff) &&
                Objects.equals(blockedAccount, that.blockedAccount) &&
                Objects.equals(userBlocked, that.userBlocked) &&
                Objects.equals(userPrice, that.userPrice) &&
                Objects.equals(userBalance, that.userBalance);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idBlockedSubscriber, idBlockedTariff, idBlockedAccount, blockedSubscriber, blockedTariff, blockedAccount, userBlocked, userPrice, userBalance);
    }
}
