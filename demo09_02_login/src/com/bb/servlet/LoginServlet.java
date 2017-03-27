package com.bb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1.接收参数
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		
		//2.判断逻辑
		if ("cbb".equals(userName) && "111111".equals(passWord)) {
			//登录成功
			//request.setAttribute("loginName", userName);
			//request.getRequestDispatcher("/servlet/IndexServlet").forward(request, response);
			
			
			/**
			 * 把用户数据保存在session对象中
			 */
			//1.创建Session对象
			HttpSession session = request.getSession();
			//2.把数据保存到session域中
			session.setAttribute("loginName",userName);
			//3.跳转到用户主页
			response.sendRedirect(request.getContextPath()+"/servlet/IndexServlet");
			
			
		}else{
			//登录失败
			//重定向
			response.sendRedirect(request.getContextPath()+"/fail.html");
			
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		
	}

}
