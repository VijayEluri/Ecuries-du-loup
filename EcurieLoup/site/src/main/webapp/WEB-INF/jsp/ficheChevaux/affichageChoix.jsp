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
		&gt; <a href="${ctx}/ficheChevaux/administration/administration.do"><fmt:message key="ficheChevaux.navigation.administration"/></a>
		&gt; <fmt:message key="ficheChevaux.navigation.choise_liste"/>
	</div>
	<div class="liste_choix_chevaux">
		<h1><fmt:message key="ficheChevaux.choix_list.title">
					<fmt:param value="${nomChoix}"/>
				</fmt:message>
		</h1>
			
			<c:if test="${message != null}">
				<div class="message_information">
					${message}
				</div>
			</c:if>
			<div class="lien">
				<a href="${ctx}/ficheChevaux/administration/formulaire${nomChoix}.do">
					<fmt:message key="ficheChevaux.choise_list.add_choise" />
				</a>
			</div>
			
			
			<c:if test="${empty listChoise}">
				<p><fmt:message key="ficheChevaux.choise_list.empty_list" /></p>
			</c:if>
			
			<table>
				<tr>
					<td><fmt:message key="ficheChevaux.choise_list.name" /></td>
					<td></td>
					<td></td>
				</tr>
				<c:forEach var="choise" items="${listChoise}">
					<tr>
						
						<td>${choise.nom}</td>
						<td>
							<a href="${ctx }/ficheChevaux/administration/formulaire${nomChoix}.do?id=${choise.id}">
								<img src="${ctx}/images/edit.png" alt="<fmt:message key="ficheChevaux.choise_list.update.alt" />" title="<fmt:message key="ficheChevaux.choise_list.update.title" />" />
							</a>
						</td>
						<td>
							<a href="${ctx }/ficheChevaux/administration/choix${nomChoix}.do?suppression=${choise.id}">
								<img src="${ctx}/images/delete.png" alt="<fmt:message key="ficheChevaux.choise_list.delete.alt" />" title="<fmt:message key="ficheChevaux.choise_list.delete.title" />" />
							</a>
						</td>
			
					</tr>
				</c:forEach>
			</table>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>