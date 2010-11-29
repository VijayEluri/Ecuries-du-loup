<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime" prefix="dt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.forum"/>

<div id="corps">
	
	<div id="haut" />
	<div class="navigation">
		&gt; <a href="${ctx}/forum/affichage.do"><fmt:message key="forum.navigation.forum"/></a>
		&gt; <a href="${ctx}/forum/affichage.do?categorie=${topic.categorie.id}">${topic.categorie.titre}</a>
		&gt; ${topic.titre}
	</div>
	<div class="forum">
		<div class="visualisationMessageForum">
		<h1><fmt:message key="forum.message.title"/>${topic.titre}</h1>
	
		<c:if test="${empty listeMessageForum}">
			<p><fmt:message key="forum.message.empty_list"/></p>
	
		</c:if>
		
		<c:forEach var="message" items="${listeMessageForum}">
			<div id="message_${message.id}" class="message">
				
				<div class="entete">
					<c:if test="${( topic.dateLecture <  message.datePostage) }">
						<img class="petit_icone" src="${ctx}/images/forum/nonLu.png" alt="<fmt:message key="forum.topic.nonLu.alt"/>" />
					</c:if>
					<div class="info">
						<span class="auteur"><fmt:message key="forum.message.by"/>${message.auteur.login} </span>
						<span class="date_creation"> 
							<dt:format pattern="dd/MM/yyyy HH:mm"> ${message.datePostage}</dt:format>
						</span>
						
					</div>
					
					<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_FORUM">
						<div class="action">
							 <a href="${ctx}/forum/formulaireMessage.do?message=${message.id}">
							  	<img src="${ctx}/images/edit.png" alt="<fmt:message key="forum.message.edit.alt"/>" title="<fmt:message key="forum.message.edit.title"/>" />
							  </a> 
						  	<a href="${ctx}/forum/affichage.do?topic=${message.topic.id}&suppression=${message.id}">
						  		<img src="${ctx}/images/delete.png" alt="<fmt:message key="forum.message.delete.alt"/>" title="<fmt:message key="forum.message.delete.title"/>" />
						  	</a>
						</div>
					</security:authorize>
					<security:authorize ifNotGranted="ROLE_ADMINISTRATEUR_FORUM">
					
						<c:if test="${message.auteur.login == loginUtilisateurConnecte}">
							<div class="action">
								 <a href="${ctx}/forum/formulaireMessage.do?message=${message.id}">
								  	<img src="${ctx}/images/edit.png" alt="<fmt:message key="forum.message.edit.alt"/>" title="<fmt:message key="forum.message.edit.title"/>" />
								  </a> 
							  	<a href="${ctx}/forum/affichage.do?topic=${message.topic.id}&suppression=${message.id}">
							  		<img src="${ctx}/images/delete.png" alt="<fmt:message key="forum.message.delete.alt"/>" title="<fmt:message key="forum.message.delete.title"/>" />
							  	</a>
							</div>
						</c:if>
					</security:authorize>
				</div>
				<div class="derniere_modification">
					<c:if test="${message.dateModification != 0}">
						<fmt:message key="forum.message.last_update"/><dt:format pattern="dd/MM/yyyy HH:mm"> ${message.dateModification}</dt:format>
					</c:if>
				</div>
				<div class="corps">
					${message.contenu}
				</div>
			</div>
		</c:forEach>
		<a href="#haut">
				<fmt:message key="forum.haut"/>
		</a>
		<br />
		<br />
		
		
		<c:if test="${topic.ouvert}">
			<div class="lien">
				<a href="${ctx}/forum/formulaireMessage.do?topic=${topic.id}">
					<fmt:message key="forum.message.response"/>
				</a>
			</div>
			</c:if>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>

