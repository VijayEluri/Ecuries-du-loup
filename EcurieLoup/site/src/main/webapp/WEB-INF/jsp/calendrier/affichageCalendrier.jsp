<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime" prefix="dt"%>

<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.calendrier"/>

<div id="corps">
	<div class="navigation">
		&gt; <fmt:message key="calendrier.navigation.calendrier"/>
	</div>
	
	<div class="calendrier">
		<h1><fmt:message key="calendrier.title"/></h1>
		
		
		<div class="visualisationCalendrier">
		
		<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_CALENDRIER">
			<div class="administration">
				<div class="lien">
					<a href="${ctx}/calendrier/administration/administration.do">
						<fmt:message key="calendrier.lien.administration"/>
					</a>
				</div>
			</div>
		</security:authorize>
		 <a	href="${ctx}/calendrier/affichage.do?mois=${ numeroMois - 1 }&annee=${ annee }">
			<img alt="precedent mois" src="${ctx }/images/gauche.jpeg" /> 
		</a>
		${nomMois }
		<a href="${ctx}/calendrier/affichage.do?mois=${ numeroMois + 1 }&annee=${ annee }">
			<img alt="suivant mois" src="${ctx }/images/droite.jpeg" />
		</a>
		
		<br />

	<a href="${ctx}/calendrier/affichage.do?mois=${ numeroMois }&annee=${ annee - 1}">
		<img alt="precedente annee" src="${ctx }/images/gauche.jpeg" />
	</a>
	${annee }
	<a href="${ctx}/calendrier/affichage.do?mois=${ numeroMois }&annee=${ annee + 1}">
		<img alt="suivant annee" src="${ctx }/images/droite.jpeg" />
	
	</a>
	
	
	<div id="affichage_calendrier">
		<div class="jour label"><fmt:message key="calendrier.lettre.monday"/></div>
		<div class="jour label"><fmt:message key="calendrier.lettre.tuesday"/></div>
		<div class="jour label"><fmt:message key="calendrier.lettre.wednesday"/></div>
		<div class="jour label"><fmt:message key="calendrier.lettre.thursday"/></div>
		<div class="jour label"><fmt:message key="calendrier.lettre.friday"/></div>
		<div class="jour label"><fmt:message key="calendrier.lettre.saturday"/></div>
		<div class="jour label"><fmt:message key="calendrier.lettre.sunday"/></div>
		<div class="retour_ligne"></div>

		<!-- affichage de jour jour pour aligné le premier jours avec son jour -->
		<c:forEach var="vide" begin="1" end="${jourVide}">
			<div class="jour">&nbsp;</div>
		</c:forEach>
		
		<c:forEach var="jour" begin="1" end="${jourMois}">
			<c:if test="${fn:length(mapEvenement[jour]) > 0}">
				<a	href="${ctx}/calendrier/affichage.do?mois=${ numeroMois }&annee=${ annee}&jour=${jour}"
				title="
						<c:forEach var="evenement" items="${mapEvenement[jour]}" >
							- ${evenement.description}
							</c:forEach>
						">
					<div class="jour">
						<!-- affichage des cadres de type d'évenement autour du jour des evenement-->
						<c:forEach var="evenement" items="${mapEvenement[jour]}">
							<div class="evenement" style="border: solid 2px ${evenement.typeEvenement.couleur};">
						</c:forEach>
						
						<c:choose>
							<c:when test="${jour == jourEncour}">
								<span class="jourEnCour"> ${jour} </span>
							</c:when>
							<c:otherwise>
								${jour}
							</c:otherwise>
						</c:choose>
						
						<c:forEach var="evenement" items="${mapEvenement[jour]}">
							</div>
						</c:forEach>
					</div>
				</a>
 			</c:if>
 			<c:if test="${fn:length(mapEvenement[jour]) <= 0}">
 				
				<div class="jour">
					<c:choose>
						<c:when test="${jour == jourEncour}">
							<span class="jourEnCour"> ${jour} </span>
						</c:when>
						<c:otherwise>
							${jour}
						</c:otherwise>
					</c:choose>
				</div>
			</c:if>
			<!-- quand on arrive en fin de ligne, on pose un bloque de retour a la lgien -->
			<c:if test="${(jour + jourVide) % 7 == 0}">
				<div class="retour_ligne"></div>
			</c:if>
		 </c:forEach>
	<div class="retour_ligne"></div>
	</div>
</div>


<c:if test="${fn:length(listeEvenement) > 0}">
	<div class="liste_evenement">
		<table>
			<tr>
				<td><fmt:message key="calendrier.events_list.date"/></td>
				<td><fmt:message key="calendrier.events_list.describe"/></td>
				<td><fmt:message key="calendrier.events_list.type"/></td>
				<td></td>
			</tr>
			<c:forEach var="evenement" items="${listeEvenement}">
				<tr>
					
	
						<td>
							<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_CALENDRIER">	
								<c:choose>
								<c:when test="${evenement.id != 0}">
									<a href="${ctx}/calendrier/administration/formulaireEvenement.do?evenement=${evenement.id}">
										<dt:format pattern="dd/MM/yyyy">${evenement.date }</dt:format>
									</a>
								</c:when>
								<c:otherwise>
									<dt:format pattern="dd/MM/yyyy">${evenement.date }</dt:format>
								</c:otherwise>
								</c:choose>
							</security:authorize>
							<security:authorize ifNotGranted="ROLE_ADMINISTRATEUR_CALENDRIER">
								<dt:format pattern="dd/MM/yyyy">${evenement.date }</dt:format>
							</security:authorize>
						</td>
						<td>${evenement.description }</td>
						<td>${evenement.typeEvenement.nom }</td>
	
						<td>
							<c:if test="${evenement.typeEvenement.urlJspView != ''}">
							<a href="${ctx }/calendrier${evenement.typeEvenement.urlJspView}?id=${evenement.id}">
								Vue
							</a>
							</c:if>
						</td>
						
					
	
				</tr>
			</c:forEach>
		</table>
	</div>
</c:if>
</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>