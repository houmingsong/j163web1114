package com.lovo.j163web1114.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetCookieServlet")
public class GetCookieServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�õ��������������cookies
		Cookie[] cookies = request.getCookies();
		
		if(cookies == null) {
			System.out.println("���ǵ�һ�η����ҵķ�����");
		}else {
			System.out.println("���ǵ�N�η����ҵķ�����");
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				String value = cookie.getValue();
				System.out.println(name + ": " + value);
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
