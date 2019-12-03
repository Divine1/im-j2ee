<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>im homepage</title>
</head>
<body>
	<h1>welcome to im</h1>
	<div>
		<a href='<%=request.getContextPath() + "/api/agent"%>'>click here</a>
		to submit agent information
	</div>
	<div>
		<a href='<%=request.getContextPath() + "/api/downloadfile"%>'>click
			here</a> to download file
	</div>
</body>
</html>