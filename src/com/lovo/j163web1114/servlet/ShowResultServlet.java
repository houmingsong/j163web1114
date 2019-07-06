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

@WebServlet("/ShowResultServlet")
public class ShowResultServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		ArrayList bookList = (ArrayList) session.getAttribute("book");
		Iterator it = bookList.iterator();
		while (it.hasNext()) {
			Goods book = (Goods) it.next();
			out.println(
					book.getId() + "  ," + book.getName() + "" + book.getNumber() + "  ," + book.getPrice() + "</br>");
		}
		out.print("<hr>");
		out.println("<a href=" + response.encodeUrl("ShopCar") + ">·µ»Ø</a>");
		out.flush();
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
