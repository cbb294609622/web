package com.bb.web.servletconfig;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigDemo extends HttpServlet {
	
	//private ServletConfig config;
	
	/**
	 * 初始化参数 参数会加载web应用的时候，
	 * 保存到servlet内部的servletConfig对象中
	 * 
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/**
		 * 怎么读取servlet的参数
		 * 
		 * 
		 */
		
		
		String path = this.getServletConfig().getInitParameter("path");
		
		File file = new File(path);
		
		//读取内容
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str = null;
		while((str = br.readLine()) != null){
			System.out.println(str);
		}
		
		//查找当前servlet中所有的初始化参数
		Enumeration<String> enums =  this.getServletConfig().getInitParameterNames();
		while (enums.hasMoreElements()) {
			String string = enums.nextElement();
			String valueString = this.getServletConfig().getInitParameter(string);
			System.out.println(string +"=="+ valueString);
		}
		
		String servletName = this.getServletConfig().getServletName();
		System.out.println(servletName);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
