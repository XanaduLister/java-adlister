<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link href='https://fonts.googleapis.com/css?family=Permanent+Marker' rel='stylesheet'>
<link rel="stylesheet" href="css/login.css">

<style>
    <%@include file="css/navbar.css"%>
    body {
        background-color: lightgrey;
    }
</style>

<nav class="navHeight pt-0 pl-0 navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="pt-0 navbar-brand mr-0" href="/login"><img class="imgSize" src="https://cdn.discordapp.com/attachments/524262190669234186/524659609126830082/Cody.png" alt="Cody"></a>
    <a class="customfont fontSize16 text-success" href="/login">CODY'S CURIOSITIES</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="fontSize22 font-weight-bold nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Account
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="fontSize16 dropdown-item" href="/profile">Profile</a>
                    <a class="fontSize16 dropdown-item" href="/ads">All Ads</a>
                    <a class="fontSize16 dropdown-item" href="/ads/create">Create Ad</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0 btn-group-lg input-group-lg">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="ml-3 btn btn-outline-success btn-lg" type="submit">Search</button>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <form class="my-2 my-lg-0 btn-group-lg" action="/login">
                <button class="ml-3 btn btn-outline-success" type="submit">Login</button>
            </form>
            <form class="my-2 my-lg-0 btn-group-lg" action="/logout">
                <button class="ml-3 btn btn-outline-success" type="submit">Logout</button>
            </form>
        </ul>
    </div>
</nav>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>