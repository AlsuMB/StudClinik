<#ftl encoding="utf-8">
<#include "base.ftl">
<#macro title>Статьи</#macro>
<#macro css>
    <link rel="stylesheet" href="css/style.css"></#macro>
<#macro content>
    <div class="blog">
        <div class="container">
            <h1 class="text-center">Статьи</h1>
            <div class="row">
                <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
                    <div class="card">
                        <a href="/add_new_article">
                            <img src="img/roman-kraft-_Zua2hyvTBk-unsplash.jpg" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h3>Новая статья</h3>
                                <img src="img/add.png" style="height: 70px; width: 70px">
                            </div>
                        </a>
                    </div>
                </div>
                <#if articles??>
                    <#list articles as article>
                        <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
                            <div class="card">
                                <a href="/article?id=${article.id}">
                                    <img src="img/wim-van-t-einde-uj7eb7CgqRk-unsplash.jpg" class="card-img-top"
                                         alt="...">
                                    <div class="card-body">
                                        <h3>${article.title}</h3>
                                        <p>
                                            <span style="display: inline-block">${article.text}</span>
                                        </p>
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