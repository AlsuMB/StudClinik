<#ftl encoding="utf-8">
<#include "base.ftl">
<#macro title>Личный кабинет</#macro>
<#macro css>
    <link rel="stylesheet" href="../webapp/css/style.css">
</#macro>
<#macro content>
    <#if user??>
        <div class="card" style="margin-top: 120px; margin-bottom: 100px">
            <div class="card-body">
                <img src="path_for_site/${user.img}" type="file"
                     style="margin-top: 20px; margin-bottom: 20px; height: 150px; margin-left: 10px" alt="Avatar">
                <p>
                    <span style="font-size: 20px; font-weight: bold">Имя: </span>
                    ${user.name}
                </p>
                <p><span style="font-size: 20px; font-weight: bold">Логин: </span>${user.login}</p>
                <a href="/update_account" class="btn btn-primary">Изменить</a>
            </div>
        </div>
    </#if>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</#macro>
</html>