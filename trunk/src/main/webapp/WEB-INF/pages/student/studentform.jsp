<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="studentDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='studentDetail.heading'/>"/>
</head>

<form onsubmit="return false;" method="post" action="<c:url value="/studentform.html" />" id="studentForm" name="studentForm">

<div class="container container_32">
	<form:errors path="*" cssClass="error" element="div"/>
	
	<div id="tabs">
	<ul>
		<li><a href="#tabs-1">Student Information</a></li>
		<li><a href="#tabs-2">Contact</a></li>
	</ul>
	
	<div id="tabs-1">
		<input type="hidden" name="id" id="id" />
		<div class="grid_7 tworow1"><p><label class="desc" for="Title">Title</label></p></div>
		<div class="grid_9 tworow1"><p><label class="desc" for="Title">First Name</label></p></div>
		<div class="grid_7 tworow1"><p><label class="desc" for="Title">Middle Name</label></p></div>
		<div class="grid_8 tworow1"><p><label class="desc" for="Title">Last Name</label></p></div>
		<div class="clear"></div>
		
		<div class="grid_7 tworow2">
			<select name="title" class="text">
				<option> - Select Your Title - </option>
				<option value="Mr.">Mr.</option>
				<option value="Mrs.">Mrs.</option>
				<option value="Miss">Miss</option>
				<option value="Ms.">Ms.</option>
			    <option value="Other">Other</option>
			</select>
		</div>
		<div class="grid_9 tworow2"><input type="text" maxlength="255" value="" class="text medium" name="firstName" id="firstName"></div>
		<div class="grid_7 tworow2"><input type="text" maxlength="255" value="" class="text medium" name="middleName" id="middleName"></div>
		<div class="grid_8 tworow2"><input type="text" maxlength="255" value="" class="text medium" name="lastName" id="lastName"></div>
		<div class="clear"></div>
		
		<div class="grid_7"><p><label class="desc" for="group">Group</label></p></div>
		<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="group" id="group"></div>
		<div class="grid_7"><p><label class="desc" for="course">Course</label></p></div>
		<div class="grid_8"><input type="text" maxlength="255" value="" class="text medium" name="course" id="course"></div>
		<div class="clear"></div>
		
		<div class="grid_7"><p><label class="desc" for="group">Date Of Birth</label></p></div>
		<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="dateOfBirth" id="dateOfBirth"></div>
		<div class="grid_7"><p><appfuse:label styleClass="desc" key="student.currentYear"/></p></div>
		<div class="grid_8"><input type="text" maxlength="255" value="" class="text medium" name="currentYear" id="currentYear"></div>
		<div class="clear"></div>
		
		<div class="grid_7"><p><appfuse:label styleClass="desc" key="student.admissionNumber"/></p></div>
		<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="admissionNumber" id="admissionNumber"></div>
		<div class="grid_7"><p><appfuse:label styleClass="desc" key="student.bloodGroup"/></p></div>
		<div class="grid_8"><input type="text" maxlength="255" value="" class="text medium" name="bloodGroup" id="bloodGroup"></div>
		<div class="clear"></div>
		
		<div class="grid_7"><p><appfuse:label styleClass="desc" key="student.gender"/></p></div>
		<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="gender" id="gender"></div>
		<div class="grid_7"><p><appfuse:label styleClass="desc" key="student.identificationMarks"/></p></div>
		<div class="grid_8"><input type="text" maxlength="255" value="" class="text medium" name="identificationMarks" id="identificationMarks"></div>
		<div class="clear"></div>
	
		<div class="grid_7"><p><appfuse:label styleClass="desc" key="student.joiningDate"/></p></div>
		<div class="grid_9">
			<input type="text" maxlength="11" value="" class="text small" name="joiningDate" id="joiningDate">
			<img src="<c:url value='/images/iconCalendar.gif'/>" alt="" id="joiningDateDatePicker" class="calIcon"/>
		</div>	
		<div class="grid_7"><p><appfuse:label styleClass="desc" key="student.nationality"/></p></div>	
		<div class="grid_8"><input type="text" maxlength="255" value="" class="text medium" name="nationality" id="nationality"></div>	
		<div class="clear"></div>
		
	
		<div class="grid_7"><p><appfuse:label styleClass="desc" key="student.registrationNumber"/></p></div>
		<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="registrationNumber" id="registrationNumber"></div>
		<div class="grid_7"><p><appfuse:label styleClass="desc" key="student.religion"/></p></div>
		<div class="grid_8"><input type="text" maxlength="255" value="" class="text medium" name="religion" id="religion"></div>
		<div class="clear"></div>
		
		<div class="grid_7"><p><appfuse:label styleClass="desc" key="student.studentId"/></p></div>
		<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="studentId" id="studentId"></div>
		<div class="clear"></div>
		
		<!-- Father Info Start -->
		<div class="grid_7 tworow1">&nbsp;</div>
		<div class="grid_9 tworow1"><p><label class="desc" for="Title">First Name</label></p></div>
		<div class="grid_7 tworow1"><p><label class="desc" for="Title">Middle Name</label></p></div>
		<div class="grid_8 tworow1"><p><label class="desc" for="Title">Last Name</label></p></div>
		<div class="clear"></div>
		
		<div class="grid_7 tworow2"><label class="desc">Father/Guardian Name</label></div>
		<div class="grid_9 tworow2"><input type="text" maxlength="255" value="" class="text medium" name="firstName" id="firstName"></div>
		<div class="grid_7 tworow2"><input type="text" maxlength="255" value="" class="text medium" name="middleName" id="middleName"></div>
		<div class="grid_8 tworow2"><input type="text" maxlength="255" value="" class="text medium" name="lastName" id="lastName"></div>
		<div class="clear"></div>
		<!-- Father Info End -->
		
		<!-- Mother Info Start -->
		<div class="grid_7 tworow1">&nbsp;</div>
		<div class="grid_9 tworow1"><p><label class="desc" for="Title">First Name</label></p></div>
		<div class="grid_7 tworow1"><p><label class="desc" for="Title">Middle Name</label></p></div>
		<div class="grid_8 tworow1"><p><label class="desc" for="Title">Last Name</label></p></div>
		<div class="clear"></div>
		
		<div class="grid_7 tworow2"><label class="desc">Mother Name</label></div>
		<div class="grid_9 tworow2"><input type="text" maxlength="255" value="" class="text medium" name="firstName" id="firstName"></div>
		<div class="grid_7 tworow2"><input type="text" maxlength="255" value="" class="text medium" name="middleName" id="middleName"></div>
		<div class="grid_8 tworow2"><input type="text" maxlength="255" value="" class="text medium" name="lastName" id="lastName"></div>
		<div class="clear"></div>
		<!-- Mother Info End -->
	</div>
	<div id="tabs-2">
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
    Calendar.setup({inputField: "joiningDate", ifFormat: "%m/%d/%Y", button: "joiningDateDatePicker"});
    
    $(document).ready(function(){
    	$(function() {
    		$("#tabs").tabs();
    	});
    	
		dgFormValidator = $("#studentForm").validate({
			rules: {
				gender: "required",
				nationality: "required",
				studentId: "required"
			},
			submitHandler: function(form) {
				
		    }
		});
		
	});
	
</script>