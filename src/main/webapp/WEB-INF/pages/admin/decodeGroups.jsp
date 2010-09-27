<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="decodeGroupList.title"/></title>
    <meta name="heading" content=""/>
    <meta name="menu" content="DecodeGroupMenu"/>
</head>

<div class="container container_32">
	<div class="grid_32">
		<div id="dgListHolder" >
			<h1 class="pageHeading"><fmt:message key='decodeGroupList.heading'/></h1>
			<table id="decodeGroupsList"></table>
		</div>		
	</div>
	<div class="clear"></div>
	
	<div class="grid_32">
		<div id="dvListHolder" class="hidden">
			<h1 class="pageHeading"><fmt:message key='decodeValueList.heading'/></h1>
			<table id="decodeValuesList"></table>
			<div><input id="showDDGroups" type="button" value="Show Drop Down Groups" class="artzBtnLinks"></div>
		</div>
	</div>
	<div class="clear"></div>
</div>

<div id="jDecodeGroupform" class="hidden"><jsp:include page="/WEB-INF/pages/admin/decodeGroupform.jsp"></jsp:include></div>

<div id="jDecodeValueform" class="hidden"><jsp:include page="/WEB-INF/pages/admin/decodeValueform.jsp"></jsp:include></div>

<link rel="stylesheet" type="text/css" href="<c:url value="/styles/flexigrid/flexigrid.css"/>">
<script type="text/javascript" src="<c:url value="/scripts/jQuery/flexigrid.js"/>"></script>

<script type='text/javascript' src='/dwr/interface/DWRDecodeGroupManager.js'></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type="text/javascript" src="<c:url value="/scripts/app/decode.js"/>"></script>

<script type="text/javascript">
    
</script> 