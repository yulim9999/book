package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.BookInfo;

public class AddValidator implements Validator {

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookname", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "writer", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publisher", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "introduction", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "required");
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return BookInfo.class.isAssignableFrom(arg0);
	}
}
