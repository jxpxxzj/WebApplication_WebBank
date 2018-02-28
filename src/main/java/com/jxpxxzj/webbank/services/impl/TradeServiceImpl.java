package com.jxpxxzj.webbank.services.impl;

import com.jxpxxzj.webbank.dao.TradeDao;
import com.jxpxxzj.webbank.models.Account;
import com.jxpxxzj.webbank.models.Trade;
import com.jxpxxzj.webbank.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {
    private final TradeDao tradeDao;

    @Autowired
    public TradeServiceImpl(TradeDao tradeDao) {
        this.tradeDao = tradeDao;
    }

    public static boolean checkDateAvailable(Date begin, Date end) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date aMonthAgo = calendar.getTime();

        if (begin.getTime() >= aMonthAgo.getTime() && begin.getTime() <= Calendar.getInstance().getTime().getTime() && begin.getTime() <= end.getTime()) {
            return true;
        }

        return false;
    }

    @Transactional
    public List<Trade> getTradeRecord(Account account, Date begin, Date end) {
        if (!checkDateAvailable(begin, end))
            return null;

        List<Trade> list = tradeDao.findByHql("from Trade where Account=? and TradeTime between ? and ?",
                new Object[]{account, begin, end});

        return list;
    }
}
