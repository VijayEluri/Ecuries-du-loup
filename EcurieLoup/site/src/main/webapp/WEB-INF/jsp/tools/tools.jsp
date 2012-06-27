<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ include file="../header.jsp"%>

<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.album_photo"/>

<div id="corps">

	<div class="navigation">
		&gt; outils
	</div>
	
	<div class="tools">
			<h1>Les outils</h1>
			
			<div class="">
				<h2><a href="notifier/notifier.do" >Le notifier</a></h2>
				<p>Soyez prévenu en direct des nouveaux éléments sur le site (photos, messages...) sans même lancer un navigateur.</p>
			</div>
			
			<div class="">
				<h2><a href="windowsLiveCalendarGadget/windowsLiveCalendarGadget.do" >Windows Live Calendar Gadget</a></h2>
				<p>Retrouvez sur votre bureau windows, les prochains évènements du club.</p>
			</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>