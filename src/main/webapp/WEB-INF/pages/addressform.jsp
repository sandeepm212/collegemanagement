<%@ include file="/common/taglibs.jsp"%>

<div class="container container_32">
	
	<div class="grid_7 tworow1">&nbsp;</div>
	<div class="grid_9 tworow1"><label class="desc" for="Title">Title</label></div>
	<div class="grid_7 tworow1"><label class="desc" for="Title">First Name</label></div>
	<div class="grid_9 tworow1"><label class="desc" for="Title">Last Name</label></div>
	<div class="clear"></div>
	
	<div class="grid_7 tworow2">
		<label class="desc" for="Title">Contact Name</label>
	</div>
	<div class="grid_9 tworow2">
		<select name="addresses[0].personName.title" class="text">
			<option value=""> -Select One- </option>
			<c:if test="${not empty name_title}">
				<c:forEach var="dv" items="${name_title}">
				<option value="<c:out value="${dv.id}" />" 
				><c:out value="${dv.value}" /></option>
				</c:forEach>
			</c:if>
		</select>
	</div>
	<div class="grid_7 tworow2"><input type="text" maxlength="255" value="" class="text medium" name="addresses[0].personName.firstName" id=""></div>
	<div class="grid_9 tworow2"><input type="text" maxlength="255" value="" class="text medium" name="addresses[0].personName.lastName" id=""></div>
	<div class="clear"></div>
	

	<div class="grid_7"><label class="desc" for="group">Address Type</label></div>
	<div class="grid_9">
		<select class="text" name="addresses[0].addressType" id="">
			<option value="">Select One</option>
			<c:if test="${not empty address_type}">
				<c:forEach var="dv" items="${address_type}">
				<option value="<c:out value="${dv.id}" />"><c:out value="${dv.value}" /></option>
			</c:forEach>
			</c:if>
		</select>
	</div>
	<div class="grid_7">
		<label class="desc" for="group">Street</label>
	</div>
	<div class="grid_9">
		<input type="text" maxlength="255" value="" class="text medium" name="addresses[0].street" id="">
	</div>
	<div class="grid_7">
		<label class="desc" for="group">City</label>
	</div>
	<div class="grid_9">
		<input type="text" maxlength="255" value="" class="text medium" name="addresses[0].city" id="">
	</div>
	<div class="grid_7">
		<label class="desc" for="group">State</label>
	</div>
	<div class="grid_9">
		<input type="text" maxlength="255" value="" class="text medium" name="addresses[0].stateOrProvince" id="">
	</div>
	<div class="clear"></div>
	
	<div class="grid_7">
		<label class="desc" for="group">Postal/ZIP Code</label>
	</div>
	<div class="grid_9">
		<input type="text" maxlength="255" value="" class="text medium" name="addresses[0].postalCode" id="">
	</div>
	<div class="grid_7">
		<label class="desc" for="group">Country</label>
	</div>
	<div class="grid_9">
		<input type="text" maxlength="255" value="" class="text medium" name="addresses[0].country" id="">
	</div>
	<div class="clear"></div>

</div>

<div class="fontLink" title="Add a new Address for this contact">
	<a class="addEditAddLink" onclick="cloneAndInsertRow(this)">+ Add Address</a>
</div>

<script type="text/javascript">
	
</script>