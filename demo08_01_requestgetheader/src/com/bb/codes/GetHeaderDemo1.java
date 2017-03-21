package com.bb.codes;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 获取请求消息头
 * @author bb
 *
 */
public class GetHeaderDemo1 extends HttpServlet {

	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取一个请求头所对应的的值
		//testGetHeader(request);
		
		//2.获取一个请求头对应的一组值
		//testGetHeaders(request);
		
		//3.获取所有的请求消息头
		testGetHeaderNames(request);
		
		
	}
	
	/**
	 * 获取所有的请求消息头
	 * @param request
	 */
	private void testGetHeaderNames(HttpServletRequest request) {
		//得到的是客户端支持的数据压缩方式，
		//是一组值
		Enumeration<String> clients = request.getHeaderNames();
		while (clients.hasMoreElements()) {
			//请求头
			String headerValue = clients.nextElement();
			//请求头的值
			String value = request.getHeader(headerValue);
			System.out.println(headerValue+" : "+value);
		}
	}
	
	
	/**
	 * 获取一个请求头对应的一组值
	 * @param request
	 */
	private void testGetHeaders(HttpServletRequest request) {
		//得到的是客户端支持的数据压缩方式，
		//是一组值
		
		Enumeration<String> client = request.getHeaders("Accept-Encoding");
		while (client.hasMoreElements()) {
			int i = 0;
			String headerValue = (String) client.nextElement();
			System.out.println((i++)+"："+headerValue);
		}
	}
	
	
	/**
	 * 获取一个请求头对应的值
	 * @param request
	 */
	private void testGetHeader(HttpServletRequest request) {
		
		String client = request.getHeader("Accept-Encoding");//得到的是客户端支持的数据压缩方式，Accept-Encoding：gzip;deflate
		if (client.contains("gzip")) {
			System.out.println("支持Gzip压缩:"+client);
		}else{
			System.out.println("不支持Gzip压缩");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
