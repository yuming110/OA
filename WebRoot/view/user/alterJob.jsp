<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'alterJob.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
      <form action="alterJob.do?methodName=alterJob&jobid=${job.jobid}" method="post" >
  	  	  <p>角色:<b>${job.jobName}</b>  修改角色用户：</p>
  	  	  <table>
  	  	  	  <c:forEach items="${uList}" var="u">
  	  	  	  	   <input type="checkbox" name="ujid" value="${u[0]}"  <c:if test="${u[2]==1}">checked</c:if> />${u[1]}<br/>
  	  	  	  </c:forEach>
  	  	  </table> 
  	  	  <input type="submit" value="确认修改" />
  	  </form>
  </body>
</html>
