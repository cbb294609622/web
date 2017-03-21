package com.bb.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 用于接收来自login.html发过来的请求数据
 * @author bb
 *	username
 *	password
 *	password
 *	
 *
 */
public class UserRegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.服务器接收客户端发送过来的请求数据
		String username = request.getParameter("username");//得到一个值
		
		String[] pwds = request.getParameterValues("password");//得到一组值
		
		//2.输出
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().write("用户名:"+username+"<br/> 密码:"+Arrays.toString(pwds));
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
