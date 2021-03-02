package ru.kpfu.itis.valeev.models;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "userName", "userName.empty", "REDO");
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty", "REDO AGAIN");
        ValidationUtils.rejectIfEmpty(errors, "password", "password.empty", "ENTER PASSWORD");}
}
