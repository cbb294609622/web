package com.bb.servlet;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.bb.bean.User;

/**
 * 用于接收来自login.html发过来的请求数据
 * 
 * @author bb username password password
 * 
 *         并封装到对象
 */
public class UserRegistServlet01 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// test1(request);
		// test2(request);
		// test3(request);
		// test4(request);
		test5(request);
	}
	/**
	 * 开发中使用
	 * @param request
	 */
	private void test5(HttpServletRequest request) {
		// 封装前
		User user = new User();
		System.out.println("封装前000:" + user.toString());
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 封装后
		System.out.println("封装后111:" + user.toString());
	}
	
	
	/**
	 * 开发中用的少
	 * @param request
	 */
	private void test4(HttpServletRequest request) {
		// 封装前
		User user = new User();
		System.out.println("封装前00:" + user.toString());
		//key是参数名   value是参数值
		Map<String,Object[]> maps = request.getParameterMap();
		for(Map.Entry<String, Object[]> entry : maps.entrySet()){
			//参数名
			String key = entry.getKey();
			//取值
			Object[] objs = entry.getValue();
			//引入BeanUtils进行数据封装
			try {
				BeanUtils.setProperty(user, key, objs);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 封装后
		System.out.println("封装后11:" + user.toString());
	}
	
	
	private void test3(HttpServletRequest request) {
		// 封装前
		User user = new User();
		System.out.println("封装前00:" + user.toString());

		//服务器接收客户端发送过来的请求数据 
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			//取出其中一个参数名
			String name = parameterNames.nextElement();
			//得到这个参数所对应的的一组值
			String[] values = request.getParameterValues(name);
			
			//封装到对象user中，此时的name一定要与User中的字段保持一致
			//内省
			try {
				//属性描述器	第一个参数是指哪个属性，第二个参数是指哪个class
				PropertyDescriptor pd = new PropertyDescriptor(name, user.getClass());
				//通过属性描述器，得到setter方法
				Method method = pd.getWriteMethod();
				
				if (values != null && values.length>1) {
					//参考反射Main方法
					method.invoke(user,(Object)values);
				}else{
					//只有一个参数，不要包装
					method.invoke(user,values[0]);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}

		// 封装后
		System.out.println("封装后11:" + user.toString());
	}

	
	
	
	/**
	 * 开发中 不会用这种方式
	 * @param request
	 */
	private void test2(HttpServletRequest request) {
		// 封装前
		User user = new User();
		System.out.println("封装前0:" + user.toString());

		//服务器接收客户端发送过来的请求数据 
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			//取出其中一个参数名
			String name = parameterNames.nextElement();
			//得到这个参数所对应的的一组值
			String[] values = request.getParameterValues(name);
			
			//封装到对象user中，此时的name一定要与User中的字段保持一致
			Class clzz = user.getClass();
			try {
				//用反射得到user对象的一个name的属性
				//得到了一个私有的属性
				Field f = clzz.getDeclaredField(name);
				//暴力反射 这样就可以使得一个私有属性，在另一个类中可以被使用
				f.setAccessible(true);
				if (values != null && values.length>1) {
					//参考反射Main方法
					f.set(user, (Object)values);	
				}else{
					//只有一个参数，不要包装
					f.set(user, values[0]);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		// 封装后
		System.out.println("封装后1:" + user.toString());
	}

	/**
	 * 封装数据，手动封装
	 * 
	 * @param request
	 */
	private void test1(HttpServletRequest request) {
		// 1.服务器接收客户端发送过来的请求数据
		String username = request.getParameter("username");// 得到一个值

		String[] pwds = request.getParameterValues("password");// 得到一组值

		// 封装前
		User user = new User();
		System.out.println("封装前:" + user.toString());

		// 封装中
		user.setUsername(username);
		user.setPassword(pwds);

		// 封装后
		System.out.println("封装后:" + user.toString());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
