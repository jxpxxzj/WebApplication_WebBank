package com.jxpxxzj.webbank.validator;

import com.jxpxxzj.webbank.models.Account;
import org.springframework.lang.Nullable;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AccountValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Account.class.equals(clazz);
    }

    @Override
    public void validate(@Nullable Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "AccountId", null, "Account Id cannot be empty.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Password", null, "Password cannot be empty.");

        Account account = (Account)target;
        if (account.getPassword().length() > 6) {
            errors.rejectValue("Password", null, "Password too long.");
        }
    }
}
