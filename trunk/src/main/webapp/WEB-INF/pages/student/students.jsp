<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="studentList.title"/></title>
    <meta name="heading" content="<fmt:message key='studentList.heading'/>"/>
    <meta name="menu" content="StudentMenu"/>
</head>

<table id="studentsList"></table>

<link rel="stylesheet" type="text/css" href="<c:url value="/styles/flexigrid/flexigrid.css"/>">
<script type="text/javascript" src="<c:url value="/scripts/jQuery/flexigrid.js"/>"></script>

<script type='text/javascript' src='/dwr/interface/DWRStudentManager.js'></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type="text/javascript" src="<c:url value="/scripts/app/student.js"/>"></script>


<script type="text/javascript">
    
</script> 