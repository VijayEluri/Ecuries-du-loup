<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.calendrier"/>


<div id="corps">
	<div class="navigation">
		&gt; <a href="${ctx}/calendrier/affichage.do"><fmt:message key="calendrier.navigation.calendrier"/></a>
		&gt; <a href="${ctx}/calendrier/administration/administration.do"><fmt:message key="calendrier.navigation.administration"/></a>
		&gt; <fmt:message key="calendrier.navigation.type_event_list" />
	</div>
	
	
	<div class="calendrier">
		<div class="visualisationTousLesTypesEvenements">
			<h1><fmt:message key="calendrier.type_event_list.title" /></h1>

			<c:if test="${message != null}">
				<div class="message_information">
					${message}
				</div>
			</c:if>
			
			 <c:if test="${empty listeTypeEvenement}">
				<p>
					<fmt:message key="calendrier.type_event_list.empty_list" />
				</p>

			</c:if>
			
			<table>
				<tr>
					<td><fmt:message key="calendrier.type_event_list.list.name" /></td>
					<td><fmt:message key="calendrier.type_event_list.list.describe" /></td>
					<td><fmt:message key="calendrier.type_event_list.list.color" /></td>
					<td></td>
				</tr>
				<c:forEach var="type_evenement" items="${listeTypeEvenement}">
					<tr>
						<td>
							<a href="${ctx}/calendrier/administration/formulaireTypeEvenement.do?typeEvenement=${type_evenement.id}">
								${type_evenement.nom }
							 </a>
						</td>
						<td>${type_evenement.description }</td>
						<td>${type_evenement.couleur }</td>
						<td>
							<c:if test="${!type_evenement.permanent }">
								<a href="${ctx }/calendrier/administration/affichageTypeEvenement.do?suppression=${type_evenement.id}">
									<img src="${ctx}/images/delete.png" alt="<fmt:message key="calendrier.type_event_list.delete.alt" /></td>" title="<fmt:message key="calendrier.type_event_list.delete.title" />" />
								</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>

			<a href="${ctx}/calendrier/administration/formulaireTypeEvenement.do"><fmt:message key="calendrier.type_event_list.add" /></a>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>