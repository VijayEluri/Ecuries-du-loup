<table>
	<tr>
		<td><fmt:message key="community.card.name" /></td>
		<td>${userOfCard.nom}</td>
	</tr>
	<tr>
		<td><fmt:message key="community.card.firstname" /></td>
		<td>${userOfCard.prenom}</td>
	</tr>

	<tr>
		<td><fmt:message key="community.card.email" /></td>
		<td><a href="mailto:${userOfCard.email}">${userOfCard.email}</a>
		</td>
	</tr>
	<c:if test="${userOfCard.birthDate != 0 }">
		<tr>
			<td><fmt:message key="community.card.birthdate" /></td>
			<td><dt:format pattern="dd MMM yyyy">${userOfCard.birthDate }</dt:format>
			</td>
		</tr>
	</c:if>


	<tr>
		<td><fmt:message key="community.card.creationDate" /></td>
		<td><fmt:formatDate value="${userOfCard.creationDate}" /></td>
	</tr>

	<tr>
		<td><fmt:message key="community.card.lastAccessDate" /></td>
		<td><fmt:formatDate value="${userOfCard.lastAccessDate}" /></td>
	</tr>

</table>