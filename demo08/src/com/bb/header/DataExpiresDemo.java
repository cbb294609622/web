package com.bb.header;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 设置过期时间
 * @author bb
 *
 */
public class DataExpiresDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//缓存一小时
		response.setDateHeader("Expires", System.currentTimeMillis()+60*60*1000);
		response.getWriter().write("expires	1 hour");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
