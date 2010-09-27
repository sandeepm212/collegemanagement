<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="courseList.title"/></title>
    <meta name="heading" content="<fmt:message key='courseList.heading'/>"/>
    <meta name="menu" content="CourseMenu"/>
</head>

<table id="coursesList"></table>

<div id="jCourseform" class="hidden"><jsp:include page="/WEB-INF/pages/admin/courseform.jsp"></jsp:include></div>

<link rel="stylesheet" type="text/css" href="<c:url value="/styles/flexigrid/flexigrid.css"/>">
<script type="text/javascript" src="<c:url value="/scripts/jQuery/flexigrid.js"/>"></script>

<script type='text/javascript' src='/dwr/interface/DWRCourseManager.js'></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type="text/javascript" src="<c:url value="/scripts/app/course.js"/>"></script>


<script type="text/javascript">
    
</script> 