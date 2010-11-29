<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="../../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../../menu.jsp"%>

<fmt:setBundle basename="i18n.forum"/>

<!-- on place le corps du site (partie centrale) -->
<div id="corps">
	<div class="forum">
		<div class="navigation">
			&gt; <a href="${ctx}/forum/affichage.do"><fmt:message key="forum.navigation.forum"/></a>
			&gt; <a href="${ctx}/forum/administration/administration.do"><fmt:message key="forum.navigation.administration"/></a>
			&gt; <a href="${ctx}/forum/administration/gestionCategorieSmiley.do"><fmt:message key="forum.navigation.smiley.categorie_manager"/></a>
			&gt; <a	href="${ctx}/forum/administration/gestionSmiley.do?categorie=${smiley.categorieSmiley }"><fmt:message key="forum.navigation.smiley.smiley_manager"/></a> 
			&gt; <fmt:message key="forum.navigation.smiley.smiley_manager.form"/>
		</div>
	
		<div class="formulaireCategorie">
			<h1><fmt:message key="smiley.smiley.title"/></h1>
			
			<spring:bind path="smiley">
				<div class="error">
					<c:out value="${status.value}" />
				 	<c:out	value="${status.errorMessage}" />
				 </div>
			</spring:bind>
	
			<form method="post" enctype="multipart/form-data">
			
				<spring:bind path="smiley.code">
					<fmt:message key="smiley.smiley.form.code"/>
					<input type="text" name="code" size="15" maxlength="50" value="${smiley.code}" />
					&#160;
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind>
				 <br />
				<spring:bind path="smiley.image">
					<fmt:message key="smiley.smiley.form.picture"/>
					<input type="File" name="image" value="${smiley.image }" />
					&#160;
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind>
				<br />
				<input class="boutton_enregistrer" type="submit" value="<fmt:message key="smiley.smiley.form.submit"/>" />
			</form>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../../foot.jsp"%>

