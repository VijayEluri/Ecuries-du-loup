<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ include file="../../header.jsp"%>

<!-- on importe le haut de la page -->
<%@ include file="../../menu.jsp"%>

<fmt:setBundle basename="i18n.album_photo"/>

<div id="corps">

	<div class="navigation">
		&gt; <a href="${ctx}/tools/tools.do">Les outils</a>
		&gt; Windows Live Calendar Gadget
	</div>
	
	<div class="tools">
		<h1>Windows Live Calendar Gadget</h1>
		
		<div class="presentation">
			<p>
			Windows Live Calendar Gadget est un widget de bureau Windows permettant d'afficher les prochains évènements renseignés sur le site du club. N'oubliez plus la fête du club ou le prochain concours.<br />
			Fonctionne uniquement sur windows 7. 
			</p>
		
			<h2>Installation</h2>
			
				<h3>Etape 1 : téléchargement</h3>
				<p>
				Télécharger Windows Live Calendar Gadget <a href="http://wlcalendargadget.codeplex.com/downloads/get/84159">ici</a>.<br />
				<img alt="etape 1 download" src="${ctx}/images/tools/windowsLiveCalendarGadget/download.png"  style="width: 90%" ><br />
				Lancez le.				
				
				
				</p>
				<h3>Etape 2 : installation</h3>
				<p>
				Lancer l'installation en cliquant sur "Installer".<br />
				<img alt="etape 2 install" src="${ctx}/images/tools/windowsLiveCalendarGadget/install.png" ><br />
				</p>
				
				
				<h3>Etape 3 : configuration</h3>
				<p>
				Après quelques instants, apparait, en haut à droite de votre bueau, le widget en question.<br />
				<img alt="etape 2 install" src="${ctx}/images/tools/windowsLiveCalendarGadget/configure.png" style="width: 90%" ><br /> <br />
				Cliquez sur la clé (options) pour ouvrir le panneau de configuration du widget <br />
				<img alt="etape 2 install" src="${ctx}/images/tools/windowsLiveCalendarGadget/configure_2.png" ><br /> <br />
				Dans le premier champs, renseignez l'url du calendrier google du club : <br />
				<a href="https://www.google.com/calendar/ical/4fegsr6g9bcjqe9vp0vdori5nc%40group.calendar.google.com/public/basic.ics">https://www.google.com/calendar/ical/4fegsr6g9bcjqe9vp0vdori5nc%40group.calendar.google.com/public/basic.ics</a><br />
				(attention à ne renseigner que cette adresse, sans blanc autour)<br />
				<br />
				Cliquez sur OK. <br />
				Le calendrier charge les évènements. <br />
				</p>
				
				<p>
				Voila l'application fonctionne. <br />
				 <br />
				Une 2ieme vue existe en cliquand l'icone représentant une flèche et un carré.	 <br />			
				<img alt="etape 2 install" src="${ctx}/images/tools/windowsLiveCalendarGadget/large.png" ><br />
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../../foot.jsp"%>