package com.bb.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo4 extends HttpServlet {
	
	/**
	 * 线程安全
	 * 		启发：说明servlet不是线程安全的，而且它的设计本来就是采用多线程来处理用户请求的。
	 * 		线程安全问题解决方法:
	 * 			1.使用synchronized:线程同步
	 * 			2.使用单线程 servlet类集成singleThreadModel接口
	 * 		这两种方法都不行，违背了设计意图。
	 * 	最终解决方案是 
	 * 		程序员自己注意，不要定义成员变量，尽量使用局部变量
	 * 		合理决定在servlet中定义的变量的作用域
	 * 
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int i = 1;
		i++;//配合后面四大域作用范围一起用		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("i = "+i);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
