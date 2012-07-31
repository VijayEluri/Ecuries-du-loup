<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<%@ include file="../header.jsp"%>


<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.ficheChevaux"/>

<div id="corps">
	<div class="navigation">
		&gt; <a href="${ctx}/ficheChevaux/categoryslist.do"><fmt:message key="horsecard.browse.categoryslist"/></a>
		&gt; <fmt:message key="ficheChevaux.navigation.listeFiche"/>
	</div>
	<div class="fiche_chevaux">
		<div class="visualisationTousLesFiches">
			<h1> 
				<fmt:message key="ficheChevaux.listeFiche.title">
					<fmt:param>${ category.name}</fmt:param>
				</fmt:message>
				<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_FICHECHEVAUX">
					<a href="${ctx}/ficheChevaux/administration/administration.do">
						<img src="${ctx}/images/edit.png" alt="<fmt:message key="ficheChevaux.administration.alt"/>" title="<fmt:message key="ficheChevaux.administration.title"/>" />
					</a>
					<a href="${ctx}/ficheChevaux/administration/formulaireFiche.do">
						<img alt="add" src="${ctx}/images/add.png" alt="<fmt:message key="ficheChevaux.newFiche" />" title="<fmt:message key="ficheChevaux.newFiche.title"/>" />
					</a>
				</security:authorize>
				
			</h1>
			 <c:forEach var="fiche" items="${fichesChevaux}">
				 <a href="${ctx}/ficheChevaux/affichageFiche.do?id=${fiche.id }">
				 	<div class="horseCard">
				 		<table width="100%" height="100px" align="center" valign="center">
							<tr>
								<td style="text-align: center">
							   		<img src="${ctx}/images/albumPhoto/miniatures/${fiche.photo.id}" />
								</td>
							</tr>
						</table>
				 		<div class="name">${fiche.nom }</div>
				 	</div>
			 	</a>
			 </c:forEach>
			
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>