package com.lovo.j163web1114.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//生成Cookie信息
		Cookie usernameCookie = new Cookie("username", "张三");
		Cookie testCookie = new Cookie("test", "李四");
		
		//设置cookie的有效期,单位：秒
		
		testCookie.setMaxAge(30);
//		usernameCookie.setMaxAge(60);
		
		//添加Cookie到HTTP响应里面
		response.addCookie(usernameCookie);
		response.addCookie(testCookie);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
