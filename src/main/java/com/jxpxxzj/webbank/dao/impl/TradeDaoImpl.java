package com.jxpxxzj.webbank.dao.impl;

import com.jxpxxzj.webbank.dao.TradeDao;
import com.jxpxxzj.webbank.models.Trade;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class TradeDaoImpl extends BaseDaoImpl<Trade, BigInteger> implements TradeDao {

    public TradeDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
