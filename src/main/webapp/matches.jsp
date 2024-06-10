<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="header.jsp"%>

<div class="main">
    <div class="main-menu">
        <div class="find_player">
            <form class="form-height" action="${pageContext.request.contextPath}/matches" method="get">
                <input class="match-form-input-fio form-input" type="text"
                       placeholder="Поиск игрока" name="filter_by_player_name" required>
                <button type="submit" class="btn">Поиск</button>
            </form>
            <form class="form-height" action="${pageContext.request.contextPath}/matches" method="get">
                <button type="submit" class="btn">Сбросить</button>
            </form>
        </div>
        <table>
            <tr>
                <th>Id матча</th>
                <th>Игрок 1</th>
                <th>Игрок 2</th>
                <th>Победитель матча</th>
            </tr>
            <c:forEach var="match" items="${requestScope.matches}">
                <tr>
                    <td>${match.id()}</td>
                    <td>${match.firstPlayer()}</td>
                    <td>${match.secondPlayer()}</td>
                    <td>${match.winner()}</td>
                </tr>
            </c:forEach>
        </table>

        <div class="pages">
            <c:choose>
               <c:when test="${not empty requestScope.filterPlayerName}">
                   <c:forEach var="num" begin="1" end="${requestScope.lastPage}" step="1">
                       <a href="${pageContext.request.contextPath}/matches?pageNumber=${num}&filter_by_player_name=${requestScope.filterPlayerName}">${num}</a>
                   </c:forEach>
                </c:when>
                <c:when test="${empty requestScope.filterPlayerName}">
                    <c:forEach var="num" begin="1" end="${requestScope.lastPage}" step="1">
                        <a href="${pageContext.request.contextPath}/matches?pageNumber=${num}">${num}</a>
                    </c:forEach>
                </c:when>
            </c:choose>
        </div>
    </div>
</div>

<%@ include file="footer.jsp"%>