package com.jxpxxzj.webbank.controllers;

import com.jxpxxzj.webbank.auth.AuthPassport;
import com.jxpxxzj.webbank.services.AccountService;
import com.jxpxxzj.webbank.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Controller
public class TransferController {

    private final TransferService transferService;

    private final AccountService accountService;

    @Autowired
    public TransferController(TransferService transferService, AccountService accountService) {
        this.transferService = transferService;
        this.accountService = accountService;
    }

    @AuthPassport
    @RequestMapping("/user/transfer")
    public ModelAndView transfer() {
        return new ModelAndView("transfer");
    }

    @AuthPassport
    @RequestMapping("/user/doTransfer")
    public ModelAndView doTransfer(@RequestParam String accountId, @RequestParam Integer money, HttpSession session) {
        Boolean result = transferService.transfer(accountService.getAccountById(session.getAttribute("account").toString()), accountId, new BigDecimal(money));
        if (result) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("transferSuccess");
            modelAndView.addObject("account", accountId);
            modelAndView.addObject("money", money);
            return modelAndView;
        } else {
            ModelAndView fail = new ModelAndView();
            fail.setViewName("transfer");
            fail.addObject("fail", true);
            return fail;
        }
    }
}
