<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<fmt:setBundle basename="i18n.facebook"/>

<%
 request.setAttribute("ctx", request.getContextPath());
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		
		
		<title><fmt:message key="facebook.meta.title"/></title>
		
		<!-- lien css -->
		<link rel="stylesheet" media="screen" type="text/css" title="Ecuries du loup" href="${ctx}/css/general.css" />
		
		<script language="javascript" src="${ctx}/js/gestionVariable.js"> </script>
		<script language="javascript">
			set_ctx("${ctx}");
		</script>
		
	</head>
	
	
	<body>
		<div id="header">
			<fmt:message key="facebook.header.title"/>
		</div>