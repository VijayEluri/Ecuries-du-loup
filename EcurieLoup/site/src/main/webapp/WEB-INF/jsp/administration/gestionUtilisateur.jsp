<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.administration"/>

<!-- on place le corps du site (partie centrale) -->
<div id="corps">
	<div class="navigation">
		&gt; <a	href="${ctx}/administration/affichage.do"><fmt:message key="administraction.navigation.administration"/></a>
		&gt; <fmt:message key="administraction.navigation.users_manager"/>
	</div>


	<div class="administration">
		<h1><fmt:message key="administraction.users_management.title"/></h1>

		<table>
			<tr>
				<td><fmt:message key="administraction.users_management.login"/></td>
		
				<td><fmt:message key="administraction.users_management.name"/></td>
		
				<td><fmt:message key="administraction.users_management.firstname"/></td>
				
				<td><fmt:message key="administraction.users_management.email"/></td>
		
				<td><fmt:message key="administraction.users_management.create_date"/></td>
		
				<td><fmt:message key="administraction.users_management.last_access_date"/></td>
				
				<td><fmt:message key="administraction.users_management.active"/></td>
		
			</tr>
		
			<c:forEach var="utilisateur" items="${listeUtilisateur}">
				<tr>
					<td>${ utilisateur.login }</td>
		
					<td>${ utilisateur.nom }</td>
		
					<td>${ utilisateur.prenom }</td>
					
					<td>${ utilisateur.email }</td>
		
					<td>${ utilisateur.creationDate }</td>
		
					<td>${ utilisateur.lastAccessDate }</td>
					
					<td>
						<a	href="${ctx }/administration/gestionUtilisateur.do?activation=${ utilisateur.login }">
							<c:if test="${ utilisateur.enabled }">
								<fmt:message key="administraction.users_management.isActive"/>
							</c:if>
							<c:if test="${ ! utilisateur.enabled }">
								<fmt:message key="administraction.users_management.isNotActive"/>
							</c:if>
						 </a>
					</td>
				</tr>
			</c:forEach>
		
		</table>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>