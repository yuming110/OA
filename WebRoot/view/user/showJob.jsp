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
    
    <title>My JSP 'showJob.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
		
  </head>
  	 <h3>角色管理</h3>
  	<table border="1" width="100%" bordercolor="blue" cellpadding="0">
  	
  		<tr> 
  			<td>编号</td>
  			<td>职位</td>
  			<td>状态</td>
  			<td>操作</td>
  		</tr>
  		
  		<c:forEach items="${jobList}" var="j">
  			<tr >
  				<td>${j.jobid} </td>
  				<td>${j.jobName} </td>
  				<td>
  					<c:if test="${j.status==0}">未使用</c:if>
  					<c:if test="${j.status==1}">使用</c:if>
  				</td>
  				<td>
  					<a href=".do?jobid=${j.jobid}&methodName=">角色流程</a>	
	        		<a href="peopleJob.do?jobid=${j.jobid}&methodName=peopleJob">角色人员</a>
	        		<a href="showMenuRid.do?jobid=${j.jobid}&methodName=showMenuRid">角色权限</a>
	        		<a href="showJobid.do?jobid=${j.jobid}&methodName=showJobid">修改</a>
	        		<a href="showJobIdDelect.do?methodName=showJobIdDelect&jobid=${j.jobid}">删除</a>
	        	</td>
  			</tr>
  			
  		
  		</c:forEach>
  		
  	 </table>
  <body>
  </body>
</html>
