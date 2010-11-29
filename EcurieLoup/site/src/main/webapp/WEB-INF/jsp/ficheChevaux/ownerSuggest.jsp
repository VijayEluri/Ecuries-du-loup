<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<ul>
	<c:forEach var="user" items="${users}">
		<li>${user.login}</li>
	</c:forEach>
</ul>