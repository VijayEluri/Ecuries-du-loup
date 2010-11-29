<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime" prefix="dt"%>

<%@ include file="../header.jsp"%>


<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.ficheChevaux"/>

<div id="corps">
	<div class="navigation">
		&gt; <a href="${ctx}/ficheChevaux/affichage.do"><fmt:message key="ficheChevaux.navigation.listeFiche"/></a>
		&gt; <a href="${ctx}/ficheChevaux/administration/administration.do"><fmt:message key="ficheChevaux.navigation.administration"/></a>
		&gt; <a href="${ctx}/ficheChevaux/administration/choix${nomChoix}.do">${nomChoix}</a>
		&gt; <fmt:message key="ficheChevaux.navigation.formulaireChoix"/>
	</div>
	<div class="fiche_chevaux">
		<div class="formulaireFiche">
			<h1> <fmt:message key="ficheChevaux.formulaireChoix.title">
					<fmt:param value="${nomChoix}"/>
				</fmt:message>
			</h1>
		
			<spring:bind path="choix">
				<div class="error">
					<c:out value="${status.value}" />
					<c:out value="${status.errorMessage}" />
				</div>
			</spring:bind>
			
			<form method="post">
				<spring:bind path="choix.nom">
					<fmt:message key="ficheChevaux.formulaireChoix.name"/>
					<input type="text" name="nom" value="<c:out value="${choix.nom}"/>" size="15" maxlength="50" />
					&#160;
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind>
				<br />
				
				
				<input class="boutton_enregistrer" type="submit" value="<fmt:message key="ficheChevaux.formulaireChoix.submit"/>" />
			</form>
		
			
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>