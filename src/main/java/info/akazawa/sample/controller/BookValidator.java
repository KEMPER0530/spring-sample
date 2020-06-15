package info.akazawa.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import info.akazawa.sample.controller.form.BookForm;
import info.akazawa.sample.service.BookService;

@Component
public class BookValidator implements Validator {

    @Autowired
    BookService bookService;

    @Override
    public boolean supports(Class<?> clazz) {
        return BookForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        // required check
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookName", "field.required");

        // TODO form check
        // BookForm form = BookForm.class.cast(target);
        // errors.rejectValue("field", "errorCode");

        // global message
        if (errors.hasErrors()) {
            errors.reject("input.error");
        }
    }
}
