<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="billingList.title"/></title>
    <meta name="heading" content="<fmt:message key='billingList.heading'/>"/>
    <meta name="menu" content="BillingMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/billingform.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="billingList" class="table" requestURI="" id="billingList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="billingform.html" media="html"
        paramId="id" paramProperty="id" titleKey="billing.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="billing.id"/>
    <display:column sortProperty="createdOn" sortable="true" titleKey="billing.createdOn">
         <fmt:formatDate value="${billingList.createdOn}" pattern="${datePattern}"/>
    </display:column>
    <display:column sortProperty="updatedOn" sortable="true" titleKey="billing.updatedOn">
         <fmt:formatDate value="${billingList.updatedOn}" pattern="${datePattern}"/>
    </display:column>
    <display:column property="version" sortable="true" titleKey="billing.version"/>
    <display:column property="accountNumber" sortable="true" titleKey="billing.accountNumber"/>
    <display:column property="admissionNumber" sortable="true" titleKey="billing.admissionNumber"/>
    <display:column property="bankId" sortable="true" titleKey="billing.bankId"/>
    <display:column property="ddChallanNumber" sortable="true" titleKey="billing.ddChallanNumber"/>
    <display:column property="ddDate" sortable="true" titleKey="billing.ddDate"/>
    <display:column property="entityType" sortable="true" titleKey="billing.entityType"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="billingList.billing"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="billingList.billings"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="billingList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="billingList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="billingList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("billingList");
</script> 