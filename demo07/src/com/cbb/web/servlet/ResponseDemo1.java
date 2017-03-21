package com.cbb.web.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 用于实现服务器向客户端输出字节流
 * @author bb
 *
 */
public class ResponseDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.定义字符串
		//关于中文乱码的问题。
			//因为字节流在输出中文时，默认采用的是本地编码输出，而本地编码是gbk，浏览器默认也是采用gbk显示，所以不会乱码。
			//两者编码一致不会出现乱码。
		String str= "111111111111111111王二狗11111122222222222222";
		//2.得到用户输出字节流的对象。
		OutputStream os = response.getOutputStream();	
		//3.输出字节
		os.write(str.getBytes());
		//4.流关闭
		//os.close();//没有必要写 因为servlet引擎会自动关闭。
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
