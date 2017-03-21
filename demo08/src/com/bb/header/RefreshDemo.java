package com.bb.header;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Refresh：响应头，实现刷新效果 单位是 秒
 * 
 * 本页刷新
 * response.setHeader("Refresh", "2");	
 * 
 * 
 * 总结:
 * 		各种URL的写法
 * 		1.给服务器用的，不需要写应用名
 * 			getServletContext().getRealPath();
 * 			getServletContext().getRequestDispather();
 * 			
 * 		2.给浏览器用的，需要些应用名
 * 			URL 
 * 			<a href="">	
 * 			Location
 * 			<image src="">
 * 			<link href="">
 * 			<script src="">	
 * 
 * 
 * @author bb
 *
 */
public class RefreshDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//字符流乱码解决
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().write("幸运号码:"+new Random().nextInt());
		//response.setHeader("Refresh", "2");	本页刷新
		//刷新到新页面
		response.setHeader("Refresh", "2;URL=/demo08/index.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
