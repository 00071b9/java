<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	</head>
	<body>
	<form action="${basePath }accp/update02" method="post">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="hidden" name="id" value="${user.id }"/></td>
				
			</tr>
			<tr>
				<th>用户名</th>
				<td><input type="text" name="userName" value="${user.userName }"/></td>
				
			</tr>
			<tr>
				<th>密码</th>
				<td><input type="password" name="password" value="${user.password }"/></td>
				
			</tr>
			<tr>
				<th>地址</th>

				<td><select name="address">
						<c:forEach items="${cityList}" var="city">
							<option value="${city}">${city}</option>
						</c:forEach>

				</select></td>
				
			</tr>
			<tr>
				<th>生日</th>
				<td><input type="text" name="birthday" value="${user.birthday }"/></td>
				
			</tr>
			<tr>
				<th>联系电话</th>
				<td><input type="text" name="phoneNumber" value="${user.phoneNumber }"/></td>
				
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
					<input type="button" value="返回" onclick="history.back()" /></td>
			</tr>

		</table>
		</form>
	</body>
</html>