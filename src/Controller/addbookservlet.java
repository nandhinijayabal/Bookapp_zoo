package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import model.Book;
import model.user;

@WebServlet("/AddbooksServlet")
public class addbookservlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("addbookservlet");
		
		
		
		String name = request.getParameter("name");
		String price=request.getParameter("price");
		String author_id=request.getParameter("author_id");
		String pub_date=request.getParameter("pub_date");
	
		out.println("name="+ name);
		out.println("price="+ price);
		out.println("author_id="+ author_id);
		out.println("pub_date="+ pub_date);
		
		int price1 = Integer.parseInt(price);
		LocalDate pub_date1 = LocalDate.parse(pub_date);
      int author_id1 = Integer.parseInt(author_id);

       BookDAO bookDAO =new BookDAO();
		
		Book book = new Book();
		book.setName(name);
		book.setPrice(price1);
		book.setAuthor_id(author_id1);
		book.setPub_date(pub_date1);
        out.println(book);
        
        
        try {
			bookDAO.addbook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        response.sendRedirect("addbook.jsp");
        
	
	}

}
