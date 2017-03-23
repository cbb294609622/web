package com.bb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bb.bean.Product;
import com.bb.dao.ProductDao;

/**
 * 查询所有商品的servlet
 * 
 * @author bb
 * 
 */
public class ListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//解决字符流乱码
		response.setContentType("text/html;charset=UTF-8");
		
		//1.读取数据库，查询商品列表
		ProductDao dao = new ProductDao();
		List<Product> proList = dao.findAll();
		
		//2.把商品显示到浏览器
		PrintWriter writer = response.getWriter();
		String html = "";
		
		html+="<html>";
		html+="<head>";
		html+="<title>商品列表</title>";
		html+="</head>";
		html+="<body>";
		html+="<table border='1' align='center' width='70%'>";
			
		html+="<tr>";
		html+="<th>商品编号</th>";
		html+="<th>商品名称</th>";
		html+="<th>商品型号</th>";
		html+="<th>商品价格</th>";
		html+="</tr>";
		
		//遍历商品
		if (proList != null) {
			for (Product product : proList) {
				html+="<tr align='center'>";
				html+="<td>"+product.getId()+"</td>";
				html+="<td><a href='"+request.getContextPath()+"/DetailServlet?id="+product.getId()+"'>"+product.getProName()+"</a></td>";
				html+="<td>"+product.getProType()+"</td>";
				html+="<td>"+product.getPrice()+"</td>";
				html+="</tr>";
			}
		}
		html+="</table>";
		html+="<br/><br/><br/>";
		/**
		 * 显示浏览过的商品
		 */
		html+="最近浏览过的商品:<br/>";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("proHist")) {
					//商品id
					String value = cookie.getValue();
					//所有的id
					String[] ids = value.split(",");
					//遍历浏览过的商品
					for (String id : ids) {
						//根据id 查询数据库
						Product p = dao.findById(id);
						//显示到浏览器
						html+=""+p.getId()+"&nbsp"+p.getProName()+"&nbsp"+p.getProType()+"&nbsp"+p.getPrice()+"<br/>";
						
					}
				}
			}
		}
		
		
		html+="</body>";
		html+="</html>";
		
		writer.write(html);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
