package com.bb.cookies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookie extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 需求: 删除cookie
		 * 
		 */
		
		Cookie cookie = new Cookie("name", "1111");
		
		//删除同名并且在同一路径下的cookie
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		System.out.println("删除成功");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
