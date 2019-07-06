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
		 * ����Session����
		 * ע�⣺���������û��session�����Ǿ�����һ���µģ�
		 *     ������ϵ�session���󣬾͵õ�֮ǰ���Ǹ�session����
		 */
		
		HttpSession session = request.getSession();
		//��session�ֿ���ȡ����
		String username = (String)session.getAttribute("username");
		if(session.isNew()) {//�жϵõ������session�����Ƿ��������ɵ�
			out.print("��һ�η���AcceptSessioServlet - SessionID: " + session.getId() + "," + username);
		}else {
			out.print("��N�η���AcceptSessioServlet - SessionID: " + session.getId() + "," + username);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
