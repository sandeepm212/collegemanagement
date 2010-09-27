<%@ include file="/common/taglibs.jsp"%>

<div class="container container_32">
	
	<div class="grid_7 tworow1"><p><label class="desc" for="Title">Title</label></p></div>
	<div class="grid_9 tworow1"><p><label class="desc" for="Title">First Name</label></p></div>
	<div class="grid_7 tworow1"><p><label class="desc" for="Title">Middle Name</label></p></div>
	<div class="grid_9 tworow1"><p><label class="desc" for="Title">Last Name</label></p></div>
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
	<div class="grid_9 tworow2"><input type="text" maxlength="255" value="" class="text medium" name="lastName" id="lastName"></div>
	<div class="clear"></div>
	

	<div class="grid_7"><label class="desc" for="group">Address Type</label></div>
	<div class="grid_9">
		<select class="text" name="type" id="type">
			<option value="">Select One</option>
			<c:if test="${not empty address_type}">
				<c:forEach var="dv" items="${address_type}">
				<option value="<c:out value="${dv.id}" />"><c:out value="${dv.value}" /></option>
			</c:forEach>
			</c:if>
		</select>
	</div>
	<div class="grid_7"><label class="desc" for="group">Street</label></div>
	<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="group" id="group"></div>
	
	<div class="grid_7"><label class="desc" for="group">City</label></div>
	<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="dateOfBirth" id="dateOfBirth"></div>
	<div class="grid_7"><label class="desc" for="group">State</label></div>
	<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="admissionNumber" id="admissionNumber"></div>
	<div class="clear"></div>
	
	<div class="grid_7"><label class="desc" for="group">Postal/ZIP Code</label></div>
	<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="bloodGroup" id="bloodGroup"></div>
	<div class="grid_7"><label class="desc" for="group">Country</label></div>
	<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="gender" id="gender"></div>
	<div class="clear"></div>

</div>

<div class="addEditAddLink fontLink" id="5:0:-4" title="Add a new Address for this contact">
	<a onclick="YAHOO.addressbook.add_edit.cloneAndInsertRow(event, this)">+ Add Address</a>
</div>

<script type="text/javascript">
	
</script>