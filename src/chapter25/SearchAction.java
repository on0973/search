

//検索に引っかかった登録情報を取得して配列に格納する


package chapter25;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Book;
import dao.BookDAO;
import tool.Action;

public class SearchAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception{

		HttpSession session=request.getSession();


		String keyword=request.getParameter("keyword");
		if (keyword==null) keyword="";

		//本のタイトルと著者名を取得
		BookDAO dao=new BookDAO();
		List<Book> list=dao.search(keyword);
		request.setAttribute("list", list);

		return "list.jsp";
	}
}
