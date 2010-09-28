<%@ include file="/common/taglibs.jsp"%>

<c:if test="${pageContext.request.locale.language != 'en'}">
    <div id="switchLocale"><a href="<c:url value='/?locale=en'/>"><fmt:message key="webapp.name"/> in English</a></div>
</c:if>

<div class="container container_32">
	
	<div class="grid_4">
		<h1><a href="<c:url value='/'/>"><fmt:message key="webapp.name"/></a></h1>
		<p><fmt:message key="webapp.tagline"/></p>
	</div>
	<div class="grid_16">
		<div style="font-size: 25px;font-weight: bold;color: #fff;margin: 8px;">Asian Institute of Management and Technology</div>
	</div>
	<div class="grid_12">
		<c:if test="${pageContext.request.remoteUser != null}">
		<div id="welcome">
			Welcome, <security:authentication property="principal.username" /> | 
			<span><a href="<c:url value='/acct/viewProfile.html' />?id=<security:authentication property="principal.id" />">My Profile</a></span> |
			<a href="<c:url value='/logout.jsp' />" class="ffc-link" onclick="location.href=this.href;">Sign Out</a>							
		</div>
		</c:if>
		<%-- Put constants into request scope --%>
		<appfuse:constants scope="request"/>		
	</div>
	<div class="clear"></div>
</div>
