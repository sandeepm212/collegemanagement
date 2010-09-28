<%@ include file="/common/taglibs.jsp"%>

<form onsubmit="return false;" method="post" action="<c:url value="/courseForm.html" />" id="courseForm" name="courseForm">

<div class="container container_16">
	<div id="successMsg" class="success hidden"></div>	
	<input type="hidden" name="courseId" id="courseId" />

	<div class="grid_7"><p><label class="desc" for="group">Group</label> <em class="req">*</em></p></div>
	<div class="grid_9">
		<select class="text medium" name="group" id="group">
			<option value="">Select One</option>
			<c:if test="${not empty course_group}">
				<c:forEach var="dv" items="${course_group}">
				<option value="<c:out value="${dv.id}" />"><c:out value="${dv.value}" /></option>
			</c:forEach>
			</c:if>
		</select>
	</div>
	<div class="clear"></div>
	
	<div class="grid_7"><p><appfuse:label styleClass="desc" key="course.name"/></p></div>
	<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="name" id="name"></div>
	<div class="clear"></div>

	<div class="grid_7"><p><appfuse:label styleClass="desc" key="course.code"/></p></div>
	<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="code" id="code"></div>
	<div class="clear"></div>
	
	<div class="grid_7"><p><appfuse:label styleClass="desc" key="course.duration"/></p></div>
	<div class="grid_9">
		<input type="text" maxlength="255" value="" class="text medium" name="duration" id="duration">
	</div>
	<div class="clear"></div>
		
	<div class="grid_7"><p><appfuse:label styleClass="desc" key="course.intake"/></p></div>	
	<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="intake" id="intake"></div>	
	<div class="clear"></div>
	
	<div class="grid_7"><p><appfuse:label styleClass="desc" key="course.description"/></p></div>
	<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="description" id="description"></div>
	<div class="clear"></div>
	
</div>
</form>

<script type="text/javascript">
    
</script>
