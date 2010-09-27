<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="personNameList.title"/></title>
    <meta name="heading" content="<fmt:message key='personNameList.heading'/>"/>
    <meta name="menu" content="PersonNameMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/personNameform.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="personNameList" class="table" requestURI="" id="personNameList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="personNameform.html" media="html"
        paramId="id" paramProperty="id" titleKey="personName.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="personName.id"/>
    <display:column sortProperty="createdOn" sortable="true" titleKey="personName.createdOn">
         <fmt:formatDate value="${personNameList.createdOn}" pattern="${datePattern}"/>
    </display:column>
    <display:column sortProperty="updatedOn" sortable="true" titleKey="personName.updatedOn">
         <fmt:formatDate value="${personNameList.updatedOn}" pattern="${datePattern}"/>
    </display:column>
    <display:column property="version" sortable="true" titleKey="personName.version"/>
    <display:column property="displayName" sortable="true" titleKey="personName.displayName"/>
    <display:column property="firstName" sortable="true" titleKey="personName.firstName"/>
    <display:column property="lastName" sortable="true" titleKey="personName.lastName"/>
    <display:column property="middleName" sortable="true" titleKey="personName.middleName"/>
    <display:column property="ownerEntityId" sortable="true" titleKey="personName.ownerEntityId"/>
    <display:column property="ownerEntityType" sortable="true" titleKey="personName.ownerEntityType"/>
    <display:column property="personType" sortable="true" titleKey="personName.personType"/>
    <display:column property="suffix" sortable="true" titleKey="personName.suffix"/>
    <display:column property="title" sortable="true" titleKey="personName.title"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="personNameList.personName"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="personNameList.personNames"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="personNameList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="personNameList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="personNameList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("personNameList");
</script> 