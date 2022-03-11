package spring;

import java.util.List;

public interface BookInfoDao {
	public void insert(BookInfo bookinfo);
	public List<BookInfo> selectAll();
	
	public List<BookInfo> searchByKeyword(BookInfo bookinfo);
	
	public BookInfo selectByRegnum(Long regnum);

	public int isbnChk(String isbn);
	
}
