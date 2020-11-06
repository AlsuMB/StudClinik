<#ftl encoding="utf-8">
<#include "base.ftl">

<#macro title>Регистрация</#macro>
<#macro css>
    <link rel="stylesheet" href="../webapp/css/registration_page.css">
</#macro>
<#macro content>
    <form action="/registration" method="post" enctype="multipart/form-data">
        <div class="form-row">
            <div class="form-group col-md-4">
                <label style="font-size: 30px">Логин</label>
                <input type="text" class="form-control" name="login">
            </div>
            <div class="form-group col-md-4">
                <label style="font-size: 30px">Пароль</label>
                <input type="password" class="form-control" name="password">
            </div>
        </div>
        <div class="form-group" style="padding-right: 500px">
            <label style="font-size: 30px">Имя</label>
            <input type="text" class="form-control" name="name">
        </div>
        <div class="form-group" style="padding-right: 500px">
            <label style="font-size: 30px">Фамилия</label>
            <input type="text" class="form-control" name="lastname">
        </div>
        <div class="form-group">
            <label for="exampleFormControlFile1" style="font-size: 30px">Выбрать аватар: </label>
            <input type="file" name="img" class="form-control-file" id="exampleFormControlFile1">
        </div>
        <div class="form-group" style="margin-left: 50px; margin-top: 30px">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="gridCheck" name="remember_me">
                <label class="form-check-label" for="gridCheck">
                    Запомнить меня
                </label>
            </div>
        </div>
        <input class="btn btn-primary" style="margin-left: 50px; margin-top: 50px; margin-bottom: 50px" type="submit">
        <a href="/login" class="btn btn-primary">Войдите если ужезарегестрованы</a>
    </form>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
            crossorigin="anonymous"></script>
    </body>
    </html>
</#macro>