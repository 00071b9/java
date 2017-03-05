<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>this is my title</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function del(val){
		if(confirm("确定要删除id="+val+"这条数据吗？")){
		location.href="<%=basePath%>accp/delete?id="+val;
		}
	}
</script>
	</head>
	<body>
	<h1>用户列表</h1>
	<table border="1">
	<tr>
	<th>用户名</th>
	<th>密码</th>
	<th>地址</th>
	<th>生日</th>
	<th>联系电话</th>
	</tr>
	<c:forEach items="${userList}" var="user">
	<tr>
	<td>${user.userName }</td>
	<td>${user.password }</td>
	<td>${user.address }</td>
	<td>
	
	<fmt:formatDate value="${user.birthday }" pattern="yyyy-MM-dd"/>
	</td>
	<td>${user.phoneNumber }</td>
	<td> <a href="<%=basePath%>accp/update?id=${user.id}">修改</a>
	<a href="javascript:del(${user.id})">删除</a>
	</td>
	</tr>
	</c:forEach>
	</table>
	<input type="button" value="返回" onclick="history.back()"/>
	</body>
	
	</body>
</html>