<%@ include file="/common/taglibs.jsp" %>

<div class="container container_32">
	<div class="grid_32">
		<div class="left">
    	<span style="display: none;">	
    	<fmt:message key="webapp.version"/> |
                
        </span>
        <c:if test="${pageContext.request.remoteUser != null}">
        <fmt:message key="user.status"/> ${pageContext.request.remoteUser}
        </c:if>
	    </div>
	    <div class="right">
	        &copy; <fmt:message key="copyright.year"/> <a href="<fmt:message key="company.url"/>"><fmt:message key="company.name"/></a>
	    </div>
	</div>
</div>