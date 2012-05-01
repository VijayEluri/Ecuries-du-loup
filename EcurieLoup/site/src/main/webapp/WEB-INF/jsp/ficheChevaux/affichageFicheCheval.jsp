<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime" prefix="dt"%>

<%@ include file="../header.jsp"%>


<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.ficheChevaux"/>
<script>
$(function() {
	$( "#tabsHorseCard" ).tabs();
});
</script>
<div id="corps">
	<div class="navigation">
		&gt; <a href="${ctx}/ficheChevaux/categoryslist.do"><fmt:message key="horsecard.browse.categoryslist"/></a>
		<c:choose>
		<c:when test="${empty ficheCheval.category}">
		&gt; <a href="${ctx}/ficheChevaux/affichage.do?id=0"><fmt:message key="ficheChevaux.navigation.listeFiche"/></a>
		</c:when>
		<c:otherwise>
			&gt; <a href="${ctx}/ficheChevaux/affichage.do?id=${ficheCheval.category.id}"><fmt:message key="ficheChevaux.navigation.listeFiche"/></a>
		</c:otherwise>
		</c:choose>
		
		&gt; <fmt:message key="ficheChevaux.navigation.fiche">
		<fmt:param>${ficheCheval.nom}</fmt:param>
		</fmt:message>
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
			<div id="tabsHorseCard">
				<ul>
					<li><a href="#infos"><fmt:message key="ficheChevaux.tab.infos" /></a>
					</li>
					<li><a href="#photos"><fmt:message key="ficheChevaux.tab.photos" /></a>
					</li>
				</ul>
				<div id="infos">
					<%@ include file="./infos.jsp"%>
				</div>
				<div id="photos">
					<%@ include file="./photos.jsp"%>
				</div>

			</div>
				 
			
				
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>