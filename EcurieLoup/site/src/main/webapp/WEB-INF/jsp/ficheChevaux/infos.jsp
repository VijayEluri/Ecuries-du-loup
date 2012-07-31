<div class="photo_fiche">
	<c:choose>
		<c:when test="${ficheCheval.photo != null }">
			<div class="presentation_image">
				<img alt="photo de ${ficheCheval.nom}"
					src="${ctx}/images/albumPhoto/view/${ficheCheval.photo.id}"/>
			</div>
		</c:when>
		<c:otherwise>
			<img alt="pas de photo de ${ficheCheval.nom}" src="" />
		</c:otherwise>
	</c:choose>
</div>
<div class="informations">
	<h2>${ficheCheval.nom}</h2>
	<p>
		<c:forEach var="surnom" items="${ficheCheval.surnoms}">
			alias <strong>${surnom.surnom}</strong> 
		</c:forEach>
	</p>

	<c:if test="${ficheCheval.owner  != null}">
		<div class="owner">
			<span><fmt:message key="ficheChevaux.formulaireFiche.owner" /></span>
			<c:choose>
				<c:when test="${ficheCheval.owner.user  != null}">
							<a href="${ctx}/community/card.do?login=${ficheCheval.owner.user.login}">${ficheCheval.owner.user.prenom} ${ficheCheval.owner.user.nom}</a> 
						</c:when>
				<c:otherwise>
							${ficheCheval.owner.name}
						</c:otherwise>
			</c:choose>



		</div>
	</c:if>
	

	<p>
	<span><fmt:message key="ficheChevaux.formulaireFiche.race" /></span> ${ficheCheval.race.nom}
	</p>
	
	
	<div class="info_visual">
		<div>
			<img class="robe_img" alt="${ficheCheval.robe.nom}" src="${ctx}/images/horsesCards/robes/${ficheCheval.robe.id}" title="${ficheCheval.robe.nom}" />
		</div>
		<div>
			<img alt="${ficheCheval.sexe.nom}" src="${ctx}/images/horsesCards/sex/${ficheCheval.sexe.id}" title="${ficheCheval.sexe.nom}" />
		</div>
		<div class="div_birthday_calendar">
			<c:choose>
				<c:when test="${ficheCheval.dateNaissance != 0}">
					<div class="birthday_calendar_arround">
						<div class="birthday_calendar">
							<div class="day">
								<dt:format pattern="dd"> ${ficheCheval.dateNaissance}</dt:format>
							</div>
							<div class="month">
								<dt:format pattern="MMM"> ${ficheCheval.dateNaissance}</dt:format>
							</div>
							<div class="year">
								<dt:format pattern="yyyy"> ${ficheCheval.dateNaissance}</dt:format>
							</div>
							<div class="age" title="<fmt:message key="ficheChevaux.fiche.age.complete">
								<fmt:param>${yearhorseAge}</fmt:param>
								<fmt:param>${monthhorseAge}</fmt:param>
								<fmt:param>${dayhorseAge}</fmt:param>
								</fmt:message>" >
								<fmt:message key="ficheChevaux.fiche.age.year">
									<fmt:param>${yearhorseAge}</fmt:param>
								</fmt:message>
							</div>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="birthday_calendar_arround">
						<div class="birthday_calendar">
							<div class="day">
								${ficheCheval.anneeNaissance}
							</div>
							<div class="age" title="<fmt:message key="ficheChevaux.fiche.age.complete">
									<fmt:param>${yearhorseAge}</fmt:param>
									<fmt:param>${monthhorseAge}</fmt:param>
									<fmt:param>${dayhorseAge}</fmt:param>
								</fmt:message>" >
								<fmt:message key="ficheChevaux.fiche.age.year">
									<fmt:param>${yearhorseAge}</fmt:param>
								</fmt:message>
							</div>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	
	</div>
	
	<div class="description">
		<c:if test="${ficheCheval.description != null}">
			<span><fmt:message key="ficheChevaux.formulaireFiche.description" /></span><br />
			${ficheCheval.description}
		</c:if>
	</div>

</div>