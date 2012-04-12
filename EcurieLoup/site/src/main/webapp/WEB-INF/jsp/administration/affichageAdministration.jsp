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
		&gt; <fmt:message key="administraction.navigation.administration"/>
	</div>
	
	<h1><fmt:message key="administraction.title"/></h1>
	<div class="administration">
		<a href="${ctx }/administration/gestionDroit.do"><fmt:message key="administraction.menu.rights_management"/></a><br />
		<a href="${ctx }/administration/gestionUtilisateur.do"><fmt:message key="administraction.menu.users_management"/></a><br />
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>