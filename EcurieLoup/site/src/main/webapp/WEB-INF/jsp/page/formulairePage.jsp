<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.page"/>

<div id="corps">
	<div class="navigation">
		&gt; <a href="${ctx }/page/administrationPages.do"><fmt:message key="page.navigation.list"/></a>
		&gt; <fmt:message key="page.navigation.form"/>
	</div>

	<div class="page">
		<div class="formulaireMessage">

			<h1><fmt:message key="page.title"/></h1>
	
			<spring:bind path="page">
				<div class="error">
					<c:out value="${status.value}" />
					<c:out value="${status.errorMessage}" />
				</div>
			</spring:bind>
	
			<form method="post">
				<spring:bind path="page.lien">
					<fmt:message key="page.form.lien"/>
					<input name="lien" type="text" value="<c:out value="${page.lien}" />" />
					&#160;
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind> 
				<br />
	
				<spring:bind path="page.contenu">
					<fmt:message key="page.form.contenu"/><br />
	
					<c:set var="nameContenuEDLCode" value="contenu" />
					<c:set var="valeurContenuEDLCode" value="${page.contenu}" />
	
					<%@ include file="../contenuEDLcode.jsp"%>
				</spring:bind>
				<br />
				<input class="boutton_enregistrer" type="submit" value="<fmt:message key="page.form.submit"/>" />
			</form>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>

