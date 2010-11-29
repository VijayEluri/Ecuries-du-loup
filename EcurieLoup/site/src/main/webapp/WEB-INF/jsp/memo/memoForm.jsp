<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime" prefix="dt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.memo"/>

<div id="corps">
	<div class="navigation">
		&gt; <a href="${ctx}/memo/myMemos.do"><fmt:message key="memo.navigation.myMemos"/></a>
		&gt; <fmt:message key="memo.navigation.sendMemo"/>
	</div>
	
	<div class="memo">
		<div class="memoForm">
			<h1><fmt:message key="memo.form.title"/></h1>

			<spring:bind path="memo">
				<div class="error">
					<c:out value="${status.value}" />
					<c:out value="${status.errorMessage}" />
				</div>
			</spring:bind>
			
			<form method="post">
				<spring:bind path="memo.deadLine">
				 	<fmt:message key="memo.form.deadLine"/>
				 	<c:if test="${memo.deadLine > 0}">
						<input id="deadLine" type="text"
							value="<dt:format pattern="dd/MM/yyyy">${memo.deadLine }</dt:format>"
							readonly="readonly" name="deadLine" >
					</c:if>
	
					<c:if test="${memo.deadLine == 0}">
						<input id="deadLine" type="text"
							value="<dt:format pattern="dd/MM/yyyy"><dt:currentTime/></dt:format>"
							readonly="readonly" name="deadLine">
					</c:if>
					
					<input type="button" value=">"
						onclick="displayCalendar(document.getElementById('deadLine'),'dd/mm/yyyy',this)">			 
				 		&#160;
				 		<span class="error">
				 			<c:out value="${status.errorMessage}" />
				 		</span>
					</spring:bind>
					
					 <br />
					<spring:bind path="memo.receiver">
							<fmt:message key="memo.form.receiver"/>					    
						    <select name="receiver">
								<c:forEach var="user" items="${users}">
								<c:choose>
									<c:when test="${user.login == memo.receiver.login}">
										<option  selected="selected" value="${user.login }">${user.login } - ${user.nom } ${user.prenom }</option>
									</c:when>
									<c:otherwise>
										<option value="${user.login }">${user.login } - ${user.nom } ${user.prenom }</option>
									</c:otherwise>
								</c:choose>
										
								</c:forEach>
							</select>
					    	&#160;
					    	<span class="error">
					    	<c:out value="${status.errorMessage}" />
							</span>
					</spring:bind>
					
					 <br />
					<br />

					<spring:bind path="memo.description">
		 				<fmt:message key="memo.form.describe"/>
				      	<textarea name="description" cols="50" rows="5">${memo.description }</textarea>
				      	&#160;
				      	<span class="error">
				      		<c:out value="${status.errorMessage}" />
				      	</span>
					</spring:bind>
					 <br />
					<br />
					<input type="submit" value="<fmt:message key="memo.form.submit"/>" />
				</form>
			</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>

