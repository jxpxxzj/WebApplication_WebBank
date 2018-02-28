package com.jxpxxzj.webbank.services.impl;

import com.jxpxxzj.webbank.dao.AccountDao;
import com.jxpxxzj.webbank.models.Account;
import com.jxpxxzj.webbank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountDao accountDao;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional
    public Account login(String accountId, String password) {
        Account account = getAccountById(accountId);
        if (account == null)
            return null;

        if (account.getPassword().equals(password))
            return account;

        return null;
    }

    @Transactional
    public Account getAccountById(String accountId) {
        Account account = accountDao.findById(Account.class, accountId);
        if (account == null)
            return null;

        return account;
    }

    @Transactional
    public boolean subtractMoney(Account account, BigDecimal value) {
        if (account.getMoney().subtract(value).compareTo(BigDecimal.ZERO) <= 0)
            return false;

        account.setMoney(account.getMoney().subtract(value));
        accountDao.saveOrUpdate(account);
        return true;
    }


    @Transactional
    public boolean addMoney(Account account, BigDecimal value) {
        account.setMoney(account.getMoney().add(value));
        accountDao.saveOrUpdate(account);

        return true;
    }
}
