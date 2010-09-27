<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="decodeValueList.title"/></title>
    <meta name="heading" content=""/>
    <meta name="menu" content="DecodeValueMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/decodeValueform.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="decodeValueList" class="table" requestURI="" id="decodeValueList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="decodeValueform.html" media="html"
        paramId="id" paramProperty="id" titleKey="decodeValue.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="decodeValue.id"/>
    <display:column sortProperty="createdOn" sortable="true" titleKey="decodeValue.createdOn">
         <fmt:formatDate value="${decodeValueList.createdOn}" pattern="${datePattern}"/>
    </display:column>
    <display:column sortProperty="updatedOn" sortable="true" titleKey="decodeValue.updatedOn">
         <fmt:formatDate value="${decodeValueList.updatedOn}" pattern="${datePattern}"/>
    </display:column>
    <display:column property="version" sortable="true" titleKey="decodeValue.version"/>
    <display:column property="description" sortable="true" titleKey="decodeValue.description"/>
    <display:column property="displayOrder" sortable="true" titleKey="decodeValue.displayOrder"/>
    <display:column sortProperty="enabled" sortable="true" titleKey="decodeValue.enabled">
        <input type="checkbox" disabled="disabled" <c:if test="${decodeValueList.enabled}">checked="checked"</c:if>/>
    </display:column>
    <display:column property="shortCode" sortable="true" titleKey="decodeValue.shortCode"/>
    <display:column property="value" sortable="true" titleKey="decodeValue.value"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="decodeValueList.decodeValue"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="decodeValueList.decodeValues"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="decodeValueList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="decodeValueList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="decodeValueList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("decodeValueList");
</script> 