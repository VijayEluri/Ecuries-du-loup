<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime" prefix="dt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.profil"/>

<!-- on place le corps du site (partie centrale) -->
<div id="corps">
	<spring:bind path="profil.login">
		<h1><fmt:message key="profil.title"/>${status.value}</h1>
	</spring:bind>
	
	<spring:bind path="profil">
		<div class="error">
			<c:out value="${status.value}" />
			<c:out value="${status.errorMessage}" />
		</div>
	</spring:bind>
	
	 <c:if test="${success eq 'true'}">
		<span class="success"><fmt:message key="profil.mise_a_jour_ok"/></span>
	</c:if>
	
	<form action="<c:url value="./profil.do"/>" method="POST">
	
		<spring:bind path="profil.login">
			<input type="hidden" name="login" value="<c:out value="${status.value}"/>" size="15" maxlength="50" />
		</spring:bind>
		
		<spring:bind path="profil.password">
		   	<fmt:message key="profil.form.password"/> 
			<input type="password" name="password" value="<c:out value="${status.value}"/>" size="15" maxlength="50" />
			&#160;
			<span class="error">
				<c:out value="${status.errorMessage}" />
			</span>
		</spring:bind>
		
		<br />
		<br />
		<spring:bind path="profil.nom">
			<fmt:message key="profil.form.name"/> 
			<input type="text" name="nom" value="<c:out value="${status.value}"/>" size="15" maxlength="50" />
			&#160;
			<span class="error">
				<c:out value="${status.errorMessage}" />
			</span>
		</spring:bind>
		<br />
		<spring:bind path="profil.prenom">
			<fmt:message key="profil.form.firstname"/> 
			<input type="text" name="prenom" value="<c:out value="${status.value}"/>" size="15" maxlength="50" />
			&#160;
			<span class="error">
				<c:out value="${status.errorMessage}" />
			</span>
		</spring:bind>
		<br />
		<spring:bind path="profil.email">
			<fmt:message key="profil.form.email"/>  
			<input type="text" name="email" value="<c:out value="${status.value}"/>" size="20" maxlength="50" />
			&#160;
			<span class="error">
				<c:out value="${status.errorMessage}" />
			</span>
		</spring:bind>
		<br />
		<br />
		<spring:bind path="profil.birthDate">
			<fmt:message key="profil.form.birthDate"/>  
			
			<c:choose>
				<c:when test="${profil.birthDate != 0}">
					<input id="birthDateFormat" type="text"
						value="<dt:format pattern="dd/MM/yyyy">${profil.birthDate }</dt:format>"
						readonly="readonly" name="TheDate" onchange="convertirProfilBirthDate()">
							
						<input id="birthDate" type="hidden"
							value="${profil.birthDate }" readonly="readonly" name="birthDate">
				</c:when>
				<c:otherwise>
					<input id="birthDateFormat" type="text" 
						value="<dt:format pattern="dd/MM/yyyy">0</dt:format>"
							readonly="readonly" name="TheDate" onchange="convertirProfilBirthDate()">
						<input id="birthDate" type="hidden"	value="<dt:currentTime/>" readonly="readonly" name="birthDate">
				</c:otherwise>
			</c:choose>
			<input type="button" value=">"
				onclick="displayCalendar(document.getElementById('birthDateFormat'),'dd/mm/yyyy',this)">			 
		 		&#160;
		 		<span class="error">
		 			<c:out value="${status.errorMessage}" />
		 		</span>
		</spring:bind>
		
		<br />
		<input type="submit" value="<fmt:message key="profil.form.submit"/> " />
	</form>
</div>

<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>
