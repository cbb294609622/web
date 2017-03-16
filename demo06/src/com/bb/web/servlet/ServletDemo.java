package com.bb.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo extends HttpServlet {


	public ServletDemo() {
		System.out.println("实例化了");
	}


	public void init() throws ServletException {
		System.out.println("ServletDemo 初始化了");
	}

	public void destroy() {
		System.out.println("ServletDemo 销毁了");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("我对外服务了");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	/**
	 * 不要重写service方法。内部进行了get 和 post 请求判断。
	 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Service方法被调用了");
	}
	*/
}
