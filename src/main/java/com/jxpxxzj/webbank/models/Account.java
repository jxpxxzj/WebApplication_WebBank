package com.jxpxxzj.webbank.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Account {

    @Id
    @Column(length = 50)
    private String AccountID;

    @Column(length = 6)
    private String Password;

    @Column(scale = 2)
    private BigDecimal Money;

    @OneToMany
    private List<Trade> Trades;

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String accountID) {
        AccountID = accountID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public BigDecimal getMoney() {
        return Money;
    }

    public void setMoney(BigDecimal money) {
        Money = money;
    }

    public List<Trade> getTrades() {
        return Trades;
    }

    public void setTrades(List<Trade> trades) {
        Trades = trades;
    }
}

