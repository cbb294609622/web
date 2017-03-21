package com.bb.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 用于获取客户端的基本信息
 * @author bb
 *
 */
public class RequestBasicMethodsDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//得到客户端的IP
		String clientIP = request.getRemoteAddr();
		System.out.println("IP ："+clientIP);
		
		//得到客户端所请求的资源地址	只包含资源地址
		String clientURI = request.getRequestURI();
		System.out.println("URI ："+clientURI);
		
		//获取客户端请求的地址	协议+主机地址+端口号+资源地址
		String clientURL = request.getRequestURL().toString();
		System.out.println("URL ："+clientURL);
		
		//有可能应用名与工程名不同
		String contextPath = request.getContextPath();
		System.out.println("path ："+clientURL);
		
		//得到客户端请求时，所使用的的端口号
		int remotePort = request.getRemotePort();
		System.out.println("port ："+remotePort);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
