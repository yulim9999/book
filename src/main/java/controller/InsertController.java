package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.AlreadyExistingIsbnException;
import spring.BookInfo;
import spring.BookInsertService;
import spring.IsbnNot10Exception;
import spring.NotImageFileException;

@Controller
public class InsertController {

	private BookInsertService bookInsertService;

	public void setBookInsertService(BookInsertService bookInsertService) {
		this.bookInsertService = bookInsertService;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(BookInfo bookinfo) {
		return "/book_reg_form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submit(@ModelAttribute("bookInfo") BookInfo bookinfo, Errors errors) {
		System.out.println(bookinfo);
		new AddValidator().validate(bookinfo, errors);

		if (errors.hasErrors()) {
			return "/book_reg_form";
		}
		try {
			bookInsertService.register(bookinfo);
			return "redirect:/list";
		} catch (NotImageFileException e) {
			errors.rejectValue("file", "bad");
			return "/book_reg_form";
		} catch (AlreadyExistingIsbnException e) {
			errors.rejectValue("isbn", "duplicate");
			return "/book_reg_form";
		} catch (IsbnNot10Exception e) {
			errors.rejectValue("isbn", "Not10");
			return "/book_reg_form";
		}

	}

}
