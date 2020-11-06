<#ftl encoding="utf-8">
<#include "base.ftl">

<#macro title><#if forum??>${forum.title}</#if></#macro>
<#macro css>
    <link rel="stylesheet" href="../webapp/css/forum_pages_example.css">
    <script>
        $(document).on("click", "#ajaxbutton", function () {
            $.get("/greeting", function (responseText) {
                $("#ajaxdiv").text(responseText);
            });
        });
    </script>
</#macro>
<#macro content>
    <#if forum??>
        <div class="card" style="margin-top: 150px">
            <div class="card-body">
                <p style="font-weight: bold">${forum.title}</p>
                <span>${forum.text}</span>
            </div>
        </div>

        <h3 style="margin-top: 20px">Ответы: </h3>

        <#if articles??>
            <#list articles as article>
                <div class="card">
                    <div class="card-body">
                        <span>${article.text}</span>
                        <p><a style="color: #116062; padding-top: 10px">${article.user.name}</a></p>
                    </div>
                </div>
            </#list>
        </#if>
        <div id="ajaxbutton">
            <form method="post" action="/forum_page?id=<#if article??>${article.id}</#if>">

                <div class="form-group">
                    <label for="exampleFormControlTextarea1" style="font-size: 30px">Ваш ответ: </label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="text"></textarea>
                </div>
                <input type="submit" class="btn btn-primary" value="Отправить"
                       style="margin-top: 25px; margin-left: 1100px; margin-bottom: 20px; padding: 10px 20px 10px 20px; color: #116062; background-color: #ffffff">
            </form>
        </div>

    </#if>
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
</html>