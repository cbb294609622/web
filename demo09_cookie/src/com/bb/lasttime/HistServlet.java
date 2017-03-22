package com.bb.lasttime;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 案例:用户上次访问的时间
 * @author bb
 *
 */
public class HistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String curTimes = showDate();
		response.setContentType("text/html;charset=UTF-8");
		
		//取得cookie
		Cookie[] cookies = request.getCookies();
		String lastTime = null;
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("lastTime")) {
					//有这个cookie 第N次访问
					lastTime = c.getValue();
					//1.把上次访问的时间 进行回显
					response.getWriter().write("欢迎回来，上次访问时间是:"+lastTime+"<br/> 当前时间:"+curTimes);
					//2.把当前时间更新到cookie中
					c.setValue(curTimes);
					//3.设置时长
					c.setMaxAge(1*30*24*60*60);
					//4.把更新后的cookie发送到浏览器
					response.addCookie(c);
					break;
				}
			}
		}
		
		/**
		 * 第一次访问(没有cookie 或者 有cookie 但是没有lasttime的cookie)
		 */
		if (cookies == null || lastTime == null) {
			//1.显示当前时间到浏览器
			response.getWriter().write("首次访问本网站,当前时间:"+curTimes);
			//2.创建cookie对象
			Cookie cookie = new Cookie("lastTime", curTimes);
			cookie.setMaxAge(1*30*24*60*60);//保存一个月
			//3.把cookie发送到浏览器保存
			response.addCookie(cookie);
			
		}
		
	}

	private String showDate() {
		// 获取当前系统时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String curTime = format.format(new Date());
		
		return curTime;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
