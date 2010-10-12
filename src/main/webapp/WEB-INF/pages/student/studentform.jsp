<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="studentDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='studentDetail.heading'/>"/>
</head>

<form method="post" action="<c:url value="/studentform.html" />" id="studentForm" name="studentForm">
<input type="hidden" name="id" id="id" value="<c:out value="${studentView.id}"/>"/>
<input type="hidden" name="studentName.id" id="studentName.id" value="<c:out value="${studentView.studentName.id}"/>"/>
 
<div class="container container_32">
	<form:errors path="*" cssClass="error" element="div"/>
	
	<div id="tabs">
	<ul>
		<li><a href="#tabs-1">Student Information</a></li>
		<li><a href="#tabs-2">Contact</a></li>
	</ul>
	
	<div id="tabs-1">
		<div class="grid_7 tworow1"><label class="desc" for="Title">Title</label></div>
		<div class="grid_9 tworow1"><label class="desc" for="Title">First Name</label></div>
		<div class="grid_7 tworow1"><label class="desc" for="Title">Middle Name</label></div>
		<div class="grid_8 tworow1"><label class="desc" for="Title">Last Name</label><em class="req">*</em></div>
		<div class="clear"></div>
		
		<div class="grid_7 tworow2">
			<select name="studentName.title" id="studentName.title" class="text">
				<option value=""> -Select One- </option>
				<c:if test="${not empty name_title}">
					<c:forEach var="dv" items="${name_title}">
					<option value="<c:out value="${dv.id}" />" 
					<c:if test="${dv.id eq studentView.studentName.title}">selected="selected"</c:if>><c:out value="${dv.value}" /></option>
					</c:forEach>
				</c:if>
			</select>
		</div>
		<div class="grid_9 tworow2">
			<input type="text" maxlength="255" value="<c:out value="${studentView.studentName.firstName}"/>" class="text medium" name="studentName.firstName" id="studentFirstName">
		</div>
		<div class="grid_7 tworow2">
			<input type="text" maxlength="255" value="<c:out value="${studentView.studentName.middleName}"/>" class="text medium" name="studentName.middleName" id="studentMiddleName"></div>
		<div class="grid_8 tworow2">
			<input type="text" maxlength="255" value="<c:out value="${studentView.studentName.lastName}"/>" class="text medium" name="studentName.lastName" id="studentLastName">
		</div>
		<div class="clear"></div>
		
		<div class="grid_7">
			<label class="desc" for="courseGroupId">Group</label><em class="req">*</em>
		</div>
		<div class="grid_9">
			<select class="text medium" name="courseGroupId" id="courseGroupId" defaultValue="<c:out value="${studentView.courseGroupId}"/>">
				<option value=""> -Select One- </option>
			</select>
		</div>
		<div class="grid_7">
			<label class="desc" for="courseId">Course</label><em class="req">*</em>
		</div>
		<div class="grid_8">
			<select class="text medium" name="courseId" id="courseId" defaultValue="<c:out value="${studentView.courseId}"/>">
			</select>
		</div>
		<div class="clear"></div>
		
		<div class="grid_7">
			<label class="desc" for="dateOfBirth">Date Of Birth</label><em class="req">*</em>
		</div>
		<div class="grid_9">
			<input type="text" size="11" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${studentView.dateOfBirth}" />" class="text medium" name="dateOfBirth" id="dateOfBirth">
			<img src="<c:url value='/images/iconCalendar.gif'/>" alt="" id="dateOfBirthDatePicker" class="calIcon"/>
		</div>
		<div class="grid_7">
			<appfuse:label styleClass="desc" key="student.currentYear"/>
		</div>
		<div class="grid_8"><input type="text" maxlength="255" value="<c:out value="${studentView.currentYear}"/>" class="text medium" name="currentYear" id="currentYear"></div>
		<div class="clear"></div>
		
		<div class="grid_7">
			<label class="desc" for="admissionNumber">Admission Number</label><em class="req">*</em>
		</div>
		<div class="grid_9">
			<input type="text" maxlength="255" value="<c:out value="${studentView.admissionNumber}"/>" class="text medium" name="admissionNumber" id="admissionNumber">
		</div>
		<div class="grid_7">
			<appfuse:label styleClass="desc" key="student.bloodGroup"/>
		</div>
		<div class="grid_8">
			<select class="text" name="bloodGroup" id="bloodGroup">
				<option value=""> -Select One- </option>
				<c:if test="${not empty blood_group}">
					<c:forEach var="dv" items="${blood_group}">
					<option value="<c:out value="${dv.id}" />" 
					<c:if test="${dv.id eq studentView.bloodGroup}">selected="selected"</c:if>><c:out value="${dv.value}" /></option>
					</c:forEach>
				</c:if>
			</select>
		</div>
		<div class="clear"></div>
		
		<div class="grid_7">
			<appfuse:label styleClass="desc" key="student.gender"/>
		</div>
		<div class="grid_9">
			<input type = 'radio' name='gender' value= 'Male' <c:if test="${studentView.gender eq 'Male'}">checked="checked"</c:if>>Male
			<input type = 'radio' name='gender' value= 'Female' <c:if test="${studentView.gender eq 'Female'}">checked="checked"</c:if>>Female
		</div>
		<div class="grid_7"><appfuse:label styleClass="desc" key="student.identificationMarks"/></div>
		<div class="grid_8"><input type="text" maxlength="255" value="<c:out value="${studentView.identificationMarks}"/>" class="text medium" name="identificationMarks" id="identificationMarks"></div>
		<div class="clear"></div>
	
		<div class="grid_7">
			<label class="desc" for="joiningDate">Joining Date</label><em class="req">*</em>
		</div>
		<div class="grid_9">
			<input type="text" size="11" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${studentView.joiningDate}" />" class="text small" name="joiningDate" id="joiningDate">
			<img src="<c:url value='/images/iconCalendar.gif'/>" alt="" id="joiningDateDatePicker" class="calIcon"/>
		</div>	
		<div class="grid_7"><label class="desc" for="nationality">Nationality</label><em class="req">*</em></div>	
		<div class="grid_8">
			<select class="text" name="nationality" id="nationality">
				<option value=""> -Select One- </option>
				<c:if test="${not empty nationality}">
					<c:forEach var="dv" items="${nationality}">
					<option value="<c:out value="${dv.id}" />" 
					<c:if test="${dv.id eq studentView.nationality}">selected="selected"</c:if>><c:out value="${dv.value}" /></option>
					</c:forEach>
				</c:if>
			</select>
		</div>	
		<div class="clear"></div>
		
	
		<div class="grid_7">
			<appfuse:label styleClass="desc" key="student.registrationNumber"/>
		</div>
		<div class="grid_9">
			<input type="text" maxlength="255" value="<c:out value="${studentView.registrationNumber}" />" class="text medium" name="registrationNumber" id="registrationNumber">
		</div>
		<!-- 
		<div class="grid_7"><appfuse:label styleClass="desc" key="student.religion"/></div>
		<div class="grid_8"><input type="text" maxlength="255" value="" class="text medium" name="religion" id="religion"></div>
		 -->
		<div class="grid_7">
			<label class="desc" for="studentId">Student Id</label><em class="req">*</em>
		</div>
		<div class="grid_8">
			<input type="text" maxlength="255" value="<c:out value="${studentView.studentId}"/>" class="text medium" name="studentId" id="studentId">
		</div>
		<div class="clear"></div>
		
		
		<div class="clear"></div>
		
		<!-- Father Info Start -->
		<div class="grid_7 tworow1">&nbsp;</div>
		<div class="grid_9 tworow1"><label class="desc" for="Title">First Name</label></div>
		<div class="grid_7 tworow1"><label class="desc" for="Title">Middle Name</label></div>
		<div class="grid_8 tworow1"><label class="desc" for="Title">Last Name</label></div>
		<div class="clear"></div>
		
		<div class="grid_7 tworow2"><label class="desc">Father/Guardian Name</label></div>
		<div class="grid_9 tworow2">
			<input type="text" maxlength="255" value="<c:out value="${studentView.fatherFirstName}"/>" class="text medium" name="fatherName.firstName" id="fatherName.firstName">
		</div>
		<div class="grid_7 tworow2">
			<input type="text" maxlength="255" value="<c:out value="${studentView.fatherMiddleName}"/>" class="text medium" name="fatherName.middleName" id="fatherName.middleName">
		</div>
		<div class="grid_8 tworow2">
			<input type="text" maxlength="255" value="<c:out value="${studentView.fatherLastName}"/>" class="text medium" name="fatherName.lastName" id="fatherName.lastName">
		</div>
		<div class="clear"></div>
		<!-- Father Info End -->
		
		<!-- Mother Info Start -->
		<!-- 
		<div class="grid_7 tworow1">&nbsp;</div>
		<div class="grid_9 tworow1"><label class="desc" for="Title">First Name</label></div>
		<div class="grid_7 tworow1"><label class="desc" for="Title">Middle Name</label></div>
		<div class="grid_8 tworow1"><label class="desc" for="Title">Last Name</label></div>
		<div class="clear"></div>
		
		<div class="grid_7 tworow2"><label class="desc">Mother Name</label></div>
		<div class="grid_9 tworow2"><input type="text" maxlength="255" value="<c:out value="${studentView.motherFirstName}"/>" class="text medium" name="firstName" id="firstName"></div>
		<div class="grid_7 tworow2"><input type="text" maxlength="255" value="<c:out value="${studentView.motherFirstName}"/>" class="text medium" name="middleName" id="middleName"></div>
		<div class="grid_8 tworow2"><input type="text" maxlength="255" value="<c:out value="${studentView.motherFirstName}"/>" class="text medium" name="lastName" id="lastName"></div>
		<div class="clear"></div>
		 -->
		<!-- Mother Info End -->
	</div>
	<div id="tabs-2" class="ui-tabs-hide hidden" >
		<div class="grid_32"><label class="heading">Address</label></div>
		<div class="clear"></div>
		<div class="separator"></div>
		<jsp:include page="/WEB-INF/pages/addressform.jsp"></jsp:include>
		<div class="separator"></div>
		<div class="grid_32"><label class="heading">Phone</label></div>
		<div class="clear"></div>
		<div class="separator"></div>		
		<jsp:include page="/WEB-INF/pages/phoneform.jsp"></jsp:include>
		<div class="separator"></div>
	</div>	
	</div>
	

	<div class="grid_32" style="padding-top: 10px;">
		<input type="submit" class="artzBtnLinks" name="save" value="<fmt:message key="button.save"/>"/>
	    <c:if test="${not empty student.id}">
	    	<input type="submit" class="artzBtnLinks" name="delete" onclick="bCancel=true;return confirmDelete('student')"
	            value="<fmt:message key="button.delete"/>" />
		</c:if>
	    <input type="submit" class="artzBtnLinks" name="cancel" value="<fmt:message key="button.cancel"/>" onclick="bCancel=true"/>
	</div>
</div>
</form>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-en.js'/>"></script>
<script type="text/javascript">
    $("#studentForm input[type='text']:first").focus();
    Calendar.setup({inputField: "joiningDate", ifFormat: "%d/%m/%Y", button: "joiningDateDatePicker"});
    Calendar.setup({inputField: "dateOfBirth", ifFormat: "%d/%m/%Y", button: "dateOfBirthDatePicker"});
    
    $(document).ready(function(){
    	$(function() {
    		$("#tabs").tabs();
    	});
    	
		dgFormValidator = $("#studentForm").validate({
			rules: {
				"studentName\.lastName": "required",
				courseGroupId: "required",
				courseId: "required",
				dateOfBirth: "required",
				currentYear: "number",
				admissionNumber: "required",
				gender: "required",
				studentId: "required",
				nationality: "required",
				joiningDate: "required"
			}
		});
		
	});
	
    var courseGroupsJson = <c:out value="${course_groups_json}" escapeXml="false"/>;
    var coursesJson = <c:out value="${courses_json}" escapeXml="false"/>;
    
    $.each(courseGroupsJson, function() {
    	$('#courseGroupId').append('<option value="' + this.id + '" >' + this.value + '</option>');
    });
    
    $('#courseGroupId').val($('#courseGroupId').attr("defaultValue"));
    showCourses ($('#courseGroupId').attr("defaultValue"));
    
    $('#courseGroupId').change(function() {
    	$('#courseId option').remove();
    	var groupId = $(this).val();
    	showCourses (groupId);
    });
    
    function showCourses (groupId) {
    	if (groupId != undefined && !isNaN(groupId)) {
    		$.each(coursesJson, function(j, g)	{
        		if (groupId == g.group) {
        			$('#courseId').append(new Option("-Select One-", ""));
        			$.each(g.courses, function(i, e) {
        				$('#courseId').append(new Option(e.name, e.id));
        			});			
        		}
            });
    		
    		$('#courseId').val($('#courseId').attr("defaultValue"));
    	}
    }
    
    $("#successMessages").show().fadeOut(10000);
</script>