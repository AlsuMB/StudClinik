<#ftl encoding="utf-8">
<#include "base.ftl">
<#macro title>Статьи</#macro>
<#macro css>
    <link rel="stylesheet" href="css/style.css">
    <script>
        $(document).on("click", "#ajaxbutton", function () {
            $.get("/greeting", function (responseText) {
                $("#ajaxdiv").text(responseText);
            });
        });
    </script>
</#macro>
<#macro content>
    <#if article??>
        <div class="card" style="margin-top: 120px">
            <div class="card-body">
                <h2 style="margin-left: 260px">${article.title}</h2>
                <p>${article.text}</p>
                <img src="../img/wim-van-t-einde-uj7eb7CgqRk-unsplash.jpg"
                     style="margin-top: 20px; margin-bottom: 20px; height: 500px; margin-left: 230px">
            </div>
        </div>
    </#if>
    <div class="card">
        <div class="card-body">
            <span>Вариант комментария</span>
            <#if answers??>
                <#list answers as answer>

                    <div class="card-body" style="margin-left: 100px">
                        <span>Вариант ответа на комментарий</span>
                        <p><a href="#" style="color: #116062; padding-top: 10px">Аккаунт узера</a></p>
                        <button class="btn btn-primary"
                                style="padding: 5px 10px 5px 10px; color: #116062; background-color: #ffffff"><img
                                    src="../img/thumb-up.png" style="height: 20px; width: 20px"> 5
                        </button>
                        <button class="btn btn-primary"
                                style="padding: 5px 10px 5px 10px; color: #116062; background-color: #ffffff"><img
                                    src="../img/thumb-down.png" style="height: 20px; width: 20px"> 0
                        </button>
                        <p style="margin-top: 10px">
                            <button class="btn btn-primary">Ответить</button>
                        </p>
                    </div>
                </#list>
            </#if>
        </div>
    </div>

    <div class="card">
        <div class="card-body">
            <span>Вариант комментария</span>
            <p><a href="#" style="color: #116062; padding-top: 10px">Аккаунт узера</a></p>
            <button class="btn btn-primary"
                    style="padding: 5px 10px 5px 10px; color: #116062; background-color: #ffffff"><img
                        src="../img/thumb-up.png" style="height: 20px; width: 20px"> 5
            </button>
            <button class="btn btn-primary"
                    style="padding: 5px 10px 5px 10px; color: #116062; background-color: #ffffff"><img
                        src="../img/thumb-down.png" style="height: 20px; width: 20px"> 0
            </button>
            <p style="margin-top: 10px">
                <button class="btn btn-primary">Ответить</button>
            </p>
        </div>
    </div>
    <div id="ajaxbutton">
        <form action="/article?id=<#if article??>${article.id}</#if>">
            <div class="form-group">
                <label for="exampleFormControlTextarea1" style="font-size: 30px">Ваш комментарий: </label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="text"></textarea>
            </div>
            <input type="submit" class="btn btn-primary" style="margin-top: 25px; margin-left: 1100px; margin-bottom: 20px; padding: 10px 20px 10px 20px; color: #116062; background-color: #ffffff">
        </form>
    </div>


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