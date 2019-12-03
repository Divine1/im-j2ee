<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>im - agent form</title>
</head>
<body>
<h1>register an agent</h1>
<form method="post" action="<%=request.getContextPath()+"/api/agent" %>">

<input type="text" name="agentname" placeholder="enter agentname" />
<input type="text" name="agentid" placeholder="enter agentid" />
<button type="submit">Register</button>
</form>
 </body>
</html>