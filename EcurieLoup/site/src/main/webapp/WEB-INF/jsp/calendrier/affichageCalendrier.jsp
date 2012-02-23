<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime" prefix="dt"%>

<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.calendrier"/>

<div id="corps">
	<div class="navigation">
		&gt; <fmt:message key="calendrier.navigation.calendrier"/>
	</div>
	
	<div class="calendrier">
		<h1><fmt:message key="calendrier.title"/></h1>
		
		
		<div class="iframe">
			<iframe src="https://www.google.com/calendar/embed?showTitle=0&amp;showPrint=0&amp;showCalendars=0&amp;showTz=0&amp;height=400&amp;wkst=2&amp;hl=fr&amp;bgcolor=%23ffffff&amp;src=4fegsr6g9bcjqe9vp0vdori5nc%40group.calendar.google.com&amp;color=%232952A3&amp;ctz=Europe%2FParis" style=" border-width:0 " width="500" height="400" frameborder="0" scrolling="no"></iframe>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>