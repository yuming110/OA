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
    
    <title>My JSP 'easyui2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		function add(title,url){
			$('#s').tabs('add',{
				title: title,
				selected: true,
				closable: true,
				content : "<iframe width='100%' height='100%'  frameborder='0' scrolling='auto' src='"+url+"'></iframe>"
			});
			
		}
	</script>
	<style type="text/css">
		h1{
			font-size: 100px;
			text-align:center;	
			padding-top: 100px;
		}
	</style>

  </head>
  
  <body class="easyui-layout">
      <div data-options="region:'north',title:'North Title',split:true" style="height:100px;">
      	  <div id="up">
		      <p style="color: red; float:right; margin-right: 15px; font-size: 15px">${loginUser.uName}</p>
		  </div>
      </div>   
      <div data-options="region:'west',title:'菜单',split:true" style="width:300px;">
		  <div id="aa" class="easyui-accordion" style="width:300px;" data-options="fit:true">   
		     <c:forEach items="${menuList}" var="m2">
			     <c:if test="${m2.level==2}">  
			         <div title="${m2.mName}" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">   
			            <ul id="tt" class="easyui-tree" >   
							<c:forEach items="${menuList}" var="m3">
								<c:if test="${m3.parentid==m2.menuid}">
									<li><a href="javascript:void(0);" onclick="add('${m3.mName}','${m3.url}');" >${m3.mName}</a></li>
								</c:if>
							</c:forEach>
						</ul>
					</div> 
			    </c:if>
		    </c:forEach>   
		</div>
      </div>   
      <div data-options="region:'center'" style="padding:5px;background:#eee;">
      	  <div id="s" class="easyui-tabs" style="width:500px;" data-options="fit:true" >   
		      <div title="欢迎访问" style="padding:20px;" >   
		        	    
		      </div>   
		  </div> 
      </div>   
  </body>
</html>
