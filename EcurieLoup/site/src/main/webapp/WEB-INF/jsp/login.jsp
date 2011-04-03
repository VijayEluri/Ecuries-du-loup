
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<%@ include file="header.jsp"%>

<fmt:setBundle basename="i18n.login"/>

<!-- on importe le haut de la page -->

	
<div class="login">

	<h1><fmt:message key="login.title"/></h1>

	<c:if test="${not empty param.error}">
		<div class="error">
			<fmt:message key="login.error"/>
		</div>
	</c:if>
		
	<form action="${ctx}/j_spring_security_check" method="post">
		<div class="labels">
			<ul>
				<li><fmt:message key="login.login"/></li>
				<li><fmt:message key="login.password"/></li>
				<li><fmt:message key="login.remembre_me"/></li>
				</ul>
			</div>
			
			<div class="champs">
				<ul>
					<li><input type="text" name="j_username" size="20" maxlength="50" /></li>
					<li><input type="password" name="j_password" size="20"
						maxlength="50" /></li>
					<li><input type="checkbox" name="_spring_security_remember_me"
						checked="checked" /></li>
				</ul>
			
			</div>
<br />
			<a id="retour" href="${ctx}/index.do">
			<input id="bouton_retour" type="button" value="<fmt:message key="login.cancel"/>" />
		</a>
		<input id="bouton_connexion"type="submit" value="<fmt:message key="login.connection"/>" />
	</form>
	<a href="${ctx}/passwordLose.do"><fmt:message key="login.forget_password"/></a>
	<a href="${ctx}/inscription.do"><fmt:message key="login.register"/></a>
</div>



<!-- on importe le pied de la page -->
<%@ include file="foot.jsp"%>

