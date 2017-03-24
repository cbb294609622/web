package com.bb.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 从Session域对象中取出会话数据
 * @author bb
 *
 */
public class SessionDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.得到Session对象
		HttpSession session = request.getSession(false);
		
		if (session == null) {
			System.out.println("没有找到对应的Session对象");
			return;
		}
		
		/**
		 * 得到session的编号
		 */
		String id = session.getId();
		System.out.println("id = "+id);
		
		String name = (String) session.getAttribute("name");
		System.out.println("name = "+name);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
