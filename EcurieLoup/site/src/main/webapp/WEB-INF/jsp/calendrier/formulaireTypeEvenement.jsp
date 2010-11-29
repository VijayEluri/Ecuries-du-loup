<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.calendrier"/>

<!-- on place le corps du site (partie centrale) -->
<div id="corps">
	<div class="navigation">
		&gt; <a	href="${ctx}/calendrier/affichage.do"><fmt:message key="calendrier.navigation.calendrier"/></a>
		&gt; <a	href="${ctx}/calendrier/administration/administration.do"><fmt:message key="calendrier.navigation.administration"/></a>
		&gt; <a href="${ctx}/calendrier/administration/affichageTypeEvenement.do"><fmt:message key="calendrier.navigation.type_event_list"/></a>
		&gt; <fmt:message key="calendrier.navigation.event_type_form"/>
	</div>
	
	<div class="calendrier">
		<div class="formulaireCalendrier">
			<h1><fmt:message key="calendrier.form_event_type.title"/></h1>

			<spring:bind path="typeEvenement">
				<div class="error">
					<c:out value="${status.value}" />
					<c:out value="${status.errorMessage}" />
				</div>
			</spring:bind>
			
			<form method="post">
			
				<spring:bind path="typeEvenement.nom">
			 		<fmt:message key="calendrier.form_event.name"/>		
			 		<c:choose>
			 			<c:when test="${!typeEvenement.permanent }">
			 				<input type="text" name="nom" value="${typeEvenement.nom }"  />
			 			</c:when>
			 			<c:otherwise>
			 				<input type="text" name="nom" value="${typeEvenement.nom }" disabled="disabled"/>
			 			</c:otherwise>
			 		</c:choose>
			 		
					 
					 &#160;
					 <span class="error">
					 	<c:out	value="${status.errorMessage}" />
					 </span>
				</spring:bind>
				
				<br />
				<spring:bind path="typeEvenement.couleur">
					<fmt:message key="calendrier.form_event.color"/>					    
					<input id="couleurTypeEvenement" type="text" name="couleur" value="${typeEvenement.couleur }" />
					<input id="couleurBoutonTypeEvenement" type="button" value="*" title="<fmt:message key="calendrier.form_event.color.tile"/>" />
					&#160;
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind>
				
				<br />
				<br />
				<spring:bind path="typeEvenement.description">
			 		<fmt:message key="calendrier.form_event.describe"/>	 
					<textarea name="description">${typeEvenement.description }</textarea>
					&#160;
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind>
				 <br />
				<br />
				<input type="submit" value="<fmt:message key="calendrier.form_event.submit"/>" />
			</form>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>

