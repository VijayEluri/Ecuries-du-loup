<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<%@ include file="../header.jsp"%>


<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.ficheChevaux"/>

<div id="corps">
	<div class="navigation">
		&gt; <fmt:message key="ficheChevaux.navigation.listeFiche"/>
	</div>
	<div class="fiche_chevaux">
		<div class="visualisationTousLesFiches">
			<h1> 
				<fmt:message key="ficheChevaux.listeFiche.title"/>
				<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_FICHECHEVAUX">
					<a href="${ctx}/ficheChevaux/administration/administration.do">
						<img src="${ctx}/images/edit.png" alt="<fmt:message key="ficheChevaux.administration.alt"/>" title="<fmt:message key="ficheChevaux.administration.title"/>" />
					</a>
				</security:authorize>
				
			</h1>
			<ul>
			 <c:forEach var="fiche" items="${fichesChevaux}">
			 	<li><a href="${ctx}/ficheChevaux/affichageFiche.do?id=${fiche.id }">${fiche.nom }</a></li>
			 </c:forEach>
			</ul>
			<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_FICHECHEVAUX">
				<div class="lien">
					<a href="${ctx}/ficheChevaux/administration/formulaireFiche.do">
						<fmt:message key="ficheChevaux.newFiche"/>
					</a>
				</div>
			</security:authorize>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>