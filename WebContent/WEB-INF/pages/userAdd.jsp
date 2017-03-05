<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<form action="${basePath }accp/add02" method="post">
		<table>
			<tr>
				<th>用户名</th>
				<td><input type="text" name="userName" /></td>
				<td><form:form commandName="user">
						<form:errors path="userName" cssStyle="color:red"></form:errors>
					</form:form></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input type="password" name="password" /></td>
				<td><form:form commandName="user">
						<form:errors path="password" cssStyle="color:red"></form:errors>
					</form:form></td>
			</tr>
			<tr>
				<th>地址</th>

				<td><select name="address">
						<c:forEach items="${cityList}" var="city">
							<option value="${city}">${city}</option>
						</c:forEach>

				</select></td>
				<td></td>
			</tr>
			<tr>
				<th>生日</th>
				<td><input type="text" name="birthday" /></td>
				<td></td>
			</tr>
			<tr>
				<th>联系电话</th>
				<td><input type="text" name="phoneNumber" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><input type="submit" value="提交" />
					<input type="button" value="返回" onclick="history.back()" /></td>
			</tr>

		</table>
		</form>
	</body>
</html>