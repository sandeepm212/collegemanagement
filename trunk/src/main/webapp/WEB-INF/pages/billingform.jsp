<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="billingDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='billingDetail.heading'/>"/>
</head>


<form onsubmit="return false;" method="post" action="<c:url value="/decodeValueform.html" />" id="deocdeValueForm" name="deocdeValueForm">

<div class="container container_32">
	
	<div class="grid_7"><appfuse:label styleClass="desc" key="billing.admissionNumber"/></div>
	<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="value" id="value"></div>
	<div class="grid_7"><appfuse:label styleClass="desc" key="billing.accountNumber"/></div>
	<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="shortCode" id="shortCode"></div>
	<div class="clear"></div>

	<div class="grid_7"><appfuse:label styleClass="desc" key="billing.bankId"/></div>
	<div class="grid_9">
		<select class="text medium" style="width: 143px;">
			<option>--- Select Bank ---</option>
		</select>
	</div>
	<div class="grid_7"><appfuse:label styleClass="desc" key="billing.ddChallanNumber"/></div>
	<div class="grid_9"><input type="text" maxlength="255" value="" class="text medium" name="shortCode" id="shortCode"></div>
	<div class="clear"></div>
	
	<div class="grid_7"><appfuse:label styleClass="desc" key="billing.ddDate"/></div>
	<div class="grid_9">
		<input type="text" size="11" value="" class="text" name="createdOn" id="createdOn" style="">
		<img src="<c:url value='/images/iconCalendar.gif'/>" alt="" id="createdOnDatePicker" class="calIcon"/>
	</div>
	<div class="clear"></div>
</div>
</form>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-en.js'/>"></script>
<script type="text/javascript">
    Calendar.setup({inputField: "createdOn", ifFormat: "%d/%m/%Y", button: "createdOnDatePicker"});
</script>