<div class="photo_fiche">
	<c:choose>
		<c:when test="${ficheCheval.photoTete != null }">
			<div class="presentation_image">
				<img alt="photo tete du cheval"
					src="${ctx}/images/albumPhoto/view/${ficheCheval.photoTete.id}" />
					<div class="tooltip">
						<img alt="photo tete du cheval"
							src="${ctx}/images/albumPhoto/view/${ficheCheval.photoTete.id}" />
					</div>
			</div>
		</c:when>
		<c:otherwise>
			<img alt="pas de photo de la tete du cheval" src="" />
		</c:otherwise>
	</c:choose>
	<br />
	<c:choose>
		<c:when test="${ficheCheval.photoCorps != null }">
			<div class="presentation_image">
				<img alt="photo du corps du cheval"
					src="${ctx}/images/albumPhoto/view/${ficheCheval.photoCorps.id}"/>
				<div class="tooltip">
					<img alt="photo du corps du cheval"
						src="${ctx}/images/albumPhoto/view/${ficheCheval.photoCorps.id}" />
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<img alt="pas de photo du corps du cheval" src="" />
		</c:otherwise>
	</c:choose>
</div>
<div class="informations">
	<p>
	<h2>
		<fmt:message key="ficheChevaux.fiche.surnoms" />
	</h2>
	<div class="surnom">


		<c:forEach var="surnom" items="${ficheCheval.surnoms}">
						- ${surnom.surnom}<br />
		</c:forEach>
	</div>
	</p>

	<c:if test="${ficheCheval.owner  != null}">
		<p>
		<h2>
			<fmt:message key="ficheChevaux.fiche.owner" />
		</h2>
		<div class="owner">
			<c:choose>
				<c:when test="${ficheCheval.owner.user  != null}">
							${ficheCheval.owner.user.login} - ${ficheCheval.owner.user.prenom} ${ficheCheval.owner.user.nom}
						</c:when>
				<c:otherwise>
							${ficheCheval.owner.name}
						</c:otherwise>
			</c:choose>



		</div>
		</p>
	</c:if>
	<p>
	<h2>
		<fmt:message key="ficheChevaux.fiche.robe" />
	</h2>
	${ficheCheval.robe.nom}
	</p>

	<p>
	<h2>
		<fmt:message key="ficheChevaux.fiche.race" />
	</h2>
	${ficheCheval.race.nom}
	</p>

	<c:choose>
		<c:when test="${ficheCheval.dateNaissance != 0}">
			<p>
			<h2>
				<fmt:message key="ficheChevaux.fiche.dateNaissance" />
			</h2>
			<dt:format pattern="dd/MM/yyyy"> ${ficheCheval.dateNaissance}</dt:format>
			</p>
		</c:when>
		<c:otherwise>
			<p>
			<h2>
				<fmt:message key="ficheChevaux.fiche.anneeNaissance" />
			</h2>
							${ficheCheval.anneeNaissance}</p>
		</c:otherwise>
	</c:choose>
	<p>
	<h2>
		<fmt:message key="ficheChevaux.fiche.sexe" />
	</h2>
	${ficheCheval.sexe.nom}
	</p>

	<p>
	<h2>
		<fmt:message key="ficheChevaux.fiche.description" />
	</h2>
	${ficheCheval.description}
	</p>

</div>