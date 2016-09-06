<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//List<Object[]> list =(List<Object[]>)request.getAttribute("useLise");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
		$(function(){
			
			$('#dg').datagrid({
					url:'showUserVo.do?methodName=showUserVo&pageNo=1&pageSize=10',
					forzenColumns:[[{field:'fd',chevkbox:true}]],
					rownumbers:true,
		     		striped:true,
		            pagination:true,
		            columns:[[
			            {field:'uid',hidden:true},
			            {field:'userName',title:'登录账户',width:100,alige:'center'},
			            {field:'userPass',title:'登录密码',width:100,alige:'center'},
			            {field:'uName',title:'用户姓名',width:100,alige:'center'},
			            {field:'dpmid',title:'所在部门',width:100,alige:'center'},
			            {field:'jobid',title:'所在职位',width:100,alige:'center'},
			            {field:'jobtitle',title:'职称',width:100,alige:'center'}
		      	    ]],
		      		toolbar: [{
		      			text   :'添加',
						iconCls: 'icon-add',
						handler: function(){
							
						}
					},'-',{
						iconCls: 'icon-help',
						handler: function(){alert('帮助按钮')}
					}]
		      		
		            
			});
			 var pager = $('#dg').datagrid("getPager");
	        pager.pagination({
	            onSelectPage:function(pageNumber,pageSize){
	            	refreshDate(pageNumber,pageSize);
	            }
	        });
		
		});
		        //刷新表格数据
		    function refreshDate(pageNo,pageSize){   	
		        $('#dg').datagrid('loading');
				$.post("showUserVo.do",{
			       	methodName:'showUserVo',
			       	pageNo:pageNo,
			       	pageSize:pageSize
		    	},function(data){
			      	$('#dg').datagrid("loadData",{
			             rows:data.rows,
			             total:data.total
			      	});
			     	$('#dg').datagrid('loaded');
		    	},"json");
		    }
			
		
	</script>
  </head>
  <body>
  	<table id="dg"></table>
  </body>
</html>
