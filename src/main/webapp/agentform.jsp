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
<form method="post" action="<%=request.getContextPath()+"/api/agent" %>"
enctype="multipart/form-data"
>

<input type="file" name="file" multiple />
<input type="text" name="agency_id" placeholder="enter agencyid" />
<input type="text" name="refreshsession" placeholder="enter refreshsession" />
<input type="text" name="delta" placeholder="enter delta" />

<button type="submit">Register</button>
</form>
 </body>
</html>