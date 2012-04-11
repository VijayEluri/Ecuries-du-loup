<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime" prefix="dt"%>

<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.community" />

<script>
$(function() {
	$( "#tabsUserCard" ).tabs();
});
</script>


<div id="corps">

	<div class="navigation">
		&gt; <a href="${ctx}/community/list.do"><fmt:message
				key="community.navigation.list" />
		</a> &gt;
		<fmt:message key="community.navigation.card" />
	</div>

	<div class="userCommunityList">
		<div class="showMyMemos">
			<h1>
				<fmt:message key="community.title.card">
					<fmt:param>${userOfCard.login}</fmt:param>
				</fmt:message>
			</h1>


			<div id="tabsUserCard">
				<ul>
					<li><a href="#infos"><fmt:message key="community.tab.infos" /></a>
					</li>
					<li><a href="#photos"><fmt:message key="community.tab.photos" /></a>
					</li>
				</ul>
				<div id="infos">
					<%@ include file="./infos.jsp"%>
				</div>
				<div id="photos">
					<%@ include file="./photos.jsp"%>
				</div>

			</div>



		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>