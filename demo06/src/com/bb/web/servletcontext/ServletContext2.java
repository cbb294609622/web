package com.bb.web.servletcontext;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 得到web应用参数
 * 
 * 全局的参数使用
 * @author bb
 *
 */
public class ServletContext2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//得到servletContext对象
		ServletContext context = this.getServletContext();
		
		String oneAttr = context.getInitParameter("AAA");
		System.out.println(oneAttr);
		
		Enumeration<String> names = context.getInitParameterNames();
		while (names.hasMoreElements()) {
			String parmName = names.nextElement();
			String parmValue = context.getInitParameter(parmName);
			System.out.println(parmName+" == "+parmValue);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
