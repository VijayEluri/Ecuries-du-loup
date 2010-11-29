
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcom</title>
</head>
<body>
	 
 
	<%-- Redirected because we can't set the welcome page to a virtual URL. --%>
	<c:redirect url="/index.do"/>
	
	Si vous n'êtes pas automatiquement redirigé <a href="index.do">cliquez ici</a>

</body>
</html>