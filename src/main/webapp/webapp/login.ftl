<#ftl encoding="utf-8">
<#include "base.ftl">

<#macro title>Логин</#macro>
<#macro css>
    <link href="webapp/css/login_style.css" rel="stylesheet" type="text/css">
<#--    <style>-->
<#--        *{-->
<#--            box-sizing: border-box;-->
<#--        }-->

<#--        a{-->
<#--            text-decoration: none;-->
<#--            display: inline-block;-->
<#--        }-->

<#--        ul, il {-->
<#--            list-style: none;-->
<#--            margin: 0;-->
<#--            padding: 0;-->
<#--            display: inline-block;-->
<#--        }-->

<#--        .menu a + a{-->
<#--            padding-left: 10px;-->
<#--        }-->

<#--        .menu li{-->
<#--            display: inline-block;-->
<#--        }-->

<#--        .menu li + li{-->
<#--            padding-left: 10px;-->
<#--        }-->

<#--        .header{-->
<#--            padding: 0;-->
<#--        }-->

<#--        body {-->
<#--            background-image: url("reproductive-health-supplies-coalition-bymICwLq-E4-unsplash.jpg");-->
<#--            height: 100%;-->
<#--            background-position: center;-->
<#--            background-repeat: no-repeat;-->
<#--            background-size: cover;-->
<#--            background-attachment: fixed;-->
<#--        }-->

<#--        form {-->
<#--            margin-top: 150px;-->
<#--        }-->
<#--    </style>-->
</#macro>
<#macro content>

    <form action="/login" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1" style="font-size: 30px">Логин</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name="login">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1" style="font-size: 30px">Пароль</label>
            <input type="password" class="form-control" id="exampleInputPassword1" name="password">
        </div>
        <div class="form-group form-check" style="margin-left: 10px">
            <input type="checkbox" class="form-check-input" id="exampleCheck1" name="remember_me">
            <label class="form-check-label" for="exampleCheck1">Запомнить меня</label>
        </div>
        <input class="btn btn-primary" type="submit">
        <a href="/registration" class="btn btn-primary">Регистрация</a>
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
</#macro>