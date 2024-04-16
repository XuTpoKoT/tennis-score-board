<%@ page contentType="text/html;charset=UTF-8" %>

<%@ include file="header.jsp"%>

<div class="main">
    <div class="main-menu">
        <div class="container">
            <div class="back">
                <button class="btn" type="button" name="back" onclick="history.back()">Назад</button>
            </div>
            <div class="text-menu tm">
                Ошибки
            </div>
        </div>
        <p class="errors">
            ${requestScope.errorMessage}
        </p>
    </div>
</div>

<%@ include file="footer.jsp"%>