package com.lovo.j163web1114.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lovo.j163web1114.bean.UserBean;

@WebServlet("/SessionLoginSuccessServlet")
public class SessionLoginSuccessServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if("logout".equals(action)) {
			session.invalidate();//马上销毁session对象
			response.sendRedirect("SessionLoginSuccessServlet");
			return;
		}
		UserBean userBean = (UserBean) session.getAttribute("user");
		if (userBean != null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("<h1>" + userBean.getUssername() + "登陆成功!<a href='SessionLoginSuccessServlet?action=logout'注销登录></a> </h1>");
		} else {
			response.sendRedirect("fail.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
