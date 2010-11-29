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
		&gt; <fmt:message key="forum.navigation.topic.form"/>
	</div>
	<div class="forum">
		<div class="formulaireTopicModifier">
		
			<h1><fmt:message key="forum.topic.title.update"/></h1>	
			
			<form method="post">
				<spring:bind path="topic.titre">
					<fmt:message key="forum.topic.form.title"/>
					<input type="text" name="titre"	value="<c:out value="${topic.titre}"/>" size="15" maxlength="50" />
					 &#160;
					 <span class="error">
					 	<c:out value="${status.errorMessage}" />
					 </span>
				</spring:bind>
				<br />
				<input class="boutton_enregistrer" type="submit" value="<fmt:message key="forum.topic.form.submit"/>" />
			</form>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>

