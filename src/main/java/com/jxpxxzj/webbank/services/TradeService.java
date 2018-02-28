package com.jxpxxzj.webbank.services;

import com.jxpxxzj.webbank.models.Account;
import com.jxpxxzj.webbank.models.Trade;

import java.util.Date;
import java.util.List;

public interface TradeService {
    List<Trade> getTradeRecord(Account account, Date begin, Date end);
}
