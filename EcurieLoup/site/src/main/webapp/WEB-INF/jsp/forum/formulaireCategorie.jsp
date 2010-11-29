<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.forum"/>

<!-- on place le corps du site (partie centrale) -->
<div id="corps">
	<div class="forum">
		<div class="navigation">
			&gt; <a href="${ctx}/forum/affichage.do"><fmt:message key="forum.navigation.forum"/></a>
			&gt; <fmt:message key="forum.navigation.categorie.form"/>
		</div>
		
		<div class="formulaireCategorie">
			<h1><fmt:message key="forum.categorie.title"/></h1>

			<spring:bind path="categorie">
				<div class="error">
					<c:out value="${status.value}" />
					<c:out value="${status.errorMessage}" />
				</div>
			</spring:bind>
			
			<form method="post">
				<spring:bind path="categorie.titre">
					<fmt:message key="forum.categorie.form.title"/>
					<input type="text" name="titre" value="<c:out value="${categorie.titre}"/>" size="15" maxlength="50" />
					&#160;
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind>
				<br />
				<spring:bind path="categorie.description">
			    	<fmt:message key="forum.categorie.form.describe"/>
			    	<br />
					<textarea name="description" rows="10" cols="50"><c:out value="${categorie.description}" /></textarea>
				</spring:bind>
 				<br />
				
				<input class="boutton_enregistrer" type="submit" value="<fmt:message key="forum.categorie.form.submit"/>" />
			</form>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>

