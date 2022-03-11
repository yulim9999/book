package spring;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class BookInfoDaoImpl implements BookInfoDao{
	private SqlSessionTemplate sqlST;
	
	public BookInfoDaoImpl(SqlSessionTemplate sqlST) {
		this.sqlST=sqlST;
	}
	
	@Override
	public List<BookInfo> selectAll(){
		return sqlST.selectList("list");
	}
	
	@Override
	public void insert(BookInfo bookinfo) {
		sqlST.insert("insert",bookinfo);
	}
	
	@Override
	public List<BookInfo> searchByKeyword(BookInfo bookinfo){
		return sqlST.selectList("searchByKeyword",bookinfo);
	}
	
	@Override
	public BookInfo selectByRegnum(Long regnum){
		return sqlST.selectOne("selectByRegnum",regnum);
	}
	
	@Override
	public int isbnChk(String isbn) {
		int result=sqlST.selectOne("isbnChk",isbn );
		return result;
	}
}
