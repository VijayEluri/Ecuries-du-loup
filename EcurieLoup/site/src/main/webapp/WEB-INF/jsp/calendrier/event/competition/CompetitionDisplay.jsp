<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime" prefix="dt"%>

<%@ include file="../../../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../../../menu.jsp"%>

<fmt:setBundle basename="i18n.calendrier"/>

<div id="corps">
	<div class="navigation">
		&gt; <fmt:message key="calendrier.navigation.calendrier"/>
	</div>
	
	<div class="calendrier">
		<h1>Concours</h1>
			<p><dt:format pattern="dd/MM/yyyy">${event.date }</dt:format><br/>
				${event.description }
			</p>
	</div>
</div>

<!-- on importe le pied de la page -->
<%@ include file="../../../foot.jsp"%>