<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="menu.jsp"%>

<fmt:setBundle basename="i18n.vrac"/>


<div id="corps">
	<div class="formulaireNews">
		<h1><fmt:message key="vrac.title.begin"/> ${ vrac.id }</h1>
		
		<form method="post">
		
			<spring:bind path="vrac.contenu">
				<c:set var="nameContenuEDLCode" value="contenu" />
				<c:set var="valeurContenuEDLCode" value="${vrac.contenu}" />
				
				<%@ include file="contenuEDLcode.jsp"%>
			</spring:bind>
			
			<br />
			<input id="bouton_valider_news" type="submit" value="<fmt:message key="vrac.submit"/>" />
		</form>
	</div>
</div>


<%@ include file="foot.jsp"%>

