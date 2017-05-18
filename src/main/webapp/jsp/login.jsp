
<%--
Created by IntelliJ IDEA.
User: Administrator
Date: 2017/5/16
Time: 14:16
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Wopop</title>
<link href="../static/CSS/style_log.css" rel="stylesheet" type="text/css">
<script src="/jsp/js/jquery.min.js"></script>
 <script src="/jsp/common/js/ajax.js"></script>
</head>

<body class="login" mycollectionplug="bind">
<div class="login_m">
<div class="login_logo"><img src="../static/img/logo.png" width="196" height="46"></div>
<div class="login_boder">

<div class="login_padding" id="login_model">

  <h2>用户名:</h2>
  <label>
    <input type="text" id="username" class="txt_input txt_input2" onfocus="if (value ==&#39;Your name&#39;){value =&#39;&#39;}" onblur="if (value ==&#39;&#39;){value=&#39;Your name&#39;}" value="Your name">
  </label>
  <h2>密码:</h2>
  <label>
    <input type="password" name="textfield2" id="userpwd" class="txt_input" onfocus="if (value ==&#39;******&#39;){value =&#39;&#39;}" onblur="if (value ==&#39;&#39;){value=&#39;******&#39;}" value="******">
  </label>
  <p class="forgot"><a id="iforget" href="javascript:void(0);">忘记密码?</a></p>
  <div class="rem_sub">
  <div class="rem_sub_l">
  <input type="checkbox" name="checkbox" id="save_me">
   <label for="checkbox">记住密码</label>
   </div>
    <label>
      <input type="submit" class="sub_button" name="button" id="login" onclick="loginAjax()" value="登录" style="opacity: 0.7;">
    </label>
  </div>
</div>

    <div class="line"></div>
    <div class="third-part tracking-ad">
        <span>第三方平台登录</span>
        <div class="loginlogos">
            <div ><img src="/static/img/qq.png" class="qqlogo" ></div>
            <div ><img src="/static/img/weixin.png" class="weixinlogo"></div>
            <div ><img src="/static/img/xinlang.png" class="xinlanglogo"></div>
        </div>
    </div>

<!--login_padding  Sign up end-->
</div><!--login_boder end-->
</div><!--login_m end-->
</body>
<script>
    function loginAjax() {
        var user ={
            username :$("#username").val(),
            password :$("#userpwd").val()
        }
        $.ajax({
            type: "post",
            data: user,
            url: "/user/login",
            dataType: "json",
            success: function(data){
                if (data.isSuccee){
                    window.location.href="/jsp/index.jsp"
                }else {
                    alert(data.des)
                }
            }
        });
//        $.ajaxPost("/user/login",user,function (success) {
//            alert("成功！")
//        },function (err) {
//            alert(JSON.stringify(err))
//        })
    }

</script>
</html>