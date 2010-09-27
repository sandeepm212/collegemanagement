<%@ include file="/common/taglibs.jsp"%>

<form onsubmit="return false;" method="post" action="<c:url value="/decodeValueform.html" />" id="deocdeValueForm" name="deocdeValueForm">

<div class="container container_16">
	<form:errors path="*" cssClass="error" element="div"/>
	
	<input type="hidden" name="decodeValueId" id="decodeValueId" />
	<input type="hidden" name="dvDecodeGroupId" id="dvDecodeGroupId" />
	
	<div class="grid_7"><p><appfuse:label styleClass="desc" key="decodeValue.value"/></p></div>
	<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="value" id="value"></div>
	<div class="clear"></div>
	
	<div class="grid_7"><p><appfuse:label styleClass="desc" key="decodeValue.shortCode"/></p></div>
	<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="shortCode" id="shortCode"></div>
	<div class="clear"></div>

	<div class="grid_7"><p><appfuse:label styleClass="desc" key="decodeValue.enabled"/></p></div>
	<div class="grid_9"><input type="checkbox" value="true" class="checkbox" name="dvEnabled" id="dvEnabled"></div>
	<div class="clear"></div>
	
	<div class="grid_7"><p><appfuse:label styleClass="desc" key="decodeValue.displayOrder"/></p></div>
	<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="dvDisplayOrder" id="dvDisplayOrder"></div>
	<div class="clear"></div>
	
	<div class="grid_7"><p><appfuse:label styleClass="desc" key="decodeValue.description"/></p></div>
	<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="dvDescription" id="dvDescription"></div>
	<div class="clear"></div>	
</div>
</form>


<script type="text/javascript"><!--
	

--></script>