package com.cbb.web.servletimg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 用于实现带有中文 文件名的文件下载
 * @author bb
 *
 */
public class DownLoadServletDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.得到文件的绝对路径
		String absolutePath = getServletContext().getRealPath("/WEB-INF/classes/攻略.jpg");
		//2.得到文件所对应的流 输入流
		InputStream is = new FileInputStream(absolutePath);
		//3.设置响应消息头
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("攻略.jpg", "UTF-8"));
		//4.得到一个像浏览器输出数据的输出流
		OutputStream os = response.getOutputStream();
		//5.边度编写
		int len = -1;
		byte[] buffer = new byte[1024];
		while ((len = is.read(buffer)) != -1) {
			os.write(buffer,0,len);
		}
		//6.关闭流
		is.close();
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
