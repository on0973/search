
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Book;


public class BookDAO extends DAO {

	public List<Book> search(String keyword) throws Exception {

		List<Book> list=new ArrayList<>();

		Connection con=getConnection();

		//タイトルと著者名をキーワードに設定
		PreparedStatement st=con.prepareStatement(
				"select * from book where title like ? or author like ?");
		st.setString(1, "%"+keyword+"%");
		st.setString(2, "%"+keyword+"%");
		ResultSet rs=st.executeQuery();

		//該当するものを出力
		while (rs.next()) {
			Book b=new Book();
			b.setTitle(rs.getString("title"));
			b.setAuthor(rs.getString("author"));
			list.add(b);
		}
		st.close();
		con.close();

		return list;
	}


	public int insert(Book book) throws Exception {
		Connection con=getConnection();

		//本のタイトルと著者名を登録
		PreparedStatement st=con.prepareStatement(
				"insert into book values (null, ?, ?)");
		st.setString(1, book.getTitle());
		st.setString(2, book.getAuthor());
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}



}