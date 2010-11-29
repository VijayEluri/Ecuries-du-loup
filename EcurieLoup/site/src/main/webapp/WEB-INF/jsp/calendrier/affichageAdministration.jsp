<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<%@ include file="../header.jsp"%>


<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.calendrier"/>

<div id="corps">
	<div class="navigation">
		&gt; <a	href="${ctx}/calendrier/affichage.do"><fmt:message key="calendrier.navigation.calendrier"/></a>
		&gt; <fmt:message key="calendrier.navigation.administration"/>
	</div>
	<div class="calendrier">
		<div class="visualisationTousLesTypesEvenements">
			<h1> <fmt:message key="calendrier.administration.title"/></h1>
		
		
		
			<a href="${ctx}/calendrier/administration/affichageEvenement.do"><fmt:message key="calendrier.administration.event_list"/></a> <br />
			<a href="${ctx}/calendrier/administration/affichageTypeEvenement.do"><fmt:message key="calendrier.administration.type_event_list"/> </a>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>