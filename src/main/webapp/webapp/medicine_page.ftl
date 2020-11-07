<#ftl encoding="utf-8">
<#include "base.ftl">
<link rel="stylesheet" href="../webapp/css/medicine_page.css">
<#macro title>Лекарства</#macro>
<#macro css>
</#macro>
<#macro content>
    <div class="blog">
        <div class="container">
            <div class="row">
                <#if drags??>
                    <#list drags as drag>
                        <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
                            <div class="card">
                                <a href="/medicine?id=${drag.id}">
                                    <img src="localhost:8080\images\${drag.path_of_img}" class="card-img-top" alt="...">
                                    <div class="card-body">

                                        <h3>${drag.name}</h3>

                                    </div>
                                </a>
                            </div>
                        </div>
                    </#list>
                </#if>
            </div>
        </div>
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