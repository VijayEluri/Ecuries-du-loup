<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<fmt:setBundle basename="i18n.menu"/>

<div id="menu">
	<div class="element_menu">

		<h3><fmt:message key="menu.modulaire.title"/>
			<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_ADMIN">
				<a href="${ctx}/page/administrationPages.do">
					<img src="${ctx}/images/edit.png" alt="<fmt:message key="menu.modulaire.edit.alt"/>" title="<fmt:message key="menu.modulaire.edit.title"/>" />
				</a>
			</security:authorize>
		</h3>

		<ul>
			<li><a href="${ctx}/index.do"><fmt:message key="menu.modulaire.welcome"/></a></li>
			<c:forEach var="page" items="${listePagesPresentation}">
				<li><a href="${ctx}/presentation.do?page=${page.id}">${page.lien}</a></li>
			</c:forEach>
			<li><a href="${ctx}/ficheChevaux/categoryslist.do"><fmt:message key="menu.membre.fiche_chevaux"/></a></li>
		</ul>
	</div>

	<div class="element_menu">
		<h3><fmt:message key="menu.membre.title"/></h3>
		<ul>
			<li>
				<security:authorize ifAllGranted="ROLE_AUTHENTIFIER">
					<div id="forumNotifier" class="notifier"></div>		
				</security:authorize>		
				<a href="${ctx}/forum/affichage.do">
					<fmt:message key="menu.membre.forum"/>
				</a>
			</li>
			<li>
				<security:authorize ifAllGranted="ROLE_AUTHENTIFIER">
					<div id="mediaNotifier" class="notifier"></div>
				</security:authorize>
				<a href="${ctx}/albumPhoto/affichage.do">
					<fmt:message key="menu.membre.album_photo"/>
				</a>
			</li>
			<li><a href="${ctx}/calendrier/affichage.do"><fmt:message key="menu.membre.calendrier"/></a></li>
			<li><a href="${ctx}/community/list.do"><fmt:message key="menu.membre.community"/></a></li>
		</ul>
	</div>
	
	
	<security:authorize ifAllGranted="ROLE_AUTHENTIFIER">
		<div class="element_menu">
			<!-- <img id="breizhFlag" alt="<fmt:message key="menu.bzh.alt"/>" src="${ctx}/images/bzh.jpg" />-->
			<div id="secretFlag" ></div>
		</div>
	</security:authorize>
	
	
</div>

<div id="liens">
	<div class="element_menu">
		<h3><fmt:message key="menu.connection.title"/></h3>
		
		<ul>

			<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_ADMIN">
				<li><a href="${ctx}/administration/affichage.do"><fmt:message key="menu.connection.administration"/></a></li>
			</security:authorize>
			<security:authorize ifAllGranted="ROLE_AUTHENTIFIER">
				<li>
				
					<a href="${ctx}/memo/myMemos.do">
						<c:if test="${ hasNewTask}">
							<img alt="*" src="${ctx}/images/forum/nonLu.png" class="icon_list" title="<fmt:message key="menu.connection.myMemos.new.title" />"/>
						</c:if>
						<span class="menu_memo_task_status_${memoStatus}"><fmt:message key="menu.connection.myMemos"/></span>
					</a>
				</li>
				<li><a href="${ctx}/tools/tools.do">outils</a></li>
				<li><a href="${ctx}/compte/profil.do"><fmt:message key="menu.connection.profil"/></a></li>
				<li>
					<a href="${ctx}/j_spring_security_logout"><fmt:message key="menu.connection.logout"/></a>
				</li>
			</security:authorize>
			<security:authorize ifNotGranted="ROLE_AUTHENTIFIER">
				<li><a href="${ctx}/login.do"><fmt:message key="menu.connection.connect_you"/></a></li>
				<li><a href="${ctx}/inscription.do"><fmt:message key="menu.connection.register_you"/></a></li>
			</security:authorize>
			
		</ul>
	</div>


	
	<div class="element_menu">
		<h3><fmt:message key="menu.lien.title"/></h3>
		<ul>
			<c:forEach var="lien" items="${listeLien}">
				<li><a href="${lien}" target="_blank">${lien}</a></li>
			</c:forEach>
		</ul>
	</div>
</div>

