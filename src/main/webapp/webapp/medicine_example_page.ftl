<#ftl encoding="utf-8">
<#include "base.ftl">
<#macro title><#if drag??>${drag.name}</#if></#macro>
<#macro css>
    <link rel="stylesheet" href="../webapp/css/medicine_example_page.css">
</#macro>
<#macro content>
    <#if drag??>
        <div class="card" style="margin-top: 120px">
            <div class="card-body">
                <h2 style="margin-left: 500px">${drag.name}</h2>
                <p style="font-weight: bold">Показания: </p>
                <p>${drag.mode_of_application}</p>
                <p style="font-weight: bold">Остальное: </p>
                <p>${drag.other}</p>
                </div>
        </div>
    </#if>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</#macro>
</html>