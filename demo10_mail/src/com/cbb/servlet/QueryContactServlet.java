package com.cbb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cbb.dao.ContactDao;
import com.cbb.dao.impl.ContactDaoImpl;
import com.cbb.entity.Contact;
/**
 * 回显数据
 * @author bb
 *
 */
public class QueryContactServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
        
		//1.接收id
		String id = request.getParameter("id");
		//2.利用ID 查询联系人信息
		ContactDao dao = new ContactDaoImpl();
		Contact contact = dao.findById(id);
		
		//3.把联系人显示到浏览器中
		PrintWriter writer = response.getWriter();
		
		String html = "";
		
		html +="<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>";
		html +="<html>";
		html +="<head>";
		html +="<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>";
		html +="<title>修改联系人</title>";
		html +="";
		html +="<!-- <link rel='stylesheet' type='text/css' href='../css/revise_mail.css'>";
		html +=" -->";
		html +=" <style type='text/css'>";
		html +="tr{";
		html +="	text-align: center;";
		html +="}";
		html +="th{";
		html +="	text-align: right;";
		html +="}";
		html +="td{";
		html +="	text-align: left;";
		html +="";
		html +="</style>";
		html +="";
		html +="</head>";
		html +="<body>";
		html +="	<form action='/demo10_mail/servlet/UpdateContactServlet' method='post'>";
		//添加id的隐藏域
		html +="<input type='hidden' name='id' value='"+contact.getId()+"'>";
		html +="		<table align='center'>";
		html +="			<caption>";
		html +="				<h3>修改联系人</h3>";
		html +="			</caption>";
		html +="			<tr>";
		html +="				<th>姓名:</th>";
		html +="				<td><input type='text' name='name' value='"+contact.getName()+"' />";
		html +="				</td>";
		html +="			</tr>";
		html +="			<tr>";
		html +="				<th>性别:</th>";
		html +="				<td>";
		if (contact.getGender().equals("男")) {
			html +="					<input type='radio' name='gender' value='男'checked='checked' />男 ";
			html +="					<input type='radio' name='gender' value='女' />女";
			
		}else {
			html +="					<input type='radio' name='gender' value='男' />男 ";
			html +="					<input type='radio' name='gender' value='女'checked='checked' />女";
			
		}
		html +="				</td>";
		html +="			</tr>";
		html +="			<tr>";
		html +="				<th>年龄:</th>";
		html +="				<td><input type='text' name='age' value='"+contact.getAge()+"' />";
		html +="				</td>";
		html +="			</tr>";
		html +="			<tr>";
		html +="				<th>电话:</th>";
		html +="				<td><input type='text' name='phone' value='"+contact.getPhone()+"' />";
		html +="				</td>";
		html +="			</tr>";
		html +="			<tr>";
		html +="				<th>邮箱:</th>";
		html +="				<td><input type='text' name='email' value='"+contact.getEmail()+"' />";
		html +="				</td>";
		html +="			</tr>";
		html +="			<tr>";
		html +="				<th>QQ:</th>";
		html +="				<td><input type='text' name='qq' value='"+contact.getQq()+"' />";
		html +="				</td>";
		html +="			</tr>";
		html +="			<tr>";
		html +="				<th></th>";
		html +="				<td><input type='submit' value='保存' />&nbsp;<input type='reset'";
		html +="					value='重置' />";
		html +="				</td>";
		html +="			</tr>";
		html +="		</table>";
		html +="	</form>";
		html +="</body>";
		html +="</html>";
		
		
		writer.write(html);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
