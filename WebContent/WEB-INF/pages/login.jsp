<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>

<script type="text/javascript">
	function add(){
	location.href="<%=basePath%>/accp/add";
	}

</script>
</head>
<body>
	<h1>用户登录</h1>
    <form action="${basePath}accp/login02" method="post" >
    用户名<input type="text" name="userName" /><br/>
   密     码 <input type="password" name="password" /><br/>
   <input type="submit" value="登录" />
    <input type="button" value="注册" onclick="add()"/>
    </form>
</body>
</html>