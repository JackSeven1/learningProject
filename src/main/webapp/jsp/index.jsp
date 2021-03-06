<%--
Created by IntelliJ IDEA.
User: Administrator
Date: 2017/5/16
Time: 14:16
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Home</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <!-- Bootstrap styles -->
    <link rel="stylesheet" href="/jsp/css/bootstrap.min.css">
   
    <!-- Font-Awesome -->
    <link rel="stylesheet" href="/jsp/css/font-awesome/css/font-awesome.min.css">

    <!-- Google Webfonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600|PT+Serif:400,400italic' rel='stylesheet' type='text/css'>

    <!-- Styles -->
    <link rel="stylesheet" href="/jsp/css/style.css" id="theme-styles">

    <!--[if lt IE 9]>      
        <script src="/jsp/js/respond.js"></script>
    <![endif]-->
    
</head>
<body>
<jsp:include page="common/top.jsp"></jsp:include>
    <header>
        <div class="widewrapper masthead">
            <div class="container">
                <a href="/jsp/index.jsp" id="logo">
                    <img src="../static/img/logo1.png" alt="clean Blog">
                </a>
        
                <div id="mobile-nav-toggle" class="pull-right">
                    <a href="#" data-toggle="collapse" data-target=".clean-nav .navbar-collapse">
                        <i class="fa fa-bars"></i>
                    </a>
                </div>

                <nav class="pull-right clean-nav">
                    <div class="collapse navbar-collapse">
                        <ul class="nav nav-pills navbar-nav">
                          
                            <li>
                                <a href="/jsp/index.jsp">主页</a>
                            </li>
                            <li>
                                <a href="/jsp/about.jsp">关于</a>
                            </li>
                            <li>
                                <a href="/jsp/contact.jsp">联系我</a>
                            </li>                        
                        </ul>
                    </div>
                </nav>        

            </div>
        </div>

        <div class="widewrapper subheader">
            <div class="container">
                <div class="clean-breadcrumb">
                    <a href="#">博客</a>
                </div>

                <div class="clean-searchbox">
                    <form action="#" method="get" accept-charset="utf-8">
                        <input class="searchfield" id="searchbox" type="text" placeholder="搜索">
                        <button class="searchbutton" type="submit">
                            <i class="fa fa-search"></i>
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </header>

    <div class="widewrapper main">
        <div class="container">
            <div class="row">
                <div class="col-md-8 blog-main">
                    <div class="row">
                        <div class="col-md-6 col-sm-6">
                            <article class=" blog-teaser">
                                <header>
                                    <img src="../static/img/1.jpg" alt="">
                                    <h3><a href="/jsp/single.jsp">How to Create Template</a></h3>
                                    <span class="meta">19 August 2017, John Doe</span>
                                    <hr>
                                </header>
                            
                            </article>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <article class="blog-teaser">
                                <header>
                                    <img src="../static/img/2.jpg" alt="">
                                    <h3><a href="/jsp/single.jsp">Clean Personal Blog Template</a></h3>
                                    <span class="meta">19 August 2017, John Doe</span>
                                    <hr>
                                </header>
                            
                            </article>
                        </div>
                    </div>
        
                    <div class="row">
                        <div class="col-md-6 col-sm-6">
                            <article class="blog-teaser">
                                <header>
                                    <img src="../static/img/4.jpg" alt="">
                                    <h3><a href="/jsp/single.jsp">Blackor - Responsive HTML5 Theme</a></h3>
                                    <span class="meta">19 August 2017, John Doe</span>
                                    <hr>
                                </header>
                               
                            </article>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <article class=" blog-teaser">
                                <header>
                                    <img src="../static/img/1.jpg" alt="">
                                    <h3><a href="/jsp/single.jsp">How to Create Template</a></h3>
                                    <span class="meta">19 August 2017, John Doe</span>
                                    <hr>
                                </header>
                            
                            </article>
                        </div>

                    </div>
                     <div class="row">
                        <div class="col-md-6 col-sm-6">
                            <article class="blog-teaser">
                                <header>
                                    <img src="../static/img/3.jpg" alt="">
                                    <h3><a href="/jsp/single.jsp">Blackor - Responsive HTML5 Theme</a></h3>
                                    <span class="meta">19 August 2017, John Doe</span>
                                    <hr>
                                </header>
                               
                            </article>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <article class=" blog-teaser">
                                <header>
                                    <img src="../static/img/1.jpg" alt="">
                                    <h3><a href="/jsp/single.jsp">How to Create Template</a></h3>
                                    <span class="meta">19 August 2017, John Doe</span>
                                    <hr>
                                </header>
                            
                            </article>
                        </div>

                    </div>
                     <div class="row">
                        <div class="col-md-6 col-sm-6">
                            <article class="blog-teaser">
                                <header>
                                    <img src="../static/img/3.jpg" alt="">
                                    <h3><a href="/jsp/single.jsp">Blackor - Responsive HTML5 Theme</a></h3>
                                    <span class="meta">19 August 2017, John Doe</span>
                                    <hr>
                                </header>
                               
                            </article>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <article class=" blog-teaser">
                                <header>
                                    <img src="../static/img/5.jpg" alt="">
                                    <h3><a href="/jsp/single.jsp">How to Create Template</a></h3>
                                    <span class="meta">19 August 2017, John Doe</span>
                                    <hr>
                                </header>
                            
                            </article>
                        </div>

                    </div>

                    <div class="paging">
                        <a href="#" class="older">Older Post</a>
                    </div>
                </div>
                <aside class="col-md-4 blog-aside">
                    
                    <div class="aside-widget">
                        <header>
                            <h3>推荐</h3>
                        </header>
                        <div class="body">
                            <ul class="clean-list">
                                <li><a href="">Clean - Responsive HTML5 Template</a></li>
                                <li><a href="">Responsive Pricing Table</a></li>
                                <li><a href="">Yellow HTML5 Template</a></li>
                                <li><a href="">Blackor Responsive Theme</a></li>
                                <li><a href="">Portfolio Bootstrap Template</a></li>
                                <li><a href="">Clean Slider Template</a></li>
                            </ul>
                        </div>
                    </div>
                
                    <div class="aside-widget">
                        <header>
                            <h3>相关文章</h3>
                        </header>
                        <div class="body">
                            <ul class="clean-list">
                                <li><a href="">Blackor Responsive Theme</a></li>
                                <li><a href="">Portfolio Bootstrap Template</a></li>
                                <li><a href="">Clean Slider Template</a></li>
                                <li><a href="">Clean - Responsive HTML5 Template</a></li>
                                <li><a href="">Responsive Pricing Table</a></li>
                                <li><a href="">Yellow HTML5 Template</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="aside-widget">
                        <header>
                            <h3>标签</h3>
                        </header>
                        <div class="body clearfix">
                            <ul class="tags">
                                <li><a href="#">HTML5</a></li>
                                <li><a href="#">CSS3</a></li>
                                <li><a href="#">COMPONENTS</a></li>
                                <li><a href="#">TEMPLATE</a></li>
                                <li><a href="#">PLUGIN</a></li>
                                <li><a href="#">BOOTSTRAP</a></li>
                                <li><a href="#">TUTORIAL</a></li>
                                <li><a href="#">UI/UX</a></li>                            
                            </ul>
                        </div>
                    </div>
                </aside>
            </div>
        </div>
    </div>

    <footer>
        <div class="widewrapper footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 footer-widget">
                        <h3> <i class="fa fa-user"></i>About</h3>

                       <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab animi laboriosam nostrum consequatur fugiat at, labore praesentium modi, quasi dolorum debitis reiciendis facilis, dolor saepe sint nemo, earum molestias quas.</p>
                       <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolorum, error aspernatur assumenda quae eveniet.</p>
                    </div>

                    <div class="col-md-4 footer-widget">
                        <h3> <i class="fa fa-pencil"></i> Recent Post</h3>
                        <ul class="clean-list">
                            <li><a href="">Clean - Responsive HTML5 Template</a></li>
                            <li><a href="">Responsive Pricing Table</a></li>
                            <li><a href="">Yellow HTML5 Template</a></li>
                        </ul>
                    </div>

                    <div class="col-md-4 footer-widget">
                        <h3> <i class="fa fa-envelope"></i>Contact Me</h3>

                        <p>Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet.</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nihil fugiat, cupiditate veritatis excepturi tempore explicabo.</p>
                         <div class="footer-widget-icon">
                            <i class="fa fa-facebook"></i><i class="fa fa-twitter"></i><i class="fa fa-google"></i>
                        </div>
                    </div>
                   
                </div>
            </div>
        </div>
    </footer>
    
    <script src="/jsp/js/jquery.min.js"></script>
    <script src="/jsp/js/bootstrap.min.js"></script>
    <script src="/jsp/js/modernizr.js"></script>

</body>
</html>