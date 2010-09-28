<%@ include file="/common/taglibs.jsp"%>


<div class="container container_32">
	<div class="grid_7">
		<select class="text" name="type" id="type">
			<option value="">Select One</option>
			<c:if test="${not empty phone_type}">
				<c:forEach var="dv" items="${phone_type}">
				<option value="<c:out value="${dv.id}" />"><c:out value="${dv.value}" /></option>
			</c:forEach>
			</c:if>
		</select>
	</div>
	<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="dateOfBirth" id="dateOfBirth"></div>
	<div class="grid_7">
		<div class="addEditAddLink fontLink" id="5:0:-4" title="Add a new Address for this contact">
			<a onclick="YAHOO.addressbook.add_edit.cloneAndInsertRow(event, this)">+ Add Phone</a>
		</div>
	</div>
	<div class="clear"></div>
</div>
<script type="text/javascript">
    
</script>