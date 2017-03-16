package com.bb.web.servletcontext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 得到web应用的路径
 * 
 * @author bb
 * 
 */
public class ServletContext1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. 得到servletContext对象
		// ServletContext mContext = this.getServletConfig().getServletContext();
		ServletContext mContext = this.getServletContext();
		//2. 得到web应用路径	/demo06
		/**
		 * web应用路径:部署到Tomcat服务器上运行的web应用名称
		 */
		String contextPath = mContext.getContextPath();
		System.out.println(contextPath);
		
		/**
		 * 案例:应用到请求重定向
		 * 
		 */
		response.sendRedirect(contextPath+"/index.html");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
