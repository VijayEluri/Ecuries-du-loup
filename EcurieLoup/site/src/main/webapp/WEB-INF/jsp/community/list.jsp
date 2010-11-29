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
		&gt; <fmt:message key="community.navigation.list"/>
	</div>
	
	<div class="userCommunityList">
		<div class="listUserCard">
			<h1><fmt:message key="community.title.list"/></h1>

			<div>
				<ul>
					<c:forEach var="user" items="${listCommunityUsers}">
						<li><a href="${ctx}/community/card.do?login=${user.login}">${user.login} - ${user.prenom} ${user.nom}</a></li>
					</c:forEach>
				</ul>
			
			</div>

	 		
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>