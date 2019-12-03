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
<div>agentid <%= request.getSession().getAttribute("agency_id") %></div>
<div>refreshsession <%= request.getSession().getAttribute("refreshsession") %></div>
<div>delta <%= request.getSession().getAttribute("delta") %></div>


<div><a href="<%=request.getContextPath()%>">goto homepage</a></div>
 </body>
</html>