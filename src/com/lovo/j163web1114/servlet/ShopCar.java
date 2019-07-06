package com.lovo.j163web1114.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lovo.j163web1114.bean.Goods;

@WebServlet("/ShopCar")
public class ShopCar extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if("add".equals(action)) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			int number = Integer.parseInt(request.getParameter("number"));
			float price = Float.parseFloat(request.getParameter("price"));
			Goods goods = new Goods(id, name, price, number);
			ArrayList bookList = (ArrayList)session.getAttribute("book");
			if(bookList == null) {
				bookList = new ArrayList();
				bookList.add(goods);
				session.setAttribute("book", bookList);
				String url = response.encodeRedirectURL("ShowResultServlet");
				response.sendRedirect(url);
			}else {
				Iterator it = bookList.iterator();
				for(int i = 0;i <bookList.size();i++) {
					Goods book = (Goods)it.next();
					if(book.compareTo(goods) == 0) {
						out.println("你已经订购了此书籍!");
						return;
					}
				}
				bookList.add(goods);
				session.setAttribute("book", bookList);
				String url = response.encodeRedirectURL("ShowResultServlet");
				response.sendRedirect(url);
			}
		}
		else {
			out.print("<html><head><title>购物车</title></head>");
			out.println("<body>");
			out.print("<p>在线书店登陆购物车</p>");
			out.println("<form method=post action="+response.encodeURL("ShopCar?action=add")+">");
			out.println("<table>");
			out.println("<tr><td>ID：</td><td><input type=text name=id></td></tr>");
			out.println("<tr><td>name：</td><td><input type=text name=name></td></tr>");
			out.println("<tr><td>number：</td><td><input type=text name=number></td></tr>");
			out.println("<tr><td>price：</td><td><input type=text name=price></td></tr>");
			out.println("<tr><td><input type=submit value=添加></td></tr>");
			out.println("</table></from></body></html>");
			out.flush();
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
