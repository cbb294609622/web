package com.bb.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.bb.bean.User;

/**
 * 接收用户注册信息并能封装，可以解决乱码
 * 
 * 客户端发过来的请求数据的方式:默认是Get提交 Get Post 服务器端处理乱码要分两种情况: Post乱码处理
 * request.setCharacterEncoding("UTF-8"); Get乱码处理 用Get请求向服务器发送数据默认采用的是ISO-8859-1
 * 
 * 
 * 
 * 
 * @author bb
 * 
 */
public class UserRegisterServlet02 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.设置服务器接收Post请求发过来的数据编码
		request.setCharacterEncoding("UTF-8");
		// 2.封装数据	
		User user = new User();
		String username = request.getParameter("username");
		
		// 3.处理乱码
			//3.1.还原ISO-8895-1
			byte[] encode = username.getBytes("ISO-8859-1");
			//3.2.利用UTF-8编码进行重构
			username = new String(encode,"UTF-8");
			
			
		System.out.println(username);
		
		// 2.封装数据
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 3.输出数据
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("GET<br/>");
		response.getWriter().write(username);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.设置服务器接收Post请求发过来的数据编码
		// 只能处理Post提交数据时的乱码问题。
		request.setCharacterEncoding("UTF-8");
		User user = new User();
		// 2.封装数据
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 3.输出数据
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(user.toString());

	}

}
