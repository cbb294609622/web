package com.cbb.web.servlet;
/**
 * 用字符流输出数据
 * response.getWriter();
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponsePrintWriteDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//控制服务器向浏览器输出字符数据时用什么编码
		//response.setCharacterEncoding("UTF-8");
		//控制浏览器显示的编码格式
		response.setContentType("text/html;charset=UTF-8");
		//1.得到用于输出字符流的对象
		PrintWriter writer = response.getWriter();
		
		//2.输出一些字符,默认情况下字符流采用的是ISO-8859-1来输出。
		//对外输出字符数据时，进行控制编码格式
		
		writer.write("pppa12王二addad");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
