package com.bb.web.servletcontext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取数据
 * @author bb
 *
 */
public class ServletContext4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1拿到域对象
		ServletContext servletContext = this.getServletContext();
		//2获取数据
		//String attribute = (String) servletContext.getAttribute("name");
		Student stu = (Student) servletContext.getAttribute("student");
		
		System.out.println(stu);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
