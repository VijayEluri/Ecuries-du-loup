<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime" prefix="dt"%>

<%@ include file="../header.jsp"%>


<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.ficheChevaux"/>

<div id="corps">
	<div class="navigation">
		&gt; <a href="${ctx}/ficheChevaux/affichage.do"><fmt:message key="ficheChevaux.navigation.listeFiche"/></a>
		&gt; ${ficheCheval.nom}
	</div>
	<div class="fiche_chevaux">
		<div class="visualisationFiche">
			<h1> 
				<fmt:message key="ficheChevaux.fiche.title">
					<fmt:param value="${ficheCheval.nom}"/>
				</fmt:message>
				
				<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_FICHECHEVAUX">
					<a href="${ctx}/ficheChevaux/administration/formulaireFiche.do?id=${ficheCheval.id}">
						<img src="${ctx}/images/edit.png" alt="<fmt:message key="ficheChevaux.fiche.update.alt"/>" title="<fmt:message key="ficheChevaux.fiche.update.title"/>" />
					</a>
					<a href="${ctx}/ficheChevaux/affichage.do?suppression=${ficheCheval.id}">
						<img src="${ctx}/images/delete.png" alt="<fmt:message key="ficheChevaux.fiche.delete.alt"/>" title="<fmt:message key="ficheChevaux.fiche.delete.title"/>" />
					</a>
				</security:authorize>
			</h1>
			<div class="photo_fiche">
				<c:choose>
					<c:when test="${ficheCheval.photoTete != null }">
						<img alt="photo tete du cheval" src="${ctx}/images/albumPhoto/${ficheCheval.photoTete.id}"  onmouseover="affichePhotoGrand(event, 'survolTete')" onmouseout="cachePhotoGrand('survolTete')"/>
						<div id="survolTete" class="survol">
							<img alt="photo tete du cheval" src="${ctx}/images/albumPhoto/${ficheCheval.photoTete.id}"/>
						</div>
					</c:when>
					<c:otherwise>
						<img alt="pas de photo de la tete du cheval" src=""/>
					</c:otherwise>
				</c:choose>
				<br />
				<c:choose>
					<c:when test="${ficheCheval.photoCorps != null }">
						<img alt="photo du corps du cheval" src="${ctx}/images/albumPhoto/${ficheCheval.photoCorps.id}" onmouseover="affichePhotoGrand(event, 'survolCorps')" onmouseout="cachePhotoGrand('survolCorps')">
						<div id="survolCorps" class="survol" >
							<img alt="photo du corps du cheval" src="${ctx}/images/albumPhoto/${ficheCheval.photoCorps.id}"/>
						</div>
						
					</c:when>
					<c:otherwise>
						<img alt="pas de photo du corps du cheval" src=""/>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="informations">
				<p><h2><fmt:message key="ficheChevaux.fiche.surnoms" /></h2>
				<div class="surnom">
					
					
					<c:forEach var="surnom" items="${ficheCheval.surnoms}" >
						- ${surnom.surnom}<br />
					</c:forEach>
				</div></p>
				
				<c:if test="${ficheCheval.owner  != null}">
				<p><h2><fmt:message key="ficheChevaux.fiche.owner" /></h2>
				<div class="owner">
					<c:choose>
						<c:when test="${ficheCheval.owner.user  != null}">
							${ficheCheval.owner.user.login} - ${ficheCheval.owner.user.prenom} ${ficheCheval.owner.user.nom}
						</c:when>
						<c:otherwise>
							${ficheCheval.owner.name}
						</c:otherwise>
					</c:choose>
								
							
					
				</div></p>
				</c:if>		
				<p><h2><fmt:message key="ficheChevaux.fiche.robe" /></h2>${ficheCheval.robe.nom}</p>
				
				<p><h2><fmt:message key="ficheChevaux.fiche.race" /></h2>${ficheCheval.race.nom}</p>
				
				<c:choose>
					<c:when test="${ficheCheval.dateNaissance != 0}">
						<p><h2><fmt:message key="ficheChevaux.fiche.dateNaissance" /></h2>
							<dt:format pattern="dd/MM/yyyy"> ${ficheCheval.dateNaissance}</dt:format></p>
					</c:when>
					<c:otherwise>
						<p><h2><fmt:message key="ficheChevaux.fiche.anneeNaissance" /></h2>
							${ficheCheval.anneeNaissance}</p>
					</c:otherwise>
				</c:choose>
				<p><h2><fmt:message key="ficheChevaux.fiche.sexe" /></h2>${ficheCheval.sexe.nom}</p>
				
				<p><h2><fmt:message key="ficheChevaux.fiche.description" /></h2>
				${ficheCheval.description}</p>
				
				</div>
				 
			
				
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>