package com.jxpxxzj.webbank.controllers;

import com.jxpxxzj.webbank.models.Account;
import com.jxpxxzj.webbank.services.AccountService;
import com.jxpxxzj.webbank.validator.AccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class MainController {

    private final AccountService accountService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new AccountValidator());
    }

    @Autowired
    public MainController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        Account account = new Account();
        return new ModelAndView("login").addObject(account).addObject("result", true);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return index();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView userLogin(@Valid @ModelAttribute("account") Account account, BindingResult bindingResult, HttpSession session) {
        Account realAccount = accountService.login(account.getAccountID(), account.getPassword());
        if (realAccount == null || bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("login");
            modelAndView.addObject("result", null);
            return modelAndView;
        }

        session.setAttribute("account", realAccount.getAccountID());
        session.setAttribute("user", realAccount);
        return new ModelAndView("redirect:/user/index");

    }
}
