<#ftl encoding="utf-8">
<#include "base.ftl">
<#macro title>Поиск</#macro>
<#macro css>
    <link rel="stylesheet" href="../webapp/css/style.css">
</#macro>
<#macro content>
<#if articles??>
    <#list articles as artile>
        <div>
            ${artile}
        </div>
    </#list>
</#if>
</#macro>