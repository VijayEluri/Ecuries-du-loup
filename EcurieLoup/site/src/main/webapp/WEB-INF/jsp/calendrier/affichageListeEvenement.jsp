<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime" prefix="dt"%>

<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>


<fmt:setBundle basename="i18n.calendrier"/>


<div id="corps">
	<div class="navigation">
		&gt; <a	href="${ctx}/calendrier/affichage.do"><fmt:message key="calendrier.navigation.calendrier"/></a>
		&gt; <a	href="${ctx}/calendrier/administration/administration.do"><fmt:message key="calendrier.navigation.administration"/></a>
		&gt; <fmt:message key="calendrier.navigation.event_list" />
	</div>

	<div class="calendrier">
		<div class="visualisationTousLesTypesEvenements">
			<h1><fmt:message key="calendrier.event_list.title" /></h1>

			<a href="${ctx}/calendrier/administration/formulaireEvenement.do">
				<fmt:message key="calendrier.event_list.add_event" />
			</a>
			
			<c:if test="${empty listeEvenement}">
				<p><fmt:message key="calendrier.event_list.empty_list" /></p>

			</c:if>
			
			<table>
				<tr>
					<td><fmt:message key="calendrier.events_list.date" /></td>
					<td><fmt:message key="calendrier.events_list.describe" /></td>
					<td><fmt:message key="calendrier.events_list.type" /></td>
					<td></td>
				</tr>
				<c:forEach var="evenement" items="${listeEvenement}">
					<tr>
						<td>
							<a href="${ctx}/calendrier/administration/formulaireEvenement.do?evenement=${evenement.id}">
								<dt:format pattern="dd/MM/yyyy">${evenement.date }</dt:format>
							</a>
						</td>
						<td>${evenement.description }</td>
						<td>${evenement.typeEvenement.nom }</td>
						<td>
							<a href="${ctx }/calendrier/administration/affichageEvenement.do?suppression=${evenement.id}">
								<img src="${ctx}/images/delete.png" alt="<fmt:message key="calendrier.events_list.delete_event.alt" />" title="<fmt:message key="calendrier.events_list.delete_event.title" />" />
							</a>
						</td>
			
					</tr>
				</c:forEach>
			</table>
			

		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>