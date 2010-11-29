<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime" prefix="dt"%>

<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.memo"/>



<div id="corps">

	<div class="navigation">
		&gt; <fmt:message key="memo.navigation.myMemos"/>
	</div>
	
	<div class="memo">
		<div class="showMyMemos">
			<h1><fmt:message key="memo.title.myMemos"/></h1>

			<div class="taskList">
				
				<h2><fmt:message key="memo.table.task.title"/></h2>
				<table>
					<tr>
						<th>
						</th>
						<th>
							<fmt:message key="memo.table.dealLine"/>
						</th>
						<th class="describe">
							<fmt:message key="memo.table.describe"/>
						</th>
						<th>
							<fmt:message key="memo.table.sender"/>
						</th>
						<th>
						</th>
					</tr>
					<c:if test="${empty myTasks}">
						<tr >
							<td colspan="5" align="center"><fmt:message key="memo.table.no_tasks"/></td>
						</tr>
					</c:if> 
					
					<c:forEach var="task" items="${myTasks}">
						<tr class="task_status_${task.status}" >
							<td>
								<c:if test="${!task.viewByReceiver}">
									<img class="petit_icone" 
										src="${ctx}/images/forum/nonLu.png" 
										alt="<fmt:message key="memo.table.new_task.alt"/>"
										title="<fmt:message key="memo.table.new_task.title"/>"
										 />
								</c:if>
							</td>
						
							<td>
								<dt:format pattern="dd/MM/yyyy">${task.deadLine}</dt:format>
							</td>
							<td>
								${task.description}
							</td>
							<td>
								${task.sender.login} - ${task.sender.nom} ${task.sender.prenom} 
							</td>	
							<td>
								<a href="${ctx}/memo/myMemos.do?do=${task.id}">
									<img src="${ctx}/images/tick.png" class="task_icone"
										alt="<fmt:message key="memo.table.do.alt"/>" 
										title="<fmt:message key="memo.table.do.title"/>"
									 />
								</a>
							
							</td>			
						</tr>
					</c:forEach>
				</table>
			</div>
		
			<div class="requestList">
				<h2><fmt:message key="memo.table.request.title"/></h2>
				<table>
					<tr>
						<th>
						</th>
						<th>
							<fmt:message key="memo.table.dealLine"/>
						</th>
						<th>
							<fmt:message key="memo.table.receiver"/>
						</th>
						<th class="describe">
							<fmt:message key="memo.table.describe"/>
						</th>
						<th>
						</th>
					</tr>
					<c:if test="${empty myRequests}">
						<tr >
							<td colspan="5" align="center"><fmt:message key="memo.table.no_request"/></td>
						</tr>
					</c:if> 
					<c:forEach var="request" items="${myRequests}">
					
						<tr>
							<td>
								<c:if test="${!request.viewByReceiver}">
									<img class="petit_icone" 
										src="${ctx}/images/forum/nonLu.png" 
										alt="<fmt:message key="memo.table.new_request.alt"/>"
										title="<fmt:message key="memo.table.new_request.title"><fmt:param value="${request.receiver.login}"/></fmt:message>"
										 />
								</c:if>
							</td>
							<td>
								<dt:format pattern="dd/MM/yyyy">${request.deadLine}</dt:format>
							</td>
							<td>
								${request.receiver.login}
							</td>
							
							<td>
								<c:choose>
									<c:when test="${request.memoIsDo}">
										<strike>	
											${request.description}
										</strike>
									</c:when>
									<c:otherwise>
										${request.description}
									</c:otherwise>
								</c:choose>
								
							</td>
							
							<td>
							
								<c:if test="${!request.memoIsDo}">
									<a href="${ctx}/memo/sendMemo.do?memo=${request.id}">
										<img src="${ctx}/images/edit.png" 
											alt="<fmt:message key="memo.table.edit.alt"/>" 
											title="<fmt:message key="memo.table.edit.title"/>"
										 />
									</a>
								</c:if>
								
								<a href="${ctx}/memo/myMemos.do?delete=${request.id}">
									<img src="${ctx}/images/delete.png" 
										alt="<fmt:message key="memo.table.delete.alt"/>" 
										title="<fmt:message key="memo.table.delete.title"/>"
									 />
								</a>
							</td>
										
						</tr>
						
					</c:forEach>
				</table>
				<div class="lien">
					<a href="${ctx}/memo/sendMemo.do">
						<fmt:message key="memo.request.add"/>						
					</a>
				</div>
			</div>

	 		
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>