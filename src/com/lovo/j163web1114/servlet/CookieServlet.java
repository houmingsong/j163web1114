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
		//����Cookie��Ϣ
		Cookie usernameCookie = new Cookie("username", "����");
		Cookie testCookie = new Cookie("test", "����");
		
		//����cookie����Ч��,��λ����
		
		testCookie.setMaxAge(30);
//		usernameCookie.setMaxAge(60);
		
		//���Cookie��HTTP��Ӧ����
		response.addCookie(usernameCookie);
		response.addCookie(testCookie);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
