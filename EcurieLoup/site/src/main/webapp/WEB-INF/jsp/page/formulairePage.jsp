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
				<spring:bind path="page.title">
					<fmt:message key="page.form.lien"/>
					<input name="title" type="text" value="<c:out value="${page.title}" />" />
					&#160;
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind> 
				<br />
				
				<spring:bind path="page.description">
					<fmt:message key="page.form.description"/>
					<textarea name="description" cols="30" rows="3"><c:out value="${page.description}" /></textarea>
					&#160;
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind> 
				
				<br />
				<br />
	
				<spring:bind path="page.content">
					<fmt:message key="page.form.contenu"/><br />
	
					<c:set var="nameContenuEDLCode" value="content" />
					<c:set var="valeurContenuEDLCode" value="${page.content}" />
	
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

