package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.BookInfo;
import spring.BookInfoDao;

@Controller
public class BookDetailController {
	private BookInfoDao bookInfoDao;

	public void setBookInfoDao(BookInfoDao bookInfoDao) {
		this.bookInfoDao = bookInfoDao;
	}

	@RequestMapping("/read/{regnum}")
	public String detail(@PathVariable("regnum") Long regnum, Model model) {
		BookInfo bookinfo = bookInfoDao.selectByRegnum(regnum);
		if (bookinfo == null) {
			return "/error/errorForm";
		}
		model.addAttribute("bookinfo", bookinfo);
		return "/details";
	}
}
