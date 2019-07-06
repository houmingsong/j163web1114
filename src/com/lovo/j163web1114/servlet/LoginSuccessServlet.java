package com.lovo.j163web1114.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.PasswordAuthentication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginSuccessServlet")
public class LoginSuccessServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String)request.getAttribute("username");
		String password = (String)request.getAttribute("password");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		if(username != null && username.length() != 0) {
			out.println("<h1>" + username + " 登陆成功</h1>");
			return ;
		}
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies == null) {
			response.sendRedirect("login.html");
			return;
		}else {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();//取得键的值
				String value = cookie.getValue();//取得值
				
				if("username".equals(name)) {
					username = value;
				}
				if("password".equals(name)) {
					password = value;
				}
			}
		}
		if("zhangsan".equals(username) && "qwe123".equals(password)) {
			out.print("<h1>" + username + "登陆成功</h1>");
		}else {
			response.sendRedirect("fail.html");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
