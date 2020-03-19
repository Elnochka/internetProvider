package com.epam.rd.july2019.spring_internet_provider.models;


import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Account {
    private Integer idAccount;
    @NotNull(message = "{NotNull.accountForm.account}")
    private Long account;
    @NotNull
    private Double balance;

    public Account(Integer idAccount, Long account, Double balance) {
        this.idAccount = idAccount;
        this.account = account;
        this.balance = balance;
    }

    public Account(Long account, Double balance) {
        this.account = account;
        this.balance = balance;
    }

    public Account() {
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "idAccount=" + idAccount +
                ", account=" + account +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account1 = (Account) o;
        return Objects.equals(idAccount, account1.idAccount) &&
                Objects.equals(account, account1.account) &&
                Objects.equals(balance, account1.balance);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idAccount, account, balance);
    }
}
