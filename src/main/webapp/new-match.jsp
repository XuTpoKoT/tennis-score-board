<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="header.jsp"%>

<div class="main">
    <div class="main-menu">
        <div class="text-menu">
            Регистрация нового матча
        </div>
        <form method="post" action="${pageContext.request.contextPath}/new-match">
            <label class="match-form-label">
                Игрок 1
                <input class="match-form-input-fio" name="first_player"
                       placeholder="Введите имя игрока" type="text" required>
            </label>
            <br>
            <label class="match-form-label">
                Игрок 2
                <input class="match-form-input-fio" name="second_player"
                       placeholder="Введите имя игрока" type="text" required>
            </label>
            <br>
            <button type="submit" class="btn">Начать</button>
        </form>
    </div>
</div>



<%@ include file="footer.jsp"%>