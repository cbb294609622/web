package com.cbb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cbb.dao.ContactDao;
import com.cbb.dao.impl.ContactDaoImpl;
import com.cbb.entity.Contact;
/**
 * 修改 数据
 * @author bb
 *
 */
public class UpdateContactServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		//1.接收参数
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String qq = request.getParameter("qq");
		
		String id = request.getParameter("id");
		
		
		//封装成Contact对象
		Contact contact = new Contact();
		contact.setId(id);
		contact.setName(name);
		contact.setGender(gender);
		contact.setAge(Integer.parseInt(age));
		contact.setPhone(phone);
		contact.setEmail(email);
		contact.setQq(qq);
		
		
		
		
		
		//2.调用Dao修改联系人的方法
		ContactDao dao = new ContactDaoImpl();
		dao.updateContact(contact);
		
		//3.跳转到列表
		response.sendRedirect(request.getContextPath()+"/servlet/ListContactServlet");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
