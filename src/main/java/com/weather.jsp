
<%@ page import="com.UserDAO" %>
<%@ page import="com.CheckCity" %>
<%@ page import="com.WeatherAPI" %>
<%@ page import="com.Weather" %>

<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style2.css">
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>


        <form class="navbar-form navbar-left">
            <div class="form-group">
                <font size="5" color="white">Check other cities weather</font>
                <input type="text" class="form-control" placeholder="city name">
            </div>
            <button type="submit" class="btn btn-default">Check</button>
        </form>


    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="container">
    <div class="row">
        <!-- .col-sm-9+.col-sm-3 -->
        <div class="col-sm-9">
            <div class="jumbotron">
                <P><font size="5">Krakow, Poland weather</font></P>
                <P><font size="2"><%=new java.util.Date()%></font></P>
                <P><font size="25"> <%
                    CheckCity checkCity=new CheckCity();
                    WeatherAPI weatherAPI = new WeatherAPI(checkCity.CheckCityID("Kraków","PL"));
                    System.out.println(weatherAPI.getWeatherDataByIndex(0).getTemperature());
                %></font></P>
                <P><font size="2"><%
                    System.out.println(weatherAPI.getWeatherDataByIndex(0).getClouds());
                %></font></P>
                <p><a class="btn btn-primary  btn-lg" href="#" role="button">Learn more</a></p>


            </div>

            <div class="row">
                <div class="col-xs-6 col-lg-4">
                    <h2>topics 1</h2>
                    <p>The State of Mississippi filed a brief with the Supreme Court on Thursday defending the state’s ban on abortion after 15 weeks of pregnancy and asking the court to overturn Roe v. Wade when it hears arguments on the case in the fall, raising the stakes of what was already set to be the term’s biggest reproductive rights case.</p>
                    <p><a class="btn btn-default"href="#">learn more </a></p>


                </div>
                <div class="col-xs-6 col-lg-4">
                    <h2>topics 2</h2>
                    <p>The State of Mississippi filed a brief with the Supreme Court on Thursday defending the state’s ban on abortion after 15 weeks of pregnancy and asking the court to overturn Roe v. Wade when it hears arguments on the case in the fall, raising the stakes of what was already set to be the term’s biggest reproductive rights case.</p>
                    <p><a class="btn btn-default"href="#">learn more </a></p>


                </div>


                <div class="col-xs-6 col-lg-4">
                    <h2>topics 3</h2>
                    <p>The State of Mississippi filed a brief with the Supreme Court on Thursday defending the state’s ban on abortion after 15 weeks of pregnancy and asking the court to overturn Roe v. Wade when it hears arguments on the case in the fall, raising the stakes of what was already set to be the term’s biggest reproductive rights case.</p>
                    <p><a class="btn btn-default"href="#">learn more </a></p>


                </div>





            </div>
        </div>

        <div class="col-sm-3">
            <ul class="list-group">
                <li class="list-group-item">next 1 days weather</li>
                <P><font size="5"><%
                    System.out.println(weatherAPI.getWeatherDataByIndex(8).getTemperature());
                %></font></P>
                <P><font size="2"><%
                    System.out.println(weatherAPI.getWeatherDataByIndex(8).getClouds());
                %></font></P>
                <p><a class="btn btn-primary  btn-xs" href="#" role="button">Learn more</a></p>

                <li class="list-group-item">next 2 days weather </li>
                <P><font size="5"> <%
                    System.out.println(weatherAPI.getWeatherDataByIndex(16).getTemperature());
                %></font></P>
                <P><font size="2"><%
                    System.out.println(weatherAPI.getWeatherDataByIndex(16).getClouds());
                %></font></P>
                <p><a class="btn btn-primary  btn-xs" href="#" role="button">Learn more</a></p>
                <li class="list-group-item">next 3 days weather</li>
                <P><font size="5"> <%
                    System.out.println(weatherAPI.getWeatherDataByIndex(24).getTemperature());
                %></font></P>
                <P><font size="2"><%
                    System.out.println(weatherAPI.getWeatherDataByIndex(24).getClouds());
                %></font></P>
                <p><a class="btn btn-primary  btn-xs" href="#" role="button">Learn more</a></p>
            </ul>
        </div>
    </div>
</div>






<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</body>
</html>