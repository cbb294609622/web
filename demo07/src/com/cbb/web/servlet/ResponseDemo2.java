package com.cbb.web.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 用于实现服务端向客户端输出字节流，改变默认输出的编码。
 * 采用UTF-8编码输出
 * @author bb
 *
 */
public class ResponseDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.定义字符串
		String str= "111111111111111111王二狗11111122222222222222";
		//为了使用UTF-8输出数据时，没有乱码问题，可以采用在response对象中加入响应消息头
		//response.setHeader("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");//解决服务器控制浏览器显示数据的采用什么编码最好的方法，
		//2.得到用户输出字节流的对象。
		OutputStream os = response.getOutputStream();	
		
		//3.输出字节
		os.write(str.getBytes("UTF-8"));
		
		
		
		//os.write("<meta http-equiv='Content-Type' content='text/html;charset=UTF-8'/>".getBytes());
		//4.流关闭
		//os.close();//没有必要写 因为servlet引擎会自动关闭。			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
