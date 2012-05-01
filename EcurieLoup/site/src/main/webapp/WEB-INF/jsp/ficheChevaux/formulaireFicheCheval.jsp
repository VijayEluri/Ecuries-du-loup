<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime" prefix="dt"%>

<%@ include file="../header.jsp"%>


<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.ficheChevaux"/>

<div id="corps">
	<div class="navigation">
		&gt; <a href="${ctx}/ficheChevaux/categoryslist.do"><fmt:message key="horsecard.browse.categoryslist"/></a>
		&gt; <a href="${ctx}/ficheChevaux/affichage.do?id=${fiche.category}"><fmt:message key="ficheChevaux.navigation.listeFiche"/></a>
		&gt; <a href="${ctx}/ficheChevaux/affichageFiche.do?id=${fiche.id}"><fmt:message key="ficheChevaux.navigation.fiche">
		<fmt:param>${fiche.nom}</fmt:param>
		</fmt:message></a>
		&gt; <fmt:message key="ficheChevaux.navigation.formulaireFiche"/>
	</div>
	<div class="fiche_chevaux">
		<div class="formulaireFiche">
			<h1> <fmt:message key="ficheChevaux.FormulaireFiche.title"/></h1>
		
			<spring:bind path="fiche">
				<div class="error">
					<c:out value="${status.value}" />
					<c:out value="${status.errorMessage}" />
				</div>
			</spring:bind>
			
			<form method="post" name="ficheCheval">
				<spring:bind path="fiche.nom">
					<fmt:message key="ficheChevaux.formulaireFiche.name"/>
					<input type="text" name="nom" value="<c:out value="${fiche.nom}"/>" size="15" maxlength="50" />
					
					&#160;
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind>
				<br />
				
				<spring:bind path="fiche.photoTete">
					<fmt:message key="ficheChevaux.formulaireFiche.photoTete"/>
					<div id="imageHeadHorse" ></div>
					<input type="hidden" id="fieldHeadPicture" name="photoTete" value="<c:out value="${fiche.photoTete.id}"/>" size="15" maxlength="50" />
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind>
				<br />
				
				<spring:bind path="fiche.photoCorps">
					<fmt:message key="ficheChevaux.formulaireFiche.photoCorps"/>
					<div id="imageBodyHorse" ></div>
					<input type="hidden"id="fieldBodyPicture"  name="photoCorps" value="<c:out value="${fiche.photoCorps.id}"/>" maxlength="50" />
					&#160;
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind>
				<br />
				
				<spring:bind path="fiche.robe">
					<fmt:message key="ficheChevaux.formulaireFiche.robe"/>
					
					<select name="robe">
						 <c:forEach var="robe" items="${listeRobes}">
							 <c:choose>
							 	<c:when test="${robe.id == fiche.robe.id}">
							 		<option value="${robe.id }" selected="selected">${robe.nom}</option>
							 	</c:when>
							 	<c:otherwise>
							 		<option value="${robe.id }">${robe.nom}</option>
							 	</c:otherwise>
							 </c:choose>
						 </c:forEach>
					</select>
					&#160;
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind>
				<br />
				
				<spring:bind path="fiche.race">
					<fmt:message key="ficheChevaux.formulaireFiche.race"/>
					
					<select name="race">
						 <c:forEach var="race" items="${listeRaces}">
							 <c:choose>
							 	<c:when test="${race.id == fiche.race.id}">
							 		<option value="${race.id }" selected="selected">${race.nom}</option>
							 	</c:when>
							 	<c:otherwise>
							 		<option value="${race.id }">${race.nom}</option>
							 	</c:otherwise>
							 </c:choose>
						 </c:forEach>
					</select>
				
					&#160;
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind>
				<br />
				<fmt:message key="ficheChevaux.formulaireFiche.naissance.choise_by"/>
				<c:choose>
					<c:when test="${!fiche.estDateNaissanceChoisi}">
						<input type="radio" name="estDateNaissanceChoisi" value="false" id="radio_annee_naissance" checked="checked" onchange="changementTypeDateNaissance()" /><fmt:message key="ficheChevaux.formulaireFiche.naissance.choise_by_annee"/>
						<input type="radio" name="estDateNaissanceChoisi" value="true" id="radio_date_naissance" onchange="changementTypeDateNaissance()" /><fmt:message key="ficheChevaux.formulaireFiche.naissance.choise_by_date"/>
					</c:when>
					<c:otherwise>
						<input type="radio" name="estDateNaissanceChoisi" value="false" id="radio_annee_naissance"onchange="changementTypeDateNaissance()" /><fmt:message key="ficheChevaux.formulaireFiche.naissance.choise_by_annee"/>
						<input type="radio" name="estDateNaissanceChoisi" value="true" id="radio_date_naissance" checked="checked" onchange="changementTypeDateNaissance()" /><fmt:message key="ficheChevaux.formulaireFiche.naissance.choise_by_date"/>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${fiche.estDateNaissanceChoisi}">
						<div id="dateNaissance" class="date_visible">
					</c:when>
					<c:otherwise>
						<div id="dateNaissance" class="date_invisible">
					</c:otherwise>
				</c:choose>
				
					<spring:bind path="fiche.dateNaissance">
					 	<fmt:message key="ficheChevaux.formulaireFiche.dateNaissance"/>
					 	<c:choose>
						 	<c:when test="${fiche.dateNaissance > 0}">
								<input id="dateNaissanceCheval"  type="text"
									value="<dt:format pattern="dd/MM/yyyy">${fiche.dateNaissance}</dt:format>"
									readonly="readonly" name="TheDate" onchange="convertirDateNaissance()">
									
								<input id="dateDateNaissanceInTimestamp" type="hidden"
									value="${fiche.dateNaissance}" readonly="readonly" name="dateNaissance">
							</c:when>
			
							<c:otherwise>
								<input id="dateNaissanceCheval" type="text"
									value="<dt:format pattern="dd/MM/yyyy"><dt:currentTime/></dt:format>"
									readonly="readonly" name="TheDate" onchange="convertirDateNaissance()">
								<input id="dateDateNaissanceInTimestamp" type="hidden"
									value="<dt:currentTime/>" readonly="readonly" name="dateNaissance">
							</c:otherwise>
						</c:choose>
						
						<input type="button" value=">"
							onclick="displayCalendar(document.getElementById('dateNaissanceCheval'),'dd/mm/yyyy',this)">			 
					 		&#160;
					 	<span class="error">
					 		<c:out value="${status.errorMessage}" />
					 	</span>
					</spring:bind>
					<br />
				</div>	
				
				<c:choose>
					<c:when test="${fiche.estDateNaissanceChoisi}">
						<div id="anneeNaissance" class="date_invisible">
					</c:when>
					<c:otherwise>
						<div id="anneeNaissance" class="date_visible">
					</c:otherwise>
				</c:choose>
					<spring:bind path="fiche.anneeNaissance">
						<fmt:message key="ficheChevaux.formulaireFiche.anneeNaissance"/>
						<input type="text" name="anneeNaissance" value="<c:out value="${fiche.anneeNaissance}"/>" size="15" maxlength="50" />
						&#160;
						<span class="error">
							<c:out value="${status.errorMessage}" />
						</span>
					</spring:bind>
					<br />
				</div>
			
				<spring:bind path="fiche.sexe">
					<fmt:message key="ficheChevaux.formulaireFiche.sexe"/>
					<br />
					<select name="sexe">
						 <c:forEach var="sexe" items="${listeSexes}">
							 <c:choose>
							 	<c:when test="${sexe.id == fiche.sexe.id}">
							 		<option value="${sexe.id }" selected="selected">${sexe.nom}</option>
							 	</c:when>
							 	<c:otherwise>
							 		<option value="${sexe.id }">${sexe.nom}</option>
							 	</c:otherwise>
							 </c:choose>
						 </c:forEach>
					</select>
				
					&#160;
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind>
				<br />
				<spring:bind path="fiche.owner">
					<fmt:message key="ficheChevaux.formulaireFiche.owner"/>
				 	<input type="hidden" id="owner" name="owner" value="<c:out value="${fiche.owner}"/>" size="15" maxlength="50" />
					
					&#160;
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind>
				<br />
				<spring:bind path="fiche.category">
					<fmt:message key="ficheChevaux.formulaireFiche.category"/>
				 	<input type="hidden" id="category" name="category" value="<c:out value="${fiche.category}"/>" size="15" maxlength="50" />
					
					&#160;
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind>
				<script type="text/javascript">

				$(function() {
					$( "#category" ).suggestSavedChoose({});
				});

				</script>
				<br />
				<spring:bind path="fiche.surnoms">
					<fmt:message key="ficheChevaux.formulaireFiche.surnom"/>
					<c:forEach var="surnom" items="${fiche.surnoms}" >
						<input type="text" name="surnoms" value="<c:out value="${surnom}"/>" size="15" maxlength="50" /><br/>
					</c:forEach>
					<input type="text" name="surnoms" value="<c:out value="${surnom}"/>" size="15" maxlength="50" /><br/>
					&#160;
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind>
				<br />
				<spring:bind path="fiche.description">
					<fmt:message key="ficheChevaux.formulaireFiche.description"/><br >
					<textarea name="description" cols="70" rows="10"><c:out value="${fiche.description}"/></textarea>
					&#160;
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind>
				<br />
			
				<input class="boutton_enregistrer" type="submit" value="<fmt:message key="ficheChevaux.formulaireFiche.submit"/>" />
			</form>
		
			
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>