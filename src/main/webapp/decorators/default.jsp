<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title><decorator:title/> | <fmt:message key="webapp.name"/></title>

		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/calendar-aqua/theme.css'/>" />
        <link rel="stylesheet" type="text/css" media="print" href="<c:url value='/styles/${appConfig["csstheme"]}/print.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/ui-lightness/jquery-ui-1.8.5.custom.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/ddsmoothmenu.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/app.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/template-style.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/960gs/grid.css'/>" />

        <script type="text/javascript" src="<c:url value='/scripts/jquery-1.4.2.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/jquery-ui-1.8.5.custom.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/jQuery/jquery.validate.js'/>"></script>        
        <script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/ddsmoothmenu.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/app/util.js'/>"></script>
        <decorator:head/>
    </head>
<body<decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/>>

	<div id="header">
		<jsp:include page="/common/header.jsp"/>
		<div id="menu">
	    	<jsp:include page="/common/menu.jsp"/>
	    	<div class="clear"></div>	                
		</div><!-- end nav -->
		<!-- end #menu -->
	</div>
	<!-- end #header -->

	<div id="page">
		<div id="content">
			<div id="main">
	                <%@ include file="/common/messages.jsp" %>
	                <h1><decorator:getProperty property="meta.heading"/></h1>
	                <decorator:body/>
	            </div>
	
	            <c:set var="currentMenu" scope="request"><decorator:getProperty property="meta.menu"/></c:set>
	            <c:if test="${currentMenu == 'AdminMenu'}">
	            <div id="sub">
	                <menu:useMenuDisplayer name="Velocity" config="cssVerticalMenu.vm" permissions="rolesAdapter">
	                    <menu:displayMenu name="AdminMenu"/>
	                </menu:useMenuDisplayer>
	            </div>
				</c:if>
		</div>
		<!-- end #content -->
	</div>
	<!-- end #page -->
	
	<div class="clear"></div>
	<div id="footer">
		<jsp:include page="/common/footer.jsp"/>		
	</div>
	<!-- end #footer -->	
</body>
</html>
