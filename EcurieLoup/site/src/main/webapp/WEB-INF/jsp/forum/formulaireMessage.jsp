<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.forum"/>

<div id="corps">
	<div class="navigation">
		&gt; <a href="${ctx}/forum/affichage.do"><fmt:message key="forum.navigation.forum"/></a>
		&gt; <fmt:message key="forum.navigation.message.form"/>
	</div>
	
	<div class="forum">
		<div class="formulaireMessage">
			<%
				if(request.getParameter("message") != null){
			%>
			<h1><fmt:message key="forum.message.title.update"/></h1>
			<%
				}else{
			%>
			<h1><fmt:message key="forum.message.title.response"/></h1>

				<%
				}
				%>

			<form method="post">
				<div class="error">
					<c:out value="${status.value}" />
					<c:out value="${status.errorMessage}" />
				</div>
				
				<spring:bind path="message.contenu">
			    	<fmt:message key="forum.message.form.message"/>
			    	<br />

					<c:set var="nameContenuEDLCode" value="contenu" />
					<c:set var="valeurContenuEDLCode" value="${message.contenu}" />

					<%@ include file="../contenuEDLcode.jsp"%>
				</spring:bind>
				<br />
				
				<input class="boutton_enregistrer" type="submit" value="<fmt:message key="forum.message.form.submit"/>" />
			</form>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>

