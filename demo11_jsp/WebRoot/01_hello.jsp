<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>My JSP '01_hello.jsp' starting page</title>
  </head>
  
  <body>
    <%
    	//写java代码
    	//获取当前世界
    	
    	SimpleDateFormat sdf = new SimpleDateFormat();
    	String curDate = sdf.format(new Date());
     	//输出到浏览器
     	out.write("当前时间为2:"+curDate);
     	
     %>
  </body>
</html>
