<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="header.jsp"%>

<div class="main">
    <div class="main-menu">
        <div class="text-menu">
            Матч
        </div>
        <div class="main-menu-table">
            <form class="form-width form-left" action="${pageContext.request.contextPath}/match-score?id=${requestScope.id}"
                  method="post">
                <button class="btn" type="submit" name="player" value="PLAYER_1">Игрок 1</button>
            </form>
            <table>
                <tr>
                    <th>Игроки</th>
                    <th>Points</th>
                    <th>Games</th>
                    <th>Sets</th>
                </tr>
                <tr>
                    <td>${requestScope.firstPlayer.name}</td>
                    <td>${requestScope.gameScore[0]}</td>
                    <td>${requestScope.setScore[0]}</td>
                    <td>${requestScope.matchScore[0]}</td>

                </tr>
                <tr>
                    <td>${requestScope.secondPlayer.name}</td>
                    <td>${requestScope.gameScore[1]}</td>
                    <td>${requestScope.setScore[1]}</td>
                    <td>${requestScope.matchScore[1]}</td>
                </tr>
            </table>
            <form class="form-width form-left" action="${pageContext.request.contextPath}/match-score?id=${requestScope.id}"
                  method="post">
                <button class="btn" type="submit" name="player" value="PLAYER_2">Игрок 2</button>
            </form>
        </div>
    </div>
</div>


<%@ include file="footer.jsp"%>