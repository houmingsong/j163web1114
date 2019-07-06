package com.lovo.j163web1114.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		String accept = request.getParameter("keep");
		if ("zhangsan".equals(username) && "qwe123".equals(password)) {
			if (accept != null) {
				Cookie usernameCookie = new Cookie("username", username);
				Cookie passwordCookie = new Cookie("password", password);
				usernameCookie.setMaxAge(60);
				passwordCookie.setMaxAge(60);
				response.addCookie(usernameCookie);
				response.addCookie(passwordCookie);
			}
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.getRequestDispatcher("/LoginSuccessServlet").forward(request, response);
		} else {
			response.sendRedirect("fail.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
