package com.bb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bb.bean.Product;
import com.bb.dao.ProductDao;

/**
 * 显示商品详情
 * 
 * @author bb
 * 
 */
public class DetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		// 1.获得编号
		String id = request.getParameter("id");
		// 2.查询对应编号的商品
		ProductDao dao = new ProductDao();
		Product product = dao.findById(id);

		// 3.显示到浏览器
		PrintWriter writer = response.getWriter();
		String html = "";
		
		html+="<html>";
		html+="<head>";
		html+="<title>商品详情</title>";
		html+="</head>";
		html+="<body>";
		html+="<table border='1' align='center' width='50%'>";
		if (product != null) {
			html +="<tr align='center'>";
			html +="<th>商品编号:</th><td>"+product.getId()+"</td>";
			html +="</tr>";
			html +="<tr align='center'>";
			html +="<th>商品名称:</th><td>"+product.getProName()+"</td>";
			html +="</tr>";
			html +="<tr align='center'>";
			html +="<th>商品型号:</th><td>"+product.getProType()+"</td>";
			html +="</tr>";
			html +="<tr align='center'>";
			html +="<th>商品价格:</th><td>"+product.getPrice()+"</td>";
			html +="</tr>";
		}
		html+="</table>";
		html+="<center><a href='"+request.getContextPath()+"/ListServlet'>返回首页</a></center>";
		html+="</body>";
		html+="</html>";
		
		writer.write(html);
		
		/**
		 * 创建cookie 并发送
		 */
		//1.创建一个cookie
		Cookie cookie = new Cookie("proHist", createValue(request,id));
		cookie.setMaxAge(1*30*24*60*60);
		//2.发送cookie
		response.addCookie(cookie);
		
	}
	
	/**
	 * 生成cookie的值
	 * 分析：
	 * 			当前cookie值                     传入商品id               最终cookie值
	 *      null或没有prodHist          1                     1    （算法： 直接返回传入的id ）
	 *             1                  2                     2,1 （没有重复且小于3个。算法：直接把传入的id放最前面 ）
	 *             2,1                1                     1,2（有重复且小于3个。算法：去除重复id，把传入的id放最前面 ）
	 *             3,2,1              2                     2,3,1（有重复且3个。算法：去除重复id，把传入的id放最前面）
	 *             3,2,1              4                     4,3,2（没有重复且3个。算法：去最后的id，把传入的id放最前面）
	 * @return
	 */
	private String createValue(HttpServletRequest request, String id) {
		
		Cookie[] cookies = request.getCookies();
		String proHist = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("proHist")) {
					proHist = cookie.getValue();
					break;
				}
			}
		}
		
		
		if (cookies == null || proHist == null) {
			return id;
		}
		//String -->String[] -->Collection
		String[] ids = proHist.split(",");
		//方便判断重复ID
		Collection colls = Arrays.asList(ids);
		//Collection -->LinkedList
		LinkedList linkedList = new LinkedList(colls);
		//不超过3个
		if (linkedList.size() < 3) {
			
			if (linkedList.contains(id)) {
				//id重复
				linkedList.remove(id);
				linkedList.addFirst(id);
			}else{
				//不重复
				linkedList.addFirst(id);
			}
		}else{
			//等于3个
			
			if (linkedList.contains(id)) {
				linkedList.remove(id);
				linkedList.addFirst(id);
			}else{
				linkedList.removeLast();
				linkedList.addFirst(id);
			}
		}
		
		//LinedList ---> String
		StringBuffer sb = new StringBuffer();
		for (Object object : linkedList) {
			sb.append(object+",");
		}
		//去除多余逗号。
		String string = sb.toString();
		string = string.substring(0, string.length()-1);
		return string;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
