package com.lovo.j163web1114.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lovo.j163web1114.bean.UserBean;

@WebServlet("/SessionLoginServlet")
public class SessionLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		if ("zhangsan".equals(username) && "qwe123".equals(password)) {
			UserBean userBean = new UserBean(username, password);
			HttpSession session = request.getSession();
			session.setAttribute("user", userBean);
			response.getWriter().print("<h1>µÇÂ¼³É¹¦</h1>");
			request.getRequestDispatcher("/SessionLoginSuccessServlet").forward(request, response);
		} else {
			response.sendRedirect("fail.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
