package com.bb.web.g_forword;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 转发(效果:跳转页面)
 * @author bb
 *
 */
public class ForwordDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		
		/**
		 * 保存数据到requrest对象
		 */
		request.setAttribute("name", "values");
		
		
		//转发
		RequestDispatcher dispatcher = context.getRequestDispatcher("/servlet/GetDataServlet");
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
