<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="personNameDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='personNameDetail.heading'/>"/>
</head>

<form:form commandName="personName" method="post" action="personNameform.html" id="personNameForm" onsubmit="return validatePersonName(this)">
<form:errors path="*" cssClass="error" element="div"/>
<form:hidden path="id"/>
<ul>
    <li>
        <appfuse:label styleClass="desc" key="personName.createdOn"/>
        <form:errors path="createdOn" cssClass="fieldError"/>
        <form:input path="createdOn" id="createdOn" cssClass="text" size="11"/>
        <img src="<c:url value='/images/iconCalendar.gif'/>" alt="" id="createdOnDatePicker" class="calIcon"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="personName.updatedOn"/>
        <form:errors path="updatedOn" cssClass="fieldError"/>
        <form:input path="updatedOn" id="updatedOn" cssClass="text" size="11"/>
        <img src="<c:url value='/images/iconCalendar.gif'/>" alt="" id="updatedOnDatePicker" class="calIcon"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="personName.version"/>
        <form:errors path="version" cssClass="fieldError"/>
        <form:input path="version" id="version" cssClass="text medium" cssErrorClass="text medium error" maxlength="255"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="personName.displayName"/>
        <form:errors path="displayName" cssClass="fieldError"/>
        <form:input path="displayName" id="displayName" cssClass="text medium" cssErrorClass="text medium error" maxlength="255"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="personName.firstName"/>
        <form:errors path="firstName" cssClass="fieldError"/>
        <form:input path="firstName" id="firstName" cssClass="text medium" cssErrorClass="text medium error" maxlength="50"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="personName.lastName"/>
        <form:errors path="lastName" cssClass="fieldError"/>
        <form:input path="lastName" id="lastName" cssClass="text medium" cssErrorClass="text medium error" maxlength="100"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="personName.middleName"/>
        <form:errors path="middleName" cssClass="fieldError"/>
        <form:input path="middleName" id="middleName" cssClass="text medium" cssErrorClass="text medium error" maxlength="50"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="personName.ownerEntityId"/>
        <form:errors path="ownerEntityId" cssClass="fieldError"/>
        <form:input path="ownerEntityId" id="ownerEntityId" cssClass="text medium" cssErrorClass="text medium error" maxlength="255"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="personName.ownerEntityType"/>
        <form:errors path="ownerEntityType" cssClass="fieldError"/>
        <form:input path="ownerEntityType" id="ownerEntityType" cssClass="text medium" cssErrorClass="text medium error" maxlength="255"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="personName.personType"/>
        <form:errors path="personType" cssClass="fieldError"/>
        <form:input path="personType" id="personType" cssClass="text medium" cssErrorClass="text medium error" maxlength="255"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="personName.suffix"/>
        <form:errors path="suffix" cssClass="fieldError"/>
        <form:input path="suffix" id="suffix" cssClass="text medium" cssErrorClass="text medium error" maxlength="10"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="personName.title"/>
        <form:errors path="title" cssClass="fieldError"/>
        <form:input path="title" id="title" cssClass="text medium" cssErrorClass="text medium error" maxlength="255"/>
    </li>

    <li class="buttonBar bottom">
        <input type="submit" class="button" name="save" value="<fmt:message key="button.save"/>"/>
        <c:if test="${not empty personName.id}">
        <input type="submit" class="button" name="delete" onclick="bCancel=true;return confirmDelete('personName')"
            value="<fmt:message key="button.delete"/>" />
        </c:if>
        <input type="submit" class="button" name="cancel" value="<fmt:message key="button.cancel"/>" onclick="bCancel=true"/>
    </li>
</ul>
</form:form>

<v:javascript formName="personName" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-en.js'/>"></script>
<script type="text/javascript">
    Form.focusFirstElement($('personNameForm'));
    Calendar.setup({inputField: "createdOn", ifFormat: "%m/%d/%Y", button: "createdOnDatePicker"});
    Calendar.setup({inputField: "updatedOn", ifFormat: "%m/%d/%Y", button: "updatedOnDatePicker"});
</script>