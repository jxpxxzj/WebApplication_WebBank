package com.jxpxxzj.webbank.controllers;

import com.jxpxxzj.webbank.auth.AuthPassport;
import com.jxpxxzj.webbank.models.Account;
import com.jxpxxzj.webbank.models.Trade;
import com.jxpxxzj.webbank.services.AccountService;
import com.jxpxxzj.webbank.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TradeController {

    private final TradeService tradeService;

    private final AccountService accountService;

    @Autowired
    public TradeController(TradeService tradeService, AccountService accountService) {
        this.tradeService = tradeService;
        this.accountService = accountService;
    }

    @AuthPassport
    @RequestMapping("/user/tradeRecord")
    public ModelAndView tradeRecord() {
        return new ModelAndView("tradeRecord");
    }

    @AuthPassport
    @RequestMapping("/user/doTradeRecord")
    public ModelAndView doTradeRecord(@RequestParam String begin, @RequestParam String end, HttpSession session) {
        Account account = accountService.getAccountById(session.getAttribute("account").toString());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate;
        Date endDate;

        ModelAndView fail = new ModelAndView();
        fail.setViewName("tradeRecord");
        fail.addObject("fail", true);

        try {
            beginDate = formatter.parse(begin);
            endDate = formatter.parse(end);
            List<Trade> trades = tradeService.getTradeRecord(account, beginDate, endDate);
            if (trades == null) {
                return fail;
            }

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("tradeRecordSuccess");
            modelAndView.addObject("data", trades);
            return modelAndView;
        } catch (ParseException e) {

            return fail;
        }
    }
}
