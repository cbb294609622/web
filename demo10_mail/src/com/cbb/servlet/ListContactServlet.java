package com.cbb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cbb.dao.ContactDao;
import com.cbb.dao.impl.ContactDaoImpl;
import com.cbb.entity.Contact;

/**
 * 显示所有联系人
 * 
 * @author bb
 * 
 */
public class ListContactServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		// 1.从xml中读取出联系人数据
		ContactDao dao = new ContactDaoImpl();
		List<Contact> findAll = dao.findAll();
		// 2.显示到浏览器
		

		PrintWriter writer = response.getWriter();
		String html = "";
		// 区块选择 shift + alt + A 
		//ctrl+f 替换 正则 ^(.*)$ \1";
		html += "<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>";
		html += "<html>";
		html += "<head>";
		html += "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>";
		html += "<title>通讯录</title>";
		html += "<!-- <link rel='stylesheet' type='text/css' href='../css/query_mail.css'>";
		html += " -->";
		html += " <style type='text/css'>";
		html += "	 /* 文字居中 */";
		html += "	tr{";
		html += "		text-align: center;";
		html += "	}";
		html += "	/* 合并表格的边框 */";
		html += "	table {";
		html += "		border-collapse: collapse;";
		html += "	}";
		html += " ";
		html += " </style>";
		html += " ";
		html += "</head>";
		html += "<body>";
		html += "<table align='center' border='1' width='70%'>";
		html += "	<caption><h3>通讯录</h3></caption>";
		html += "	<tr>";
		html += "		<th>编号</th>";
		html += "		<th>姓名</th>";
		html += "		<th>性别</th>";
		html += "		<th>年龄</th>";
		html += "		<th>电话</th>";
		html += "		<th>邮箱</th>";
		html += "		<th>QQ</th>";
		html += "		<th>操作</th>";
		html += "	</tr>";
		if (findAll != null) {
			for (Contact contact : findAll) {

				html += "	<tr>";
				html += "		<td>"+contact.getId()+"</td>";
				html += "		<td>"+contact.getName()+"</td>		";
				html += "		<td>"+contact.getGender()+"</td>		";
				html += "		<td>"+contact.getAge()+"</td>		";
				html += "		<td>"+contact.getPhone()+"</td>		";
				html += "		<td>"+contact.getEmail()+"</td>		";
				html += "		<td>"+contact.getQq()+"</td>";
				html += "		<td><a href='"+request.getContextPath()+"/servlet/QueryContactServlet?id="+contact.getId()+"'>修改</a> &nbsp;<a href='"+request.getContextPath()+"/servlet/DeleteContactServlet?id="+contact.getId()+"'>删除</a></td>";
				html += "	</tr>";
			}
		}
		html += "	<tr>";
		html += "		<td colspan='8'><a href='"+request.getContextPath()+"/html/add_mail.html'>[添加联系人]</a></td>";
		html += "	</tr>";
		html += "</table>";
		html += "</body>";
		html += "</html>";

		writer.write(html);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
