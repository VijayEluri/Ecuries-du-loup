<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<%@ include file="headerFacebook.jsp"%>

<fmt:setBundle basename="i18n.facebook"/>

<div id="facebook">
	<div id="corps">
		
		<div class="use_this">
			<fmt:message key="facebook.user.use_this.user_connected" >
				<fmt:param>
					${loginUser}
				</fmt:param>
			</fmt:message>
			
			<div class="lien">
				<a href="${ctx }/facebook/useUtilisateurConnecter.do">
					<fmt:message key="facebook.user.use_this.link" />
				</a>
			</div>
		
		</div>
		<div class="use_others">
			<div class="lien">
					<a href="${ctx }/facebook/entrerUtilisateur.do">
						<fmt:message key="facebook.user.use_others.link" />
					</a>
			</div>
		</div>
	</div>

</div>