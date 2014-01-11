

<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title><fmt:message key="welcome.title"/></title>
    <link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection">
    <link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print">
    <!--[if lt IE 8]>
    <link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection">
    <![endif]-->
</head>
<body>
<div class="container">
    test!

    获得后台返回的值:${value};
    获得后台返回的mode值:${modelValue}
</div>
</body>
</html>