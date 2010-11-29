<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ include file="../header.jsp"%>

<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.notifier"/>

<div id="corps">

	<div class="navigation">
		&gt; <fmt:message key="notifier.navigation.use.list"/>
	</div>
	
	<div class="notifier.list">
		<h1>Utilisation du notifier</h1>
		<table>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>
						${user.login}
					</td>
					<td> 
						<c:choose>
							<%-- if never access with notifier --%>
							<c:when test="${user.lastAccessDateNotifier == 0}">
								<img src="${ctx}/images/notifier/never.png" alt="<fmt:message key="notifier.status.never.alt"/>" title="<fmt:message key="notifier.status.never.title"/>" />
							</c:when>
							<%-- notifier has running in last 3 day --%>
							<c:when test="${((now - user.lastAccessDateNotifier)/1000) < 0 }">
								<img src="${ctx}/images/notifier/excuses.png" alt="<fmt:message key="notifier.status.excuses.alt"/>" title="<fmt:message key="notifier.status.excuses.title"/>" />
							</c:when>
							<%-- notifier run --%>
							<c:when test="${((now - user.lastAccessDateNotifier)/1000) < 2 * 60 }">
								<img src="${ctx}/images/notifier/running.png" alt="<fmt:message key="notifier.status.running.alt"/>" title="<fmt:message key="notifier.status.running.title"/>" />
							</c:when>
							<%-- notifier has running in last 3 day --%>
							<c:when test="${((now - user.lastAccessDateNotifier)/1000) < 3* 24 * 60 *60 }">
								<img src="${ctx}/images/notifier/ok.png" alt="<fmt:message key="notifier.status.ok.alt"/>" title="<fmt:message key="notifier.status.ok.title"/>" />
							</c:when>
							
							
							
							<%-- notifier run but not recently --%>
							<c:otherwise>
								<img src="${ctx}/images/notifier/rarely.png" alt="<fmt:message key="notifier.status.bhou.alt"/>" title="<fmt:message key="notifier.status.bhou.title"/>" />
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>	
		</table>
		
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>