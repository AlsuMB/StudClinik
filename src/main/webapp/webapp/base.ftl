<html lang="en">
<head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title><@title></@title></title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <@css></@css>

</head>

<body>
<header class="header">
    <menu class="menu">
        <nav class="navbar navbar-expand-lg fixed-top" style="background-color: #ffffff; position: fixed; z-index: 1">
            <a class="navbar-brand" href="undone/page.html" style="color: #116062; padding-right: 15px">
                <img src="img/cure.png" height="65" width="65">
                Health.com
            </a>

            <ul class="navbar-nav mr-auto">
                <li class="navbar-brand">
                    <a class="nav-link" href="/forum" style="color: #116062">Форум</a>
                </li>

                <li class="navbar-brand">
                    <a class="nav-link" href="/medicines" style="color: #116062">Лекарства</a>
                </li>

                <li class="navbar-brand">
                    <a class="nav-link" href="/articles" style="color: #116062">Статьи</a>
                </li>

                <li class="navbar-brand">
                    <a class="nav-link" href="/account" style="color: #116062 ">Личный кабинет</a>
                </li>
            </ul>

            <form class="form-inline my-2 my-lg-0" action="/search" method="get">
                <input class="form-control mr-sm-2" type="search" placeholder="Поиск..." aria-label="Search" name="search">
                <button class="btn btn-light" type="submit">Поиск</button>
            </form>
        </nav>
    </menu>
</header>

<div class="content1">
    <div class="content"><@content></@content></div>
</div>

</body>
</html>