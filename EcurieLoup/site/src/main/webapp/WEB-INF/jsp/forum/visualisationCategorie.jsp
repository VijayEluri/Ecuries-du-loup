<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.forum"/>



<div id="corps">

	<div class="navigation">
		&gt; <fmt:message key="forum.navigation.forum"/>
	</div>
	
	<div class="forum">
		<div class="visualisationCategorieForum">
			<h1><fmt:message key="forum.title"/> 
			
				<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_FORUM">
				<a href="${ctx}/forum/administration/administration.do">
					<img src="${ctx}/images/edit.png" alt="<fmt:message key="forum.administration.alt"/>" title="<fmt:message key="forum.administration.title"/>" />
				</a>
				</security:authorize>
			</h1>

			
			<c:if test="${empty listeCategorieForum}">
				<p><fmt:message key="forum.empty_list"/></p>
			
			</c:if>
		
			 <c:forEach var="categorie" items="${listeCategorieForum}">
				<div class="categorie">
					<a href="${ctx}/forum/affichage.do?categorie=${categorie.id}">
						<h2> ${categorie.titre}</h2>
					</a>
					<c:if test="${categorie.topicNonLu}">
						<img src="${ctx}/images/forum/nonLu.png" alt="<fmt:message key="forum.topic.nonLu.alt"/>" />
					</c:if>
					<div class="description" ><p>${categorie.description}</p>
				</div>
				<div class="action" > 
					<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_FORUM">
						<a href="${ctx}/forum/administration/formulaireCategorie.do?categorie=${categorie.id}">
							<img src="${ctx}/images/edit.png" alt="<fmt:message key="forum.categorie.update.alt"/>" title="<fmt:message key="forum.categorie.update.title"/>" />
						</a>
						<a href="${ctx}/forum/affichage.do?suppression=${categorie.id}">
							<img src="${ctx}/images/delete.png" alt="<fmt:message key="forum.categorie.delete.alt"/>" title="<fmt:message key="forum.categorie.delete.title"/>" />
						</a>
					</security:authorize>
				</div>
			
				</div>
			</c:forEach>

	 		<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_FORUM">
				<div class="lien">
					<a href="${ctx}/forum/administration/formulaireCategorie.do">
						<fmt:message key="forum.categorie.add"/>						
					</a>
				</div>
			</security:authorize>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>