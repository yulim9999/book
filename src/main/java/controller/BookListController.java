package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.BookInfo;
import spring.BookInfoDao;

@Controller
public class BookListController {

	private BookInfoDao bookInfoDao;

	public void setBookInfoDao(BookInfoDao bookInfoDao) {
		this.bookInfoDao = bookInfoDao;
	}

	@RequestMapping("/list")
	public String list(Model model) {
		List<BookInfo> bookinfoList = bookInfoDao.selectAll();
		model.addAttribute("bookinfoList", bookinfoList);

		return "/book_list";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchBook(@ModelAttribute("bookInfo") BookInfo bookinfo, Model model) throws Exception {
		List<BookInfo> searchList = bookInfoDao.searchByKeyword(bookinfo);
		model.addAttribute("searchList", searchList);
		return "/book_list";
	}

}
