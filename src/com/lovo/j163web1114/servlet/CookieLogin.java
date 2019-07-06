package com.lovo.j163web1114.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieLogin")
public class CookieLogin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if ("check".equals(action)) {
			String name = request.getParameter("user");
			String pwd = request.getParameter("password");
			if (name != null && pwd != null) {
				if (name.equals("tiger") && pwd.equals("123")) {
					StringBuffer sb = new StringBuffer();
					sb.append("username=").append(name).append("&password=").append(pwd);
					Cookie cookie = new Cookie("userinfo", sb.toString());
					cookie.setMaxAge(1800);
					response.addCookie(cookie);
					// ʹ���ض��������������������ɵ�Cookie���͵�������
					response.sendRedirect("GreetServlet");
					return;
				} else {
					out.println("�û��������������<a href=CookieLogin>���µ�½</a>");
					return;
				}
			}
		} else {
			out.println("<html><head><title>��������½</title></head>");
			out.println("<body>");
			out.print("<p>��������½</p>");
			out.println("<form method=post action=CookieLogin?action=check>");
			out.println("<table>");
			out.println("<tr><td>�������û�����</td><td><input type=text name=user></td></tr>");
			out.println("<tr><td>���������룺</td><td><input type=password name=password></td></tr>");
			out.println("<tr><td><input type=submit value=��½></td><td><input type=reset value=����></td></tr>");
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
