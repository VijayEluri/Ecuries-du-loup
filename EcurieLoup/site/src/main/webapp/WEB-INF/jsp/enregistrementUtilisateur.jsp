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
		<h1><fmt:message key="registery.title"/></h1>
		
		<spring:bind path="user">
			<div class="error">
				<c:out value="${status.value}" /> 
				<c:out value="${status.errorMessage}" />
			</div>
		</spring:bind>
		
		<form method="POST">
			<ul>
				<li>
					<spring:bind path="user.login">
						<fmt:message key="registery.login"/> 
					     <input type="text" name="login" value="<c:out value="${status.value}"/>" size="15" maxlength="50" />
					     &#160;
					     <span class="error">
					    	 <c:out	value="${status.errorMessage}" />
					     </span>
					</spring:bind>
				</li>
				<li>
					<spring:bind path="user.password">
						<fmt:message key="registery.password"/> 
					    <input type="password" name="password"	value="<c:out value="${status.value}"/>" size="15" maxlength="50" />
					    &#160;
					    <span class="error">
					    	<c:out value="${status.errorMessage}" />
					    </span>
					</spring:bind>
				</li>
				
				<li>&#160;</li>
				
				<li>
					<spring:bind path="user.nom">
						<fmt:message key="registery.name"/> 
					    <input type="text" name="nom" value="<c:out value="${status.value}"/>" size="15" maxlength="50" />
					    &#160;
					    <span class="error">
					     	<c:out value="${status.errorMessage}" />
					    </span>
					</spring:bind>
				</li>
				<li>
					<spring:bind path="user.prenom">
						<fmt:message key="registery.firstname"/>  
					    <input type="text" name="prenom" value="<c:out value="${status.value}"/>" size="15" maxlength="50" />
					    &#160;
					    <span class="error">
					    	<c:out value="${status.errorMessage}" />
					    </span>
					</spring:bind>
				</li>
				<li>
					<spring:bind path="user.email">
						<fmt:message key="registery.email"/>   
						<input type="text" name="email" value="<c:out value="${status.value}"/>" size="15" maxlength="50" />
					    &#160;
					    <span class="error">
					    	<c:out value="${status.errorMessage}" />
					    </span>
					</spring:bind>
				</li>
			</ul>
			<input id="bouton_inscription" type="submit" value="<fmt:message key="registery.submit"/>" /></form>
	</div>
</div>

<!-- on importe le pied de la page -->
<%@ include file="foot.jsp"%>
