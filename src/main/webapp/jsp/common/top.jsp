<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/16
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>top</title>
    <link href="/static/CSS/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
</head>
<body>

<div id="top_bg">
    <div class="top">
        <!--导航开始-->
        <div class="nav_z">
            <ul id="navul" class="cl">
                <div id="notInLogin">
                    <li>
                        <a href="/jsp/login.jsp">登录</a>
                    </li>
                    <li>
                        <a href="#">注册</a>
                    </li>
                </div>
                <div id="inLogin" disabled="none">
                    <li> <a href='#'>${sessionScope.userId}</a> </li> <li> <a href='#'>退出</a> </li>
                </div>

                <!--可在此处直接添加导航-->
            </ul>
        </div><!--导航结束-->

    </div>


</div>
</body>
<script>

    $(function () {
        //头页登录
        $("#navul > li").not(".navhome").hover(function () {
            $(this).addClass("navmoon")
        }, function () {
            $(this).removeClass("navmoon")
        });
        if (${sessionScope.userId !=null}){
            $("#notInLogin").css("display","none");
           // $("#inLogin").append("<li> <a href='#'>${sessionScope.userId}</a> </li> <li> <a href='#'>退出</a> </li>")
            $("#inLogin").css("display","block");
        }else {
            $("#inLogin").css("display","none");
            $("#notInLogin").css("display","block");
        }

    });
</script>
</html>