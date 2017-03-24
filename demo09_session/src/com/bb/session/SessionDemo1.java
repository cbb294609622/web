package com.bb.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 保存会话数据到Session对象
 * @author bb
 *
 */
public class SessionDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.创建Session对象
		HttpSession session = request.getSession();
		
		/**
		 * 得到session的编号
		 */
		String id = session.getId();
		System.out.println("id = "+id);
		
		/**
		 * 修改session的有效时间 
		 * 单位是:秒
		 */
		//session.setMaxInactiveInterval(20);
		
		
		//2.保存会话数据
		session.setAttribute("name", "bbc");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
