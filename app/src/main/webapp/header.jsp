<%@ page contentType="text/html;charset=UTF-8" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>--%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/general.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/table.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css"/>
    <title>${requestScope.title}</title>
</head>
<body>
<!-- HEADER -->
    <div class="header">
        <div class="header-logo">
            <img class="header-logo-img" src="${pageContext.request.contextPath}/img/logo-2.png" alt="logo">
        </div>

        <div class="nav">
            <a class="nav-item" href="${pageContext.request.contextPath}/">Главная</a>
            <a class="nav-item" href="${pageContext.request.contextPath}/new-match">Новый матч</a>
            <a class="nav-item" href="${pageContext.request.contextPath}/matches">Завершенные матчи</a>
            <a class="nav-item" href="${pageContext.request.contextPath}/ongoing-matches">Идущие матчи</a>
        </div>
    </div>
<!-- END HEADER -->