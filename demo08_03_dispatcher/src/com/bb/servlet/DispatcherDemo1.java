package com.bb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 转发 包含
 * @author bb
 *
 */
public class DispatcherDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ServletContext().getRequestDispatcher("");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("Demo1");
		
		/**
		 * 转发
		 * 
		 * 得到一个转发器	
		 * 可以写相对路径	DispatcherDemo2
		 * 也可以写绝对路径	/servlet/DispatcherDemo2
		 * 
		 * 	RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet/DispatcherDemo2");
		 *	dispatcher.forward(request, response);
		 * 
		 */
		
		/**
		 * 包含
		 * 
		 * 在实现包含时，会先将被包含进来的页面中的头信息清空。
		 * 
		 * 	RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet/DispatcherDemo2");
		 *	dispatcher.include(request, response);
		 */
		/*System.out.println("Demo1 before");
		response.getWriter().write("Demo1 before");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet/DispatcherDemo2");
		dispatcher.forward(request, response);
		System.out.println("Demo1 after");
		response.getWriter().write("Demo1 after");*/
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
