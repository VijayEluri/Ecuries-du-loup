<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.administration"/>


<!-- on place le corps du site (partie centrale) -->
<div id="corps">
	<div class="navigation">
		&gt; <a href="${ctx}/administration/affichage.do"><fmt:message key="administraction.navigation.administration"/></a>
		&gt; <fmt:message key="administraction.navigation.rights_management"/>
	</div>
	
	<div class="administration">
		<h1><fmt:message key="administraction.rights_management.title"/></h1>
	
		<table>
			<tr>
				<td></td>
				<c:forEach var="role" items="${listeRole}">
					<td><img alt="${ role.role }" src="${ctx }/${ role.image }"
						title="${ role.role } : ${ role.description }" /></td>
				</c:forEach>
		
			</tr>
		
			<c:forEach var="utilisateur" items="${listeUtilisateur}">
				<tr>
					<td>${ utilisateur.login }</td>
					<c:forEach var="role" items="${listeRole}">
						<td>
							<a	href="${ctx }/administration/gestionDroit.do?droit=${ role }&utilisateur=${ utilisateur.login}">
								<c:if test="${fn:contains(utilisateur.roles, role)}">
									<img alt="OUI" src="${ctx }/images/tick.png" />
								</c:if>
								<c:if test="${! fn:contains(utilisateur.roles, role)}">
									<img alt="NON" src="${ctx }/images/non_droit.png" />
								</c:if>
							</a>
						</td>
					</c:forEach>
				</tr>
			</c:forEach>
		
		</table>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>