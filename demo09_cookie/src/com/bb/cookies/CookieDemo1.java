package com.bb.cookies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 第一个cookie的程序
 * @author bb
 *
 */
public class CookieDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.创建cookie对象
		Cookie cookie1 = new Cookie("name", "cbb");
		//Cookie cookie2 = new Cookie("email", "cbb@qq.com");
		
		
		/**
		 * 1.设置cookie的有效路径，默认情况:有效路径在当前的web应用下。/demo09_cookie/servlet/
		 * 多个cookie的情况下，浏览器向服务端发送cookie，
		 * 只有在有效路径下才会带上相应的cookie。
		 * 
		 */
		//cookie1.setPath("/demo09_cookie/servlet");
		cookie1.setPath("/demo09_cookie/servlet");
		
		/**
		 * 2.设置cookie的有效时间 单位是秒
		 */
		//cookie1.setMaxAge(20); //20秒后失效，最后不调用cookie开始
		cookie1.setMaxAge(-1);//cookie保存到浏览器内存中(会话cookie)，浏览器关闭cookie失效
		//cookie1.setMaxAge(0);//删除cookie
		
		
		//2.把cookie数据发送到浏览器(通过相应头发送 set-cookie名称)
		//response.setHeader("set-cookie", "name=cbb");
		response.addCookie(cookie1);
		//response.addCookie(cookie2);
		
		
		
		
		
		
		//3.接收浏览器发送的cookie信息
		//String name = request.getHeader("cookie");
		Cookie[] cookies = request.getCookies();
		//判断是否为null,否则空指针
		if (cookies != null) {
			for (Cookie c : cookies) {
				String name = c.getName();
				String value = c.getValue();

				System.out.println(name+" = "+value);
			}
		}else{
			System.out.println("没有cookie数据");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
