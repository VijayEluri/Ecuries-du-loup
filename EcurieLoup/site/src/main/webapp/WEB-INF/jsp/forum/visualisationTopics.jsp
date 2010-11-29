<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime" prefix="dt"%>

<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.forum"/>

<div id="corps">
	<div id="haut" />
	<div class="navigation">
		&gt; <a href="${ctx}/forum/affichage.do"><fmt:message key="forum.navigation.forum"/></a>
		&gt; ${categorie.titre}
	</div>
	<div class="forum">
		<div class="visualisationTopicForum">
			<h1><fmt:message key="forum.topic.title"/>${categorie.titre}</h1>
			
			<c:if test="${empty listeTopicForum}">
				<p><fmt:message key="forum.topic.empty_list"/></p>
			</c:if> <c:forEach var="topic" items="${listeTopicForum}">
				<table class="topic">
					<tr>
						<td class="status">
							<c:choose>
								<c:when test="${topic.ouvert && ( topic.dateLecture >=  topic.dernierMessage.datePostage) }">
									<div class="topicOuvert">
										<img src="${ctx}/images/forum/topicOuvert.png" alt="<fmt:message key="forum.topic.ouvert.alt"/>" />
									</div>
								</c:when>
								<c:when test="${!topic.ouvert && ( topic.dateLecture >=  topic.dernierMessage.datePostage) }">
									<div class="topicFermer">
										<img src="${ctx}/images/forum/topicFermer.png" alt="<fmt:message key="forum.topic.fermer.alt"/>" />
									</div>
								</c:when>
								
								<c:when test="${( topic.dateLecture <  topic.dernierMessage.datePostage) }">
									<div class="topicNonLu">
										<a href="${ctx}/forum/affichage.do?topic=${topic.id}#message_${topic.premierMessageNonLu.id}" >
											<img src="${ctx}/images/forum/nonLu.png" alt="<fmt:message key="forum.topic.nonLu.alt"/>" />
										</a>
									</div>
								</c:when>
							</c:choose>
						</td>
						
						
						<td class="titre"><a href="${ctx}/forum/affichage.do?topic=${topic.id}">${topic.titre}</a>
						</td>
						
						
						<td class="information">
							<fmt:message key="forum.topic.create_by"/>${topic.createur.login}<br />
							<fmt:message key="forum.topic.lastMessage"/><a href="${ctx}/forum/affichage.do?topic=${topic.id}#message_${topic.dernierMessage.id}" ><dt:format pattern="dd/MM/yyyy HH:mm">${topic.dernierMessage.datePostage}</dt:format></a>
						</td>
						
						<td class="action">
							<authz:authorize ifAllGranted="ROLE_ADMINISTRATEUR_FORUM">
								<a href="${ctx}/forum/formulaireTopicModifier.do?topic=${topic.id}">
									<img src="${ctx}/images/edit.png" alt="<fmt:message key="forum.topic.update.alt"/>" title="<fmt:message key="forum.topic.update.title"/>" />
								</a>
								<a href="${ctx}/forum/affichage.do?categorie=${categorie.id}&suppression=${topic.id}">
									<img src="${ctx}/images/delete.png" alt="<fmt:message key="forum.topic.delete.alt"/>" title="<fmt:message key="forum.topic.delete.title"/>" />
								</a>
								
								<c:if test="${topic.ouvert}">
									<div class="fermerTopic">
										<a href="${ctx}/forum/affichage.do?categorie=${categorie.id}&fermer=${topic.id}">
											<img src="${ctx}/images/forum/topicFermer.png" alt="<fmt:message key="forum.topic.close.alt"/>"	title="<fmt:message key="forum.topic.close.title"/>" />
										</a>
									</div>
								</c:if>
							 	<c:if test="${!topic.ouvert}">
									<div class="ouvrirTopic">
										<a href="${ctx}/forum/affichage.do?categorie=${categorie.id}&ouvrir=${topic.id}">
											<img src="${ctx}/images/forum/topicOuvert.png" alt="<fmt:message key="forum.topic.open.alt"/>" title="<fmt:message key="forum.topic.open.title"/>" />
										</a>
									</div>
								</c:if>
							</authz:authorize>
						
							<authz:authorize ifNotGranted="ROLE_ADMINISTRATEUR_FORUM">
					
								<c:if test="${message.auteur.login == loginUtilisateurConnecte}">
									<a href="${ctx}/forum/formulaireTopicModifier.do?topic=${topic.id}">
										<img src="${ctx}/images/edit.png" alt="<fmt:message key="forum.topic.update.alt"/>" title="<fmt:message key="forum.topic.update.title"/>" />
									</a>
									<a href="${ctx}/forum/affichage.do?categorie=${categorie.id}&suppression=${topic.id}">
										<img src="${ctx}/images/delete.png" alt="<fmt:message key="forum.topic.delete.alt"/>" title="<fmt:message key="forum.topic.delete.title"/>" />
									</a>
									
									<c:if test="${topic.ouvert}">
										<div class="fermerTopic">
											<a href="${ctx}/forum/affichage.do?categorie=${categorie.id}&fermer=${topic.id}">
												<img src="${ctx}/images/forum/topicFermer.png" alt="<fmt:message key="forum.topic.close.alt"/>"	title="<fmt:message key="forum.topic.close.title"/>" />
											</a>
										</div>
									</c:if>
								 	<c:if test="${!topic.ouvert}">
										<div class="ouvrirTopic">
											<a href="${ctx}/forum/affichage.do?categorie=${categorie.id}&ouvrir=${topic.id}">
												<img src="${ctx}/images/forum/topicOuvert.png" alt="<fmt:message key="forum.topic.open.alt"/>" title="<fmt:message key="forum.topic.open.title"/>" />
											</a>
										</div>
									</c:if>
								</c:if>
							</authz:authorize>
						</td>
					</tr>
				</table>
			</c:forEach>
			<a href="#haut">
				<fmt:message key="forum.haut"/>
			</a>
			
			<div class="lien">
				
				<a href="${ctx}/forum/formulaireTopicCreer.do?categorie=${categorie.id}">
					<fmt:message key="forum.topic.add"/>
				</a>
			</div>
		
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>

