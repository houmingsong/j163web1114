package com.lovo.j163web1114.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AcceptSessioServlet")
public class AcceptSessioServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		/*
		 * 生成Session对象
		 * 注意：如果服务器没有session对象，那就生成一个新的；
		 *     如果有老的session对象，就得到之前的那个session对象
		 */
		
		HttpSession session = request.getSession();
		//从session仓库里取数据
		String username = (String)session.getAttribute("username");
		if(session.isNew()) {//判断得到的这个session对象是否是新生成的
			out.print("第一次访问AcceptSessioServlet - SessionID: " + session.getId() + "," + username);
		}else {
			out.print("第N次访问AcceptSessioServlet - SessionID: " + session.getId() + "," + username);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
