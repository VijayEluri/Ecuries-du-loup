<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.page"/>

<div id="corps">

	<div class="navigation">
		&gt; <fmt:message key="page.navigation.list"/>
	</div>


	<div class="pages">
		<div class="visualisationAlbumPhoto">
			<h1><fmt:message key="page.administration.title"/></h1>
			
			
			<c:if test="${empty listePages}">
				<p><fmt:message key="page.empty_list"/></p>
			
			</c:if>
			<table>
				<tr>
					<td><fmt:message key="page.administration.title.ordre"/></td>
					<td><fmt:message key="page.administration.title.page"/></td>
					<td><fmt:message key="page.administration.title.visibility"/></td>
					<td><fmt:message key="page.administration.title.delete"/></td>
				</tr>
				<c:forEach var="page" items="${listePages}">
			
					<tr>
						<td>
							<a href="${ctx}/page/administrationPages.do?up=${page.id}">
								<img alt="<fmt:message key="page.up.alt"/>" src="${ctx }/images/fleche_haut.png" />
							</a>
							${page.ordre} 
							<a href="${ctx}/page/administrationPages.do?down=${page.id}">
								<img alt="<fmt:message key="page.down.alt"/>" src="${ctx }/images/fleche_bas.png" />
							</a>
						</td>
						<td>
							<a href="${ctx}/page/formulairePages.do?page=${page.id}">
								${page.title}
							</a>
						</td>
			
						<td>
							<a href="${ctx}/page/administrationPages.do?visible=${page.id}">
								<c:if test="${page.visible}">
									<img alt="<fmt:message key="page.visible.alt"/>" src="${ctx }/images/tick.png" />
								</c:if>
								<c:if test="${! page.visible}">
									<img alt="<fmt:message key="page.not_visible.alt"/>" src="${ctx }/images/non_droit.png" />
								</c:if> 
							</a>
						</td>
			
						<td>
							<a href="${ctx}/page/administrationPages.do?delete=${page.id}">
								<img alt=""<fmt:message key="page.delete.alt"/>" src="${ctx }/images/delete.png" />
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="lien">
				<a href="${ctx}/page/formulairePages.do">
					<fmt:message key="page.administration.add"/>
				</a>
			</div>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>