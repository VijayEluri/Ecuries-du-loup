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
		
		<!-- facebook tag -->
		<c:if test="${mediaId != null && mediaId != 0 }">
			<meta property="og:title" content="Les écuries du loup : photo ${mediaId}" />
			<meta property="og:type" content="article" />
			
				<meta property="og:url" content="http://${header['host']}${ctx}/facebook/albumPhoto/affichagePhoto.do?mediaId=${mediaId}" />
			
			<meta property="og:image" content="http://${header['host']}${ctx}/images/albumPhoto/miniatures/${mediaId}" />
			<meta property="og:site_name" content="Les écuries du loup" />
			<meta property="fb:app_id" content="277479594509" />
		</c:if>
		
		<link rel="icon" type="image/png" href="${ctx}/images/logo.png" />
		
		
		<!-- jquery -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js" type="text/javascript"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" media="screen" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/themes/smoothness/jquery.ui.all.css" />
		<link rel="stylesheet" type="text/css" media="screen" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
		<script src="${ctx}/js/photoAlbumPlugin.js" type="text/javascript"> </script>
		<script src="${ctx}/js/commentsPlugin.js" type="text/javascript"> </script>
		<script src="${ctx}/js/EdlElementSuggestList.js" type="text/javascript"> </script>
		<script src="${ctx}/js/SuggestSavedChoose.js" type="text/javascript"> </script>
		<script src="${ctx}/js/MediaDisplayer.js" type="text/javascript"> </script>
		
		
		<!-- pour le tagage des photo -->
		<script src="${ctx}/js/tagagePhoto.js" type="text/javascript"> </script>
		
		
		
			
		<script src="${ctx}/js/gestionVariable.js" type="text/javascript"> </script>
		<script type="text/javascript">
			set_ctx("${ctx}");
			set_host("${header['host']}");
		</script>
		
		<script> var isomorphicDir = ctx+"/gwtg/sc/"; </script>
		<script src="${ctx}/js/edlCode.js" type="text/javascript"> </script>
		
		<!-- pou la palette de couleurs -->
		<link rel="stylesheet" href="${ctx}/mooRainbow.css" type="text/css" />
		
		<!--  <script src="${ctx}/mootools.js" type="text/javascript"></script>
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
		
		</script>-->
		
		<!--pour les calendrier -->
		
		<link type="text/css" rel="stylesheet"
			href="${ctx}/dhtmlgoodies_calendar/dhtmlgoodies_calendar.css?random=20051112"
			media="screen"></link>
		<script type="text/javascript"
			src="${ctx}/dhtmlgoodies_calendar/dhtmlgoodies_calendar.js?random=20060118"></script>
		<script src="${ctx}/js/calendrier.js" type="text/javascript"> </script>
		
		
		
		<script src="${ctx}/js/ajoutAlbum.js" type="text/javascript"> </script>
		<!-- le les fiche chevaux -->
		<script src="${ctx}/js/ficheChevaux.js" type="text/javascript"> </script>
		<!-- le les profil -->
		<script src="${ctx}/js/profil.js" type="text/javascript"> </script>
		
		 <!--                                           -->
    <!-- This script loads your compiled module.   -->
    <!-- If you add any GWT meta tags, they must   -->
    <!-- be added before this line.                -->
    <!--                                           -->
    <script type="text/javascript" language="javascript" src="${ctx}/gwtg/gwtg.nocache.js"></script>
	
	
	<!-- lien css -->
		<link rel="stylesheet" media="screen" type="text/css" title="Ecuries du loup" href="${ctx}/css/general.css" />
	</head>
	
	
	<body>
	<!-- la partie de prï¿½sentation du site (banniï¿½re, titre, ...)-->
		<div id="header">
			<img src="${ctx}/images/Lesecuriesduloup_banniere.jpg" alt="<fmt:message key="general.header.title"/>" />
			
		</div>
				