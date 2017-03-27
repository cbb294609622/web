package com.bb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 用户主页逻辑
 * @author bb
 *
 */
public class IndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		
		String html = "";
		
		/**
		 * 接收
		 */
		//Object obj = request.getAttribute("loginName");
		
		/**
		 * 从session域中获取数据
		 */
		HttpSession session = request.getSession(false);
		if (session == null) {
			//没有登录成功。跳转到登录页面
			response.sendRedirect(request.getContextPath()+"/login.html");
			return;
		}
		//取出会话数据
		String name = (String)session.getAttribute("loginName");
		if (name == null) {
			//没有登录成功。跳转到登录页面
			response.sendRedirect(request.getContextPath()+"/login.html");
			return;	
		}
		
		html += "<html><head><title>首页</title></head><body>欢迎回来，"+name+",<a href='"+request.getContextPath()+"/servlet/LogoutServlet'>安全退出</a></body></html>";
		
		
		
		
		writer.write(html);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
