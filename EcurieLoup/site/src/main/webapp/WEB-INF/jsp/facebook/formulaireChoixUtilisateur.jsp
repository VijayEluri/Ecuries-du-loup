<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<%@ include file="headerFacebook.jsp"%>

<fmt:setBundle basename="i18n.facebook"/>

<div id="facebook">
	<div id="corps">
		
		<p><fmt:message key="facebook.choix_user.description"/></p>
		
		<spring:bind path="user">
				<div class="error">
					<c:out value="${status.value}" />
					<c:out value="${status.errorMessage}" />
				</div>
			</spring:bind>
			
			<form method="post">
				<spring:bind path="user.username">
					<fmt:message key="facebook.choix_user.username"/>
					<input type="text" name="username" size="15" maxlength="50" value="${user.username }" />
					&#160;
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind>
				<br />
				<spring:bind path="user.password">
			    	<fmt:message key="facebook.choix_user.password"/>
			    	<input type="password" name="password" size="15" maxlength="50" />
			    	&#160;
					<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind>
 				<br />
				
				<input class="boutton_enregistrer" type="submit" value="<fmt:message key="facebook.choix_user.submit"/>" />
			</form>
			<div>
				<fmt:message key="facebook.choix_user.inscription.link"/>
				<div class="lien">
					<a href="${ctx}/inscription.do" target="_blank" >
						<fmt:message key="facebook.choix_user.inscription.link"/>
					</a>
				</div>
			</div>
			
	</div>

</div>