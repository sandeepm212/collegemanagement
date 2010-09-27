<%@ include file="/common/taglibs.jsp"%>

<form class="deocdeGroupForm" id="deocdeGroupForm" method="get" action="" onsubmit="return false;">
	<div class="container container_16">
		<input type="hidden" id="decodeGroupId" name="decodeGroupId">
		
		<div class="grid_7"><p><appfuse:label styleClass="desc applbl" key="decodeGroup.name"/></p></div>
		<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="name" id="name" style=""></div>
		<div class="clear"></div>
		
		<div class="grid_7"><p><appfuse:label styleClass="desc applbl" key="decodeGroup.code"/></p></div>
		<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="code" id="code" style=""></div>
		<div class="clear"></div>
	
		<div class="grid_7"><p><appfuse:label styleClass="desc applbl" key="decodeGroup.description"/></p></div>
		<div class="grid_9"><input type="text" maxlength="512" value="" class="text medium" name="description" id="description" style=""></div>
		<div class="clear"></div>
		
		<div class="grid_7"><p><appfuse:label styleClass="desc applbl" key="decodeGroup.enabled"/></p></div>
		<div class="grid_9"><input id="enabled" name="enabled" class="checkbox" value="true" type="checkbox"><input name="_enabled" value="on" type="hidden"></div>
		<div class="clear"></div>
		<div class="hidden">
			<div class="grid_7"><p><appfuse:label styleClass="desc applbl" key="decodeGroup.locked"/></p></div>
			<div class="grid_9"><input id="locked" name="locked" class="checkbox" value="true" type="checkbox"><input name="_locked" value="on" type="hidden"></div>
			<div class="clear"></div>
		</div>
	</div>
</form>

<script type="text/javascript"><!--
	

--></script>