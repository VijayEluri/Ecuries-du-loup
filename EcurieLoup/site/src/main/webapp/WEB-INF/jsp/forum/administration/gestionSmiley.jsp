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
		&gt; <a href="${ctx}/forum/administration/gestionCategorieSmiley.do"><fmt:message key="forum.navigation.smiley.categorie_manager"/></a>
		&gt; <fmt:message key="forum.navigation.smiley.smiley_manager"/>
	</div>

	<div class="administrationForum">
		<div class="visualisationSmiley">
			<h1><fmt:message key="smiley.administration.smiley_manager.title"/></h1>


			<c:if test="${empty categorie.smileys}">
				<p><fmt:message key="smiley.administration.smiley_manager.empty_list"/></p>
			</c:if>
			
			
			<table>
				<tr>
					<td><fmt:message key="smiley.administration.smiley_manager.table.ordre"/></td>
					<td><fmt:message key="smiley.administration.smiley_manager.table.smiley"/></td>
					<td><fmt:message key="smiley.administration.smiley_manager.table.image"/></td>
					<td><fmt:message key="smiley.administration.smiley_manager.table.delete"/></td>
				</tr>
				<c:forEach var="smiley" items="${categorie.smileys}">
			
					<tr>
						<td>
							<a href="${ctx}/forum/administration/gestionSmiley.do?categorie=${categorie.id}&up=${smiley.id}">
								<img class="imagePresentation" alt="<fmt:message key="smiley.administration.categorie_manager.up.alt" />"	src="${ctx }/images/fleche_haut.png" />
							</a>
							${smiley.ordre}
							<a href="${ctx}/forum/administration/gestionSmiley.do?categorie=${categorie.id}&down=${smiley.id}">
								<img class="imagePresentation" alt="<fmt:message key="smiley.administration.categorie_manager.down.alt" />" src="${ctx }/images/fleche_bas.png" />
							</a>
						</td>
						<td>${smiley.code}</td>
						<td>
							<img src="${ctx }/images/smiley/${smiley.id}" alt="${smiley.code }" />
						</td>
						<td>
							<a href="${ctx}/forum/administration/gestionSmiley.do?categorie=${categorie.id}&delete=${smiley.id}">
								<img class="imagePresentation" alt="<fmt:message key="smiley.administration.categorie_manager.delete.alt" />" src="${ctx }/images/delete.png" />
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="lien">
				<a href="${ctx}/forum/administration/formulaireSmiley.do?categorie=${categorie.id }">
					<fmt:message key="smiley.administration.smiley_manager.new_smiley"/>
				</a>
			</div>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../../foot.jsp"%>