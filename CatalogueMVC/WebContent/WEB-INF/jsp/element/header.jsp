<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
  <link rel="shortcut icon" href="public/images/logo.ico">
</head>
<body>
<!--=== Header ===-->
    <div class="header">
        <div class="container">
            <!-- Logo -->
            <a class="logo" href="index.html">
                <img src="public/images/logo.jpg" alt="Logo">
            </a>
            <!-- End Logo -->

            <!-- Topbar -->
            <div class="topbar">
                <ul class="loginbar pull-right">
                    <li class="topbar-devider"></li>
                    <li><a href="page_faq.html">Aide</a></li>
                    <li class="topbar-devider"></li>
                    <li><a href="page_login.html">Crowfounding</a></li>
                </ul>
            </div>
            <!-- End Topbar -->

            <!-- Toggle get grouped for better mobile display -->
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="fa fa-bars"></span>
            </button>
            <!-- End Toggle -->
        </div><!--/end container-->

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse mega-menu navbar-responsive-collapse">
            <div class="container">
                <ul class="nav navbar-nav">
                    <!-- Home -->
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                            Acceuil
                        </a>
                    </li>
                    <!-- End Home -->

                    <!-- Pages -->
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                            Catalogues
                        </a>
                        <ul class="dropdown-menu">
                            <!-- About Pages -->
                            <li class="dropdown-submenu">
                                <a href="javascript:void(0);">About Pages</a>
                                <ul class="dropdown-menu">
                                    <li><a href="page_about2.html">About Us </a></li>
                                    <li><a href="page_about3.html">About Us 1</a></li>
                                    <li><a href="page_about1.html">About Us 2</a></li>
                                    <li><a href="page_about.html">About Us 3</a></li>
                                    <li><a href="page_about_me.html">About Me </a></li>
                                    <li><a href="page_about_me1.html">About Me 1</a></li>
                                    <li><a href="page_about_me2.html">About Me 2</a></li>
                                    <li><a href="page_about_our_team.html">About Our Team</a></li>
                                    <li><a href="page_about_our_team1.html">About Our Team 1</a></li>
                                    <li><a href="page_about_our_team2.html">About Our Team 2</a></li>
                                </ul>
                            </li>
                            <!-- End About Pages -->
                        </ul>
                    </li>
                    <!-- End Pages -->

                    <!-- Blog -->
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                            EQUIPE
                        </a>
                    </li>
                    <!-- End Blog -->
                </ul>
            </div><!--/end container-->
        </div><!--/navbar-collapse-->
    </div>
    <!--=== End Header ===-->
</body>
</html>