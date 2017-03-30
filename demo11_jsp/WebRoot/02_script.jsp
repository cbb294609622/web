<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>Jsp的语法</title>
  </head>
  
  <body>
	<!-- jsp表达式 -->
	<%
		//声明一个变量
		String name = "eric";
		int a = 10;
		int b = 5;
	 %>
	<%=name %>
	<br/>
	<%=(a+b) %>
	<br/>
	<!-- jsp脚本 -->
	<%
		//生成一个随机数
		Random ram = new Random();
		float num = ram.nextFloat();
		
	 %>
	 随机数:<%=num %>
	 
	 <hr/>
	 <!-- 穿插html代码 -->
	 <%
	 	for(int i = 1 ; i<=6;i++){
	 
	  %>
		
	 <h<%=i %>>标题<%=i %></h<%=i %>>
	 <%
	 }
	  %>
	 <!-- 联系：使用脚本和html代码显示99乘法表 -->
	 <hr/>
	 <%
	 	for(int i = 1;i<= 9;i++){//行
	 		for(int j=1;j<=i;j++){//列
	 %>
	 <% 
	 	
	 
	 %>			
	 	<%=i %> x <%=j %> = <%=(i*j) %>&nbsp;
	 <%			
	 		}
	 	%>
	 	<br/>
	 <%	
	 	}
	 
	  %>
	  
	  <%
	  	String  age = "20";
	   %>
	  
	  <hr/>
	  <!-- Jsp声明 -->
	  <%!
	  	//变量
	  	String name = "petey";
	  	
	  	public String getName(){
	  		return name;	
	  	}
	  	
	   %>
	  <!-- 注释 -->
	  <jsp:forward page="/01_hello.jsp"></jsp:forward>
	  <%-- 哇咔咔  --%>
	  
  </body>
</html>
