<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>im - agent details</title>
</head>
<body>
<h1>agent details</h1>
<div>agentname <%= request.getSession().getAttribute("agentname") %></div>
<div>agentid <%= request.getSession().getAttribute("agentid") %></div>
<div><a href="<%=request.getContextPath()%>">goto homepage</a></div>
 </body>
</html>