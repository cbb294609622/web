package com.bb.web.g_forword;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 重定向
 * @author bb
 *
 */
public class RedirectDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 保存数据到request对象
		 */
		request.setAttribute("name", "values");
		
		
		String path = this.getServletContext().getContextPath();
		response.sendRedirect(path+"/servlet/GetDataServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}
/**
 * 1.转发
 * 		地址栏不会发生变化
 * 		不能转发当前web应用以外的资源
 * 		request作用域数据可以获取到
 * 		
 * 2.重定向
 * 		地址栏会改变，变成重定向到的地址
 * 		路径可以是web应用以内或者以外的资源
 * 		request目标资源不能拿到数据
 * 		
 * 
 * 如果要使用request进行数据共享，只能用转发，不能使用重定向，如果是ServletContext是没有限制的
 * 
 */
}

