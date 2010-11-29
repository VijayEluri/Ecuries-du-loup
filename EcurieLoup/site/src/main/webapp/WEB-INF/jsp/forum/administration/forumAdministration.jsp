<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>



<%@ include file="../../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../../menu.jsp"%>

<fmt:setBundle basename="i18n.forum" />

<!-- on place le corps du site (partie centrale) -->
<div id="corps">
	<div class="navigation">
		&gt; <a href="${ctx}/forum/affichage.do"><fmt:message key="forum.navigation.forum"/></a>
		&gt; <fmt:message key="forum.navigation.administration"/>
	</div>

	<div class="forum">
		<div class="administration">
			<h1><fmt:message key="forum.administration.title"/></h1>



			<a href="${ctx}/forum/administration/gestionCategorieSmiley.do"><fmt:message key="forum.administration.smiley_manager"/></a> <br />


</div>
</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../../foot.jsp"%>