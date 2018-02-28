package com.jxpxxzj.webbank.services;

import com.jxpxxzj.webbank.models.Account;

import java.math.BigDecimal;

public interface AccountService {
    Account login(String accountId, String password);

    Account getAccountById(String accountId);

    boolean subtractMoney(Account account, BigDecimal value);

    boolean addMoney(Account account, BigDecimal value);

}
