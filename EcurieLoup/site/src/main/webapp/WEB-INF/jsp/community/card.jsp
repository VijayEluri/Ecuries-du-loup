<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime" prefix="dt"%>

<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.community"/>



<div id="corps">

	<div class="navigation">
		&gt; <a href="${ctx}/community/list.do"><fmt:message key="community.navigation.list"/></a>
		&gt; <fmt:message key="community.navigation.card"/>
	</div>
	
	<div class="userCommunityList">
		<div class="showMyMemos">
			<h1><fmt:message key="community.title.card">
					<fmt:param >${userOfCard.login}</fmt:param>
				</fmt:message>
			</h1>
		
		<table>
			<tr>
				<td>
					<fmt:message key="community.card.name"/>
				</td>
				<td>
					${userOfCard.nom}
				</td>
			</tr>
			<tr>
				<td>
					<fmt:message key="community.card.firstname"/>
				</td>
				<td>
					${userOfCard.prenom}
				</td>
			</tr>
			
			<tr>
				<td>
					<fmt:message key="community.card.email"/>
				</td>
				<td>
					<a href="mailto:${userOfCard.email}">${userOfCard.email}</a>
				</td>
			</tr>
			<c:if test="${userOfCard.birthDate != 0 }">
				<tr>
					<td>
						<fmt:message key="community.card.birthdate"/>
					</td>
					<td>
						<dt:format pattern="dd MMM yyyy">${userOfCard.birthDate }</dt:format>
					</td>
				</tr>
			</c:if>
			
			
			<tr>
				<td>
					<fmt:message key="community.card.creationDate"/>
				</td>
				<td>
					<fmt:formatDate value="${userOfCard.creationDate}" />
				</td>
			</tr>
			
			<tr>
				<td>
					<fmt:message key="community.card.lastAccessDate"/>
				</td>
				<td>
					<fmt:formatDate value="${userOfCard.lastAccessDate}"/>
				</td>
			</tr>
		
		</table>

	 		
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>