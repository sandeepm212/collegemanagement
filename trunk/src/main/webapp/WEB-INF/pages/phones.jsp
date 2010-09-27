<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="phoneList.title"/></title>
    <meta name="heading" content="<fmt:message key='phoneList.heading'/>"/>
    <meta name="menu" content="PhoneMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/phoneform.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="phoneList" class="table" requestURI="" id="phoneList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="phoneform.html" media="html"
        paramId="id" paramProperty="id" titleKey="phone.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="phone.id"/>
    <display:column sortProperty="createdOn" sortable="true" titleKey="phone.createdOn">
         <fmt:formatDate value="${phoneList.createdOn}" pattern="${datePattern}"/>
    </display:column>
    <display:column sortProperty="updatedOn" sortable="true" titleKey="phone.updatedOn">
         <fmt:formatDate value="${phoneList.updatedOn}" pattern="${datePattern}"/>
    </display:column>
    <display:column property="version" sortable="true" titleKey="phone.version"/>
    <display:column property="dataType" sortable="true" titleKey="phone.dataType"/>
    <display:column property="dataValue" sortable="true" titleKey="phone.dataValue"/>
    <display:column property="displayOrder" sortable="true" titleKey="phone.displayOrder"/>
    <display:column sortProperty="enabled" sortable="true" titleKey="phone.enabled">
        <input type="checkbox" disabled="disabled" <c:if test="${phoneList.enabled}">checked="checked"</c:if>/>
    </display:column>
    <display:column property="entitySubType" sortable="true" titleKey="phone.entitySubType"/>
    <display:column property="ownerEntityId" sortable="true" titleKey="phone.ownerEntityId"/>
    <display:column property="ownerEntityTypeId" sortable="true" titleKey="phone.ownerEntityTypeId"/>
    <display:column property="primary" sortable="true" titleKey="phone.primary"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="phoneList.phone"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="phoneList.phones"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="phoneList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="phoneList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="phoneList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("phoneList");
</script> 