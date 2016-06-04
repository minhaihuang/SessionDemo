<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String wrongMessage=(String)request.getSession().getAttribute("wrongMessage");
		if(wrongMessage!=null){
			%>
			<h1><%=wrongMessage %></h1>
			<%
			
			request.getSession().removeAttribute("wrongMessage");
		}
	 %>
	<form action="/SessionDemo/OneTimeCheckNumberLogin">
		用户名<input type="text" name="userName"><br/>
		密    码<input type="password" name="passWord"><br/>
		验证码<input type="text" name="checkNumber">
			<img src="/SessionDemo/GetNumber"></img><br/>
		     <input type="submit" value="登陆">
	</form>
</body>
</html>