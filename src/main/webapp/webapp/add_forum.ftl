<#ftl encoding="utf-8">
<#include "base.ftl">
<#macro title>Добавить новый вопрос</#macro>
<#macro css>
    <link rel="stylesheet" href="css/style.css"></#macro>
<#macro content>
    <form  enctype='multipart/form-data' action="/add_new_forum" method="post">
        <div class="form-group">
            <label for="exampleFormControlInput1" style="font-size: 30px">Тема вопроса</label>
            <textarea name="title" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Кратко опишите проблему"></textarea>
        </div>
        <div class="form-group">
            <label for="exampleFormControlTextarea1" style="font-size: 30px">Ваш вопрос</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="text"></textarea>
        </div>
        <div class="form-group">
            <label for="exampleFormControlFile1" style="font-size: 30px">Вставить изображение: </label>
            <input type="file" name="img" class="form-control-file" id="exampleFormControlFile1">
        </div>
        <input type="submit" class="btn btn-primary" style="margin-top: 30px; margin-left: 1100px; margin-bottom: 20px; padding: 10px 20px 10px 20px; color: #116062; background-color: #ffffff">Отправить</input>
    </form>



    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</#macro>