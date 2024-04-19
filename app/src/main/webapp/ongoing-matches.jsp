<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="header.jsp"%>

<div class="main">
    <div class="main-menu">
        <c:choose>
            <c:when test="${not empty requestScope.matches}">
                <div class="text-menu">
                    Список идущих матчей
                </div>
                <div class="nav-main">
                    <ol>
                        <c:forEach var="match" items="${requestScope.matches}">
                            <li>
                                <a class="nav-item-main" href="${pageContext.request.contextPath}/match-score?id=${match.id()}">
                                        ${match.firstPlayer()} vs ${match.secondPlayer()}
                                </a>
                            </li>
                        </c:forEach>
                    </ol>
                </div>
            </c:when>
            <c:when test="${empty requestScope.matches}">
                <div class="text-menu">
                    Список идущих матчей пуст
                </div>
            </c:when>
        </c:choose>
    </div>
</div>

<%@ include file="footer.jsp"%>