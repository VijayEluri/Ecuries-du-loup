<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime" prefix="dt"%>


<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>


<fmt:setBundle basename="i18n.news"/>

<div id="corps">
	<div class="visualisationNews">
		<h1><fmt:message key="new.view.title"/></h1>
		
		
		<div class="edito">
			<h2><fmt:message key="new.view.edito.title"/>
				<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_ADMIN">
					<a href="${ ctx }/administration/formulaireVrac.do?vrac=edito">
						<img src="${ctx}/images/edit.png" alt="<fmt:message key="new.view.edito.edit.alt"/>" title="<fmt:message key="new.view.edito.edit.title"/>" />
					</a>
				</security:authorize>
			</h2>
			${ edito }
		</div>
		
		<div class="nouvelles">
			<div class="lien">
				<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_NEWS">
					
				<a href="${ctx}/administration/news/formulaireNews.do">
					<fmt:message key="new.lien.write_news"/>
				</a>
			
				</security:authorize>
				<a href="${ctx}/rssfeed.do" class="rss">
					<img src="${ctx}/images/rss.png" alt="<fmt:message key="new.rss.alt"/>" title="<fmt:message key="new.rss.title"/>" />
				</a>
			</div>
			<c:if test="${empty listeNews}">
				<p><fmt:message key="new.empty_list"/></p>
			</c:if> 
		
			<c:forEach var="news" items="${listeNews}">
				<div class="nouvelle">
					<div class="entete">
						<div class="info">
							<span class="titre"> ${news.titre} </span>
							<span class="auteur"> <fmt:message key="new.by"/>${news.auteur.login} </span>
							<span class="date_creation"> <dt:format pattern="dd/MM/yyyy HH:mm"> ${news.dateCreation}</dt:format></span>
						</div>
						
						<div class="action">
							<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_NEWS">
					
								<a href="${ctx}/administration/news/formulaireNews.do?idNouvelle=${news.id}">
									<img src="${ctx}/images/edit.png" alt="<fmt:message key="new.update.alt"/>" title="<fmt:message key="new.update.title"/>" />
								</a>
						
								<a href="${ctx}/news/affichageNews.do?deleteNouvelle=${news.id}">
									<img src="${ctx}/images/delete.png" alt="<fmt:message key="new.delete.alt"/>" title="<fmt:message key="new.delete.title"/>" />
								</a>
							</security:authorize>
						</div>
					</div>
					<div class="derniere_modification">
						<c:if test="${news.dateDerniereModification != 0}">
							<fmt:message key="new.last_update"/>
							<dt:format pattern="dd/MM/yyyy HH:mm"> ${news.dateDerniereModification}</dt:format>
				
						</c:if>
					</div>
					<div class="corps">
						${news.contenu}
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>

