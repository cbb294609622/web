package com.bb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 安全退出
 * @author bb
 *
 */
public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 退出逻辑
		 * 
		 * 		删除掉session对象中loginName的属性
		 */
		//1.得到Session对象
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			//2.删除属性
			session.removeAttribute("loginName");
		}
		//3.回到登录页面
		response.sendRedirect(request.getContextPath()+"/login.html");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
