package com.jxpxxzj.webbank.dao.impl;

import com.jxpxxzj.webbank.dao.AccountDao;
import com.jxpxxzj.webbank.models.Account;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl extends BaseDaoImpl<Account, String> implements AccountDao {

    public AccountDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
