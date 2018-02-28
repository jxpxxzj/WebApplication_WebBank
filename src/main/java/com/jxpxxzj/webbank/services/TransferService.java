package com.jxpxxzj.webbank.services;

import com.jxpxxzj.webbank.models.Account;

import java.math.BigDecimal;

public interface TransferService {
    boolean transfer(Account source, String target, BigDecimal money);
}
