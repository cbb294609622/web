package com.cbb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cbb.dao.ContactDao;
import com.cbb.dao.impl.ContactDaoImpl;
/**
 * 删除联系人
 * @author bb
 *
 */
public class DeleteContactServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.接收参数
		String id = request.getParameter("id");
		//2.调用dao删除联系人的方法
		ContactDao dao = new ContactDaoImpl();
		dao.deleteContact(id);
		
		//3.回到列表
		response.sendRedirect(request.getContextPath()+"/servlet/ListContactServlet");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
