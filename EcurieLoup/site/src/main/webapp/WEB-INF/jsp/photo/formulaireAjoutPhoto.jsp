<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>


<fmt:setBundle basename="i18n.album_photo"/>

<div id="corps">
	<div class="albumPhoto">
		<div class="formulairePhoto">
			<h1><fmt:message key="album_photo.photo.form.title"/></h1>
			
			<spring:bind path="photo">
				<div class="error">
					<c:out value="${status.value}" />
				</div>
			</spring:bind>
			
			<div id="ajout_album_formulaire">
				<div id="formulairePhotoSimple" class="ajout_album_parti_non_selected">
					<%@ include file="./formulairePhotoSimple.jsp"%>
				</div>
				<div id="formulaireDaD" class="ajout_album_parti_selected">
					<%@ include file="./formulairePhotoDaD.jsp"%>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			selectPossibleForm();
		</script>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>

