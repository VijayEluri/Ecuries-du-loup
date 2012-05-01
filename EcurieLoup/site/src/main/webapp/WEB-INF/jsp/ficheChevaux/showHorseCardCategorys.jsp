<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<%@ include file="../header.jsp"%>


<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.ficheChevaux"/>

<div id="corps">
	<div class="navigation">
		&gt; <fmt:message key="horsecard.browse.categoryslist"/>
	</div>
	<div class="fiche_chevaux">
		<div class="visualisationTousLesFiches">
			<h1> 
				<fmt:message key="horsecard.categoryslist.title"/>				
				
			</h1>
			 <c:forEach var="category" items="${categorys}">
				<c:if test="${not category.emptyCategory }">
					<a href="${ctx}/ficheChevaux/affichage.do?id=${category.id }">
					 	<div class="horseCard">
					 		<table width="100%" height="100px" align="center" valign="center">
								<tr>
									<td style="text-align: center">
								   		<img src="${ctx}/images/albumPhoto/miniatures/${category.mediaId}" />
									</td>
								</tr>
							</table>
					 		<div class="name">${category.name}</div>
					 	</div>
			 		</a>
			 	</c:if>
			 </c:forEach>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>