package com.jxpxxzj.webbank.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BIGINT")
    private long ID;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account Account;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private TradeType TradeType;

    @Column(scale = 2)
    private BigDecimal TradeMoney;

    @Column(columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date TradeTime;

    @Column(length = 1024)
    private String TradeDigest;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Account getAccount() {
        return Account;
    }

    public void setAccount(Account account) {
        Account = account;
    }

    public com.jxpxxzj.webbank.models.TradeType getTradeType() {
        return TradeType;
    }

    public void setTradeType(TradeType tradeType) {
        TradeType = tradeType;
    }

    public BigDecimal getTradeMoney() {
        return TradeMoney;
    }

    public void setTradeMoney(BigDecimal tradeMoney) {
        TradeMoney = tradeMoney;
    }

    public Date getTradeTime() {
        return TradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        TradeTime = tradeTime;
    }

    public String getTradeDigest() {
        return TradeDigest;
    }

    public void setTradeDigest(String tradeDigest) {
        TradeDigest = tradeDigest;
    }
}
