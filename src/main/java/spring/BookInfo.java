package spring;

import org.springframework.web.multipart.MultipartFile;

public class BookInfo {
	private int regnum;
	private String isbn;
	private String bookname;
	private String writer;
	private String publisher;
	private String price;
	private String image;
	private String introduction;

	private MultipartFile file;

	private String keyword;
	private String option;

	// 디폴트 생성자
	public BookInfo() {
	}

	public BookInfo(int regnum, String isbn, String bookname, String writer, String publisher, String price,
			String image, String introduction) {
		this.regnum = regnum;
		this.isbn = isbn;
		this.bookname = bookname;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
		this.image = image;
		this.introduction = introduction;
	}

	// setter,getter

	public int getRegnum() {
		return regnum;
	}

	public void setRegnum(int regnum) {
		this.regnum = regnum;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "BookInfo [regnum=" + regnum + ", isbn=" + isbn + ", bookname=" + bookname + ", writer=" + writer
				+ ", publisher=" + publisher + ", price=" + price + ", image=" + image + ", introduction="
				+ introduction + ", file=" + file + ", keyword=" + keyword + ", option=" + option + "]";
	}

}
