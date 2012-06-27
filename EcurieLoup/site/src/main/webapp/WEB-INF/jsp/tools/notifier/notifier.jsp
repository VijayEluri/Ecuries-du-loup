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
		&gt; Le notifier
	</div>
	
	<div class="tools">
		<h1>Le notifier</h1>
		
		<div class="presentation">
			<p>
			Le notifier vous prévient, par un son et une notification en bas de l'écran, de nouvelles photos ou de nouveaux messages sur le site. Il permet également d'envoyer facilement un grand nombre de photos.<br />
			Installez le et vous n'avez plus à vous en occuper, il se lance et se met à jour tout seul.<br />
			Ce logiciel ne fonctionne que sous windows, et plus efficassement sous windows 7.
			</p>
		
			<h2>Installation</h2>
			
				<h3>Etape 1 : téléchargement</h3>
				<p>Rendez vous sur l'adresse <a href="http://ecuriesduloup.fr/notifier/publish.htm">http://ecuriesduloup.fr/notifier/publish.htm</a>.
				<br />
				<img alt="etape 1 page" src="${ctx}/images/tools/notifier/downloadPage.png" style="width: 90%"><br />
				Cliquez sur Installer.<br />
				<br />
				Le navigateur vous invite à enregistrer le fichier.	<br />			
				<img alt="etape 1 confirmation" src="${ctx}/images/tools/notifier/setupSave.png"><br />
				
				Confirmez en cliquant sur "Enregister le fichier".<br />
				<br />
				Le navigateur télécharge un fichier nommé "setup.exe".<br />
				
				<img alt="etape 1 downlaod" src="${ctx}/images/tools/notifier/downloadWindow.png"><br />
				Attendez la fin du téléchargement.
				
				</p>
				<h3>Etape 2 : installation</h3>
				<p>
				Une fois le téléchargement terminé, lancez le fichier "setup.exe".<br />
				<img alt="etape 2 downlaod end" src="${ctx}/images/tools/notifier/launchInstall.png"><br />
				<br />
				Autorisez l'application à s'installer en confirmant les autorisations en cliquant sur "Exécuter".
				<img alt="etape 2 secure" src="${ctx}/images/tools/notifier/ConfirmeSecure.png"><br />
				<br />
				Si vous n'avez pas les outils nécessaires, l'installation devrait les installer automatiquement. 
				Accepter la licence pour les différents outils utilisés dans le notifier .<br />
				<img alt="etape 2 agree licence" src="${ctx}/images/tools/notifier/agreeLicence.png"><br />
				<br />
				Les outils se téléchargent (attention, cela peut être long).<br />
				<img alt="etape 2 download .Net" src="${ctx}/images/tools/notifier/downloadDotNet.png"><br />
				<br />
				Acceptez que les outils s'installent.<br />
				<img alt="etape 2 download .Net" src="${ctx}/images/tools/notifier/agreeSecureDotNet.png"><br />
				<br />
				Les outils s'installent.<br />
				<img alt="etape 2 download .Net" src="${ctx}/images/tools/notifier/installDotNet.png"><br />
				<br />
				Autorisez l'application à s'installer <br />
				<img alt="etape 2 download .Net" src="${ctx}/images/tools/notifier/installAppli.png"><br />
				<br />
				L'application s'installe.<br />
				<img alt="etape 2 download .Net" src="${ctx}/images/tools/notifier/downloadAppli.png"><br />
				
				
				<h3>Etape 3 : configuration</h3>
				<p>
				L'application, pour allez interroger le site, a besoin de vos identifiants sur le site.<br />
				Entrez votre login et votre mot de passe dans la fenêtre qui s'ouvre.
				<img alt="etape 2 download .Net" src="${ctx}/images/tools/notifier/configureAppli.png"><br />
				<br />
				Il se peut qu'une demande de droits soit demander pour finir l'installation afin de créer des menus contextuels. Cliquez sur "Oui" autant de fois que nécessaire.
				<img alt="etape 2 download .Net" src="${ctx}/images/tools/notifier/allowRightManader.png"><br />
				</p>
				
				<p>Voila l'application fonctionne.
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../../foot.jsp"%>