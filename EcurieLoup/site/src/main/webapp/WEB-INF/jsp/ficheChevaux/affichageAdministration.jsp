<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime" prefix="dt"%>

<%@ include file="../header.jsp"%>


<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.ficheChevaux"/>

<div id="corps">
	<div class="navigation">
		&gt; <a href="${ctx}/ficheChevaux/affichage.do"><fmt:message key="ficheChevaux.navigation.listeFiche"/></a>
		&gt; <fmt:message key="ficheChevaux.navigation.administration"/>
	</div>
	<h1>Administration des fiches chevaux</h1>
	<div class="liste_choix_chevaux">
		<ul>
			<li><a href="${ctx}/ficheChevaux/administration/choixSexe.do"><fmt:message key="ficheChevaux.administration.sexe"/></a></li>
			<li><a href="${ctx}/ficheChevaux/administration/choixRace.do"><fmt:message key="ficheChevaux.administration.race"/></a></li>
			<li><a href="${ctx}/ficheChevaux/administration/choixRobe.do"><fmt:message key="ficheChevaux.administration.robe"/></a></li>
		</ul>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>