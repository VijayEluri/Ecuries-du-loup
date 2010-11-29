<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime" prefix="dt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.calendrier"/>

<div id="corps">
	<div class="navigation">
		&gt; <a href="${ctx}/calendrier/affichage.do"><fmt:message key="calendrier.navigation.calendrier"/></a>
		&gt; <a	href="${ctx}/calendrier/administration/administration.do"><fmt:message key="calendrier.navigation.administration"/></a>
		&gt; <a href="${ctx}/calendrier/administration/affichageEvenement.do"><fmt:message key="calendrier.navigation.event_list"/></a>
		&gt; <fmt:message key="calendrier.navigation.event_form"/>
	</div>
	
	<div class="calendrier">
		<div class="formulaireCalendrier">
			<h1><fmt:message key="calendrier.form_event.title"/></h1>

			<spring:bind path="evenement">
				<div class="error">
					<c:out value="${status.value}" />
					<c:out value="${status.errorMessage}" />
				</div>
			</spring:bind>
			
			<form method="post">
				<spring:bind path="evenement.date">
				 	<fmt:message key="calendrier.form_event.date"/>
				 	<c:if test="${evenement.date > 0}">
						<input id="dateTypeEvenement" type="text"
							value="<dt:format pattern="dd/MM/yyyy">${evenement.date }</dt:format>"
							readonly="readonly" name="TheDate" onchange="convertir()">
							
						<input id="dateTypeEvenementInTimestamp" type="hidden"
							value="${evenement.date }" readonly="readonly" name="date">
					</c:if>
	
					<c:if test="${evenement.date == 0}">
						<input id="dateTypeEvenement" type="text"
							value="<dt:format pattern="dd/MM/yyyy"><dt:currentTime/></dt:format>"
							readonly="readonly" name="TheDate" onchange="convertir()">
						<input id="dateTypeEvenementInTimestamp" type="hidden"
							value="<dt:currentTime/>" readonly="readonly" name="date">
					</c:if>
					
					<input type="button" value=">"
						onclick="displayCalendar(document.getElementById('dateTypeEvenement'),'dd/mm/yyyy',this)">			 
				 		&#160;
				 		<span class="error">
				 			<c:out value="${status.errorMessage}" />
				 		</span>
					</spring:bind>
					
					 <br />
					<spring:bind path="evenement.typeEvenement">
							<fmt:message key="calendrier.form_event.event_type"/>					    
						    <select name="typeEvenement">
								<c:forEach var="typeEvenement" items="${listeTypeEvenement}">
									<c:if test="${typeEvenement.id == evenement.typeEvenement.id}">
										<option value="${typeEvenement.id }" selected="selected">
											${typeEvenement.nom}
										</option>
									</c:if>
			
									<c:if test="${typeEvenement.id != evenement.typeEvenement.id}">
										<option value="${typeEvenement.id }">${typeEvenement.nom }</option>
									</c:if>
								</c:forEach>
							</select>
					    	&#160;
					    	<span class="error">
					    	<c:out value="${status.errorMessage}" />
							</span>
					</spring:bind>
					
					 <br />
					<br />

					<spring:bind path="evenement.description">
		 				<fmt:message key="calendrier.form_event.describe"/>
				      	<textarea name="description">${evenement.description }</textarea>
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

