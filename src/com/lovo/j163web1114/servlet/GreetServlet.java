package com.lovo.j163web1114.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GreetServlet")
public class GreetServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		if (null != cookies && cookies.length != 0) {
			String name = null;
			String pwd = null;
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				String cookieName = cookie.getName();
				if (cookieName.equals("userinfo")) {
					String cookieValue = cookie.getValue();
					String[] userInfo = cookieValue.split("&");
					for (int j = 0; j < userInfo.length; j++) {
						String[] value = userInfo[j].split("=");
						if (value[0].equals("username")) {
							name = value[1];
						}
						if (value[0].equals("password")) {
							pwd = value[1];
						}
					}
				}
			}
			if ("tiger".equals(name) && "123".equals(pwd)) {
				out.println("<html><head><title>»¶Ó­Ò³Ãæ</title></head>");
				out.println("<body>" + name + ",»¶Ó­Äú");
				out.println("<a href=CookieLogin>ÖØÐÂµÇÂ½</a></body></html>");
				out.close();
				return;
			}
		}
		request.getRequestDispatcher("/CookieLogin").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
