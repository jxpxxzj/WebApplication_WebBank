package com.jxpxxzj.webbank.services.impl;

import com.jxpxxzj.webbank.dao.TradeDao;
import com.jxpxxzj.webbank.models.Account;
import com.jxpxxzj.webbank.models.Trade;
import com.jxpxxzj.webbank.models.TradeType;
import com.jxpxxzj.webbank.services.AccountService;
import com.jxpxxzj.webbank.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Service
public class TransferServiceImpl implements TransferService {
    private final TradeDao tradeDao;

    private final AccountService accountService;

    @Autowired
    public TransferServiceImpl(TradeDao tradeDao, AccountService accountService) {
        this.tradeDao = tradeDao;
        this.accountService = accountService;
    }

    @Transactional
    public boolean transfer(Account source, String target, BigDecimal money) {
        BigDecimal fee = money.multiply(new BigDecimal(0.005));
        if (fee.compareTo(new BigDecimal(2)) < 0) {
            fee = new BigDecimal(2);
        }
        if (fee.compareTo(new BigDecimal(20)) > 0) {
            fee = new BigDecimal(20);
        }

        BigDecimal sourceMoney = source.getMoney();
        if (Objects.equals(source.getAccountID(), target)) {
            return false;
        }
        if (money.compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }
        if (sourceMoney.subtract(money).subtract(fee).compareTo(BigDecimal.ZERO) < 0) { // not enough money
            return false;
        } else {
            Account targetAccount = accountService.getAccountById(target);
            if (targetAccount == null) {
                return false;
            }

            accountService.subtractMoney(source, money);
            accountService.subtractMoney(source, fee);
            accountService.addMoney(targetAccount, money);

            Date transferTime = Calendar.getInstance().getTime();

            Trade tradeSource = new Trade();
            tradeSource.setAccount(source);
            tradeSource.setTradeType(TradeType.Transfer);
            tradeSource.setTradeMoney(money.add(fee).multiply(new BigDecimal(-1)));
            tradeSource.setTradeTime(transferTime);
            tradeSource.setTradeDigest("接收账号:" + target);

            tradeDao.save(tradeSource);

            return true;
        }
    }
}
