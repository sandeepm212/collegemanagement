<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="addressList.title"/></title>
    <meta name="heading" content="<fmt:message key='addressList.heading'/>"/>
    <meta name="menu" content="AddressMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/addressform.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="addressList" class="table" requestURI="" id="addressList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="addressform.html" media="html"
        paramId="id" paramProperty="id" titleKey="address.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="address.id"/>
    <display:column sortProperty="createdOn" sortable="true" titleKey="address.createdOn">
         <fmt:formatDate value="${addressList.createdOn}" pattern="${datePattern}"/>
    </display:column>
    <display:column sortProperty="updatedOn" sortable="true" titleKey="address.updatedOn">
         <fmt:formatDate value="${addressList.updatedOn}" pattern="${datePattern}"/>
    </display:column>
    <display:column property="version" sortable="true" titleKey="address.version"/>
    <display:column property="addressType" sortable="true" titleKey="address.addressType"/>
    <display:column property="city" sortable="true" titleKey="address.city"/>
    <display:column property="country" sortable="true" titleKey="address.country"/>
    <display:column property="displayOrder" sortable="true" titleKey="address.displayOrder"/>
    <display:column sortProperty="enabled" sortable="true" titleKey="address.enabled">
        <input type="checkbox" disabled="disabled" <c:if test="${addressList.enabled}">checked="checked"</c:if>/>
    </display:column>
    <display:column property="ownerEntityId" sortable="true" titleKey="address.ownerEntityId"/>
    <display:column property="ownerEntityTypeId" sortable="true" titleKey="address.ownerEntityTypeId"/>
    <display:column property="postalCode" sortable="true" titleKey="address.postalCode"/>
    <display:column sortProperty="primaryAddress" sortable="true" titleKey="address.primaryAddress">
        <input type="checkbox" disabled="disabled" <c:if test="${addressList.primaryAddress}">checked="checked"</c:if>/>
    </display:column>
    <display:column property="stateOrProvince" sortable="true" titleKey="address.stateOrProvince"/>
    <display:column property="street" sortable="true" titleKey="address.street"/>
    <display:column property="uniqueCode" sortable="true" titleKey="address.uniqueCode"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="addressList.address"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="addressList.addresses"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="addressList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="addressList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="addressList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("addressList");
</script> 