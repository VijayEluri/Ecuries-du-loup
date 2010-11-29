<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<fmt:setBundle basename="i18n.general"/>

<%
 request.setAttribute("ctx", request.getContextPath());
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		
		
		<title><fmt:message key="general.meta.title"/></title>
		
		
		<link rel="icon" type="image/png" href="${ctx}/images/logo.png" />
		
		<!-- lien css -->
		<link rel="stylesheet" media="screen" type="text/css" title="Ecuries du loup" href="${ctx}/css/general.css" />
		
		<!-- lien javascript -->
		<!-- scriptaculous 
		<script src="${ctx}/js/prototype.js" type="text/javascript"></script>
		<script src="${ctx}/js/scriptaculous.js" type="text/javascript"></script>
	-->
		<script language="javascript" src="${ctx}/js/gestionVariable.js"> </script>
		<script language="javascript">
			set_ctx("${ctx}");
		</script>
		<script language="javascript" src="${ctx}/js/edlCode.js"> </script>
		
		<!-- pou la palette de couleurs -->
		<link rel="stylesheet" href="${ctx}/mooRainbow.css" type="text/css" />
		
		<script src="${ctx}/mootools.js" type="text/javascript"></script>
		<script src="${ctx}/mooRainbow.js" type="text/javascript"></script>
		
		
		<script type="text/javascript">
				window.addEvent('load', function() {
		
					new MooRainbow('couleurText', {
					id: 'couleurText',
					wheel: true,
					imgPath: "${ctx}/images/",
					onChange: function(color) {
						$('couleurEdlCode').value = color.hex;
					},
					onComplete: function(color) {
						$('couleurEdlCode').value = color.hex;
					}
					});
		
					new MooRainbow('couleurFond', {
						id: 'couleurFond',
						wheel: true,
						imgPath: "${ctx}/images/",
						onChange: function(color) {
							$('couleurFondEdlCode').value = color.hex;
						},
						onComplete: function(color) {
							$('couleurFondEdlCode').value = color.hex;
						}
						});
		
					new MooRainbow('couleurBoutonTypeEvenement', {
						id: 'couleurTypeEvenement',
						wheel: true,
						imgPath: "${ctx}/images/",
						onChange: function(color) {
							$('couleurTypeEvenement').value = color.hex;
						},
						onComplete: function(color) {
							$('couleurTypeEvenement').value = color.hex;
						}
						});
			});
		
		</script>
		
		<!--pour les calendrier -->
		
		<link type="text/css" rel="stylesheet"
			href="${ctx}/dhtmlgoodies_calendar/dhtmlgoodies_calendar.css?random=20051112"
			media="screen"></link>
		<script type="text/javascript"
			src="${ctx}/dhtmlgoodies_calendar/dhtmlgoodies_calendar.js?random=20060118"></script>
		<script language="javascript" src="${ctx}/js/calendrier.js"> </script>
		
		<!-- pour le tagage des photo -->
		<script language="javascript" src="${ctx}/js/tagagePhoto.js"> </script>
		
		
		<script language="javascript" src="${ctx}/js/ajoutAlbum.js"> </script>
		<!-- le les fiche chevaux -->
		<script language="javascript" src="${ctx}/js/ficheChevaux.js"> </script>
		<!-- le les profil -->
		<script language="javascript" src="${ctx}/js/profil.js"> </script>
		<!-- la visionneuse -->
		<script language="javascript" src="${ctx}/js/visionneuse.js"> </script>
	</head>
	
	
	<body>
	<!-- la partie de pr�sentation du site (banni�re, titre, ...)-->
		<div id="header">
			<img src="${ctx}/images/Lesecuriesduloup_banniere.jpg" alt="<fmt:message key="general.header.title"/>" />
			
		</div>
				