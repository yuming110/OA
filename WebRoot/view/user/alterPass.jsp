<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'profile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		#ff{
			position: relative; left:40%;
	       	position: absolute; top:25%;
	       	background-color:blue;	
		}
		.mm{
			float:right;
		}
	
	</style>
  </head>
  
  <body>
  	    <form action="alterPass.do?methodName=alterPass&${loginUser.uName}" method="post" id="ff">
  	    	<table id="tb">
  	    		 <tr>
	    		 	<td class="mm">旧密码：</td>
	    		 	<td><input type="password" name="userPass" placeholder="请输入旧密码" id="up" class="a" /></td>
  	    		 </tr>
  	    		 <tr>
	    		 	<td class="mm">新密码：</td>
	    		 	<td><input type="password" name="newUserPass" placeholder="请输入新密码" id="up" class="a"  /></td>
					<td><span id="userPassError" class="mgError"></span></td>
  	    		 </tr>
  	    		 <tr>
	    		 	<td class="mm">确认新密码：</td>
	    		 	<td><input type="password" name="newTowUserPass" placeholder="请再次输入新密码" id="up" class="a" /></td>
					<td><span id="userPassError" class="mgError"></span></td>
  	    		 </tr>
  	    		 <tr>
	  	    		 <td>
	  	    		 	<input type="submit" value="确认修改密码 " maxlength="6" style="size: 60px;" class="sb"/>
	  	    		 </td>
  	    		 </tr>
  	    	</table>
  	    </form>
  </body>
</html>
