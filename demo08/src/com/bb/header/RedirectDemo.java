package com.bb.header;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 重定向
 * 原理	302+location
 * 特点	客户端发出2次请求
 * 		地址栏会改变
 * 		response 域中的数据不能进行共享
 * response.sendRedirect("重定向地址"); 
 * @author bb
 *
 */
public class RedirectDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//发出2次请求
		//都是客户端发出的请求
		response.sendRedirect("/demo08/servlet/DataExpiresDemo");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
