
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<!-- on place le corps du site (partie centrale) -->
<div id="corps">
	<div class="page">${ contenuPage }</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>

