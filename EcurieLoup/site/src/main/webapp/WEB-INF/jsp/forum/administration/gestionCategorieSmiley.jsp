<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<%@ include file="../../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../../menu.jsp"%>


<fmt:setBundle basename="i18n.forum"/>

<!-- on place le corps du site (partie centrale) -->
<div id="corps">

	<div class="navigation">
		&gt; <a href="${ctx}/forum/affichage.do"><fmt:message key="forum.navigation.forum"/></a>
		&gt; <a href="${ctx}/forum/administration/administration.do"><fmt:message key="forum.navigation.administration"/></a>
		&gt; <fmt:message key="forum.navigation.smiley.categorie_manager"/>
	</div>

	<div class="administrationForum">
		<div class="visualisationCategorieSmiley">
			<h1><fmt:message key="smiley.administration.categorie_manager.title"/></h1>


			<c:if test="${empty listeCategoriesSmiley}">
				<p><fmt:message key="smiley.administration.categorie_manager.empty_list"/></p>
			</c:if>
			
			<table>
				<tr>
					<td><fmt:message key="smiley.administration.categorie_manager.table.ordre" /></td>
					<td><fmt:message key="smiley.administration.categorie_manager.table.categorie" /></td>
					<td><fmt:message key="smiley.administration.categorie_manager.table.update" /></td>
					<td><fmt:message key="smiley.administration.categorie_manager.table.delete" /></td>
				</tr>
				<c:forEach var="categorie" items="${listeCategoriesSmiley}">
			
					<tr>
						<td>
							<a href="${ctx}/forum/administration/gestionCategorieSmiley.do?up=${categorie.id}">
								<img class="imagePresentation" alt="<fmt:message key="smiley.administration.categorie_manager.up.alt" />" src="${ctx }/images/fleche_haut.png" />
							</a>
							${categorie.ordre}
							<a href="${ctx}/forum/administration/gestionCategorieSmiley.do?down=${categorie.id}">
								<img class="imagePresentation" alt="<fmt:message key="smiley.administration.categorie_manager.down.alt" />" src="${ctx }/images/fleche_bas.png" />
							</a>
						</td>
						<td>
							<a href="${ctx}/forum/administration/gestionSmiley.do?categorie=${categorie.id}">
								${categorie.nom}
							</a>
						</td>
			
						<td>
							<a href="${ctx}/forum/administration/formulaireCategorieSmiley.do?categorie=${categorie.id}">
								<img class="imagePresentation" alt="<fmt:message key="smiley.administration.categorie_manager.update.alt" />" src="${ctx }/images/edit.png" />
							</a>
						</td>
						<td>
							<a href="${ctx}/forum/administration/gestionCategorieSmiley.do?delete=${categorie.id}">
								<img class="imagePresentation" alt="<fmt:message key="smiley.administration.categorie_manager.delete.alt" />" src="${ctx }/images/delete.png" />
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="lien">
				<a	href="${ctx}/forum/administration/formulaireCategorieSmiley.do">
					<fmt:message key="smiley.administration.categorie_manager.new_categorie" />
				</a>
			</div>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../../foot.jsp"%>