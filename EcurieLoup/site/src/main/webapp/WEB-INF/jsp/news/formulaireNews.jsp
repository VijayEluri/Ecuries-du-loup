<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.news"/>

<div id="corps">
	<div class="formulaireNews">
		<h1><fmt:message key="new.write.title"/></h1>
		
		<form method="post">
			<spring:bind path="nouvelle.id">
				<input name="id" type="hidden" value="<c:out value="${status.value}"/>" />
			</spring:bind> 
			
			<spring:bind path="nouvelle.titre">
				<fmt:message key="new.write.form.title"/>
				<input name="titre" type="text"	value="<c:out value="${nouvelle.titre}"/>" />
			</spring:bind>
			<br />
		
			<spring:bind path="nouvelle.contenu">
				<c:set var="nameContenuEDLCode" value="contenu" />
				<c:set var="valeurContenuEDLCode" value="${nouvelle.contenu}" />
		
				<%@ include file="../contenuEDLcode.jsp"%>
			</spring:bind>
			<br />
			<input id="bouton_valider_news" type="submit" value="<fmt:message key="new.write.form.submit"/>" />
		</form>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>

