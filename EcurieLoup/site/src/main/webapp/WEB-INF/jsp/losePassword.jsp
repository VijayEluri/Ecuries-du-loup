<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="menu.jsp"%>


<fmt:setBundle basename="i18n.registery"/>

<!-- on place le corps du site (partie centrale) -->
<div id="corps">
	<div id="inscription">
		<h1><fmt:message key="registery.losePassword.title"/></h1>
		
		<spring:bind path="user">
			<div class="error">
				<c:out value="${status.value}" /> 
				<c:out value="${status.errorMessage}" />
			</div>
		</spring:bind>
		
		<form method="POST">
			<fmt:message key="registery.losePassword.explain"/>
			<br />
			<br />
			<spring:bind path="user.login">
				<fmt:message key="registery.losePassword.login"/> 
			     <input type="text" name="login" value="<c:out value="${status.value}"/>" size="15" maxlength="50" />
			     &#160;
			     <span class="error">
			    	 <c:out	value="${status.errorMessage}" />
			     </span>
			</spring:bind>
			<br />
			<input id="bouton_inscription" type="submit" value="<fmt:message key="registery.losePassword.submit"/>" />
		</form>
	</div>
</div>

<!-- on importe le pied de la page -->
<%@ include file="foot.jsp"%>
