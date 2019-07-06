package com.lovo.j163web1114.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ���������������ʽ
		/**
		 * �������ⳣ���ֵĵط��ǣ�
		 *  1.ҳ������� 
		 *  2.����������� 
		 *  3.��Ӧʱ���������
		 *  4.���ݿ��������
		 */
		req.setCharacterEncoding("utf-8");

		String username = req.getParameter("username");
		String password = req.getParameter("pwd");

		if ("zhangsan".equals(username) && "qwe123".equals(password)) {
			Cookie userNameCookie = new Cookie("username", username);
			Cookie passwordCookie = new Cookie("password", password);
			
			resp.addCookie(userNameCookie);
			resp.addCookie(passwordCookie);
			
			req.setAttribute("username", username);
			
			req.getRequestDispatcher("/LoginSuccessServlet").forward(req, resp);
		} else {
			resp.sendRedirect("fail.html");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
