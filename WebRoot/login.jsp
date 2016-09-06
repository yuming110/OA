<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en" class="no-js">
  <head>
    <base href="<%=basePath%>">
    
    <title>OA系统登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- CSS -->
        <link rel="stylesheet" href="<%=basePath%>assets/css/reset.css">
        <link rel="stylesheet" href="<%=basePath%>assets/css/supersized.css">
        <link rel="stylesheet" href="<%=basePath%>assets/css/style.css">
        
        
  </head>
  
  <body>
  	   <div class="page-container">
            <h1>OA系统登录</h1>
            <form action="login.do" method="post">
            	<input type="hidden" name="methodName" value="login" />
                <input type="text" name="userName" class="username" placeholder="用户名">
                <input type="password" name="userPass" class="password" placeholder="密码">
                   ${loginError} 
                <button type="submit">登录</button>
                <div class="error"><span>+</span></div>
                
            </form>
             
             
        </div>
         <!-- Javascript -->
        <script src="<%=basePath%>assets/js/jquery-1.8.2.min.js"></script>
        <script src="<%=basePath%>assets/js/supersized.3.2.7.min.js"></script>
        <script src="<%=basePath%>assets/js/supersized-init.js"></script>
        <script src="<%=basePath%>assets/js/scripts.js"></script>
        
  </body>
</html>
