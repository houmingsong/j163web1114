package com.lovo.j163web1114.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessioServlet")
public class SessioServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		/*
		 * 生成Session对象
		 * 注意：如果服务器没有session对象，那就生成一个新的；
		 *     如果有老的session对象，就得到之前的那个session对象
		 */
		
		HttpSession session = request.getSession();
		
		//session作为仓库保存数据
		session.setAttribute("username", "王五");
		if(session.isNew()) {//判断得到的这个session对象是否是新生成的
			out.print("第一次访问SessionServlet - SessionID: " + session.getId());
//			out.print("<a href=" + response.encodeURL("SessioServlet") + ">URL重写</a>");
			String url = response.encodeRedirectUrl("AcceptSessioServlet");
			response.sendRedirect(url);
		}else {
			out.print("第N次访问SessionServlet - SessionID: " + session.getId());
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
