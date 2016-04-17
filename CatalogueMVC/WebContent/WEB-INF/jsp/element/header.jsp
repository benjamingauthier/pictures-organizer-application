<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
</head>
<body>
<!--=== Header ===-->
    <div class="header">
        <div class="container">
            <!-- Logo -->
            <a class="logo" href="/CatalogueMVC/catalogue/">
                <img src="${pageContext.request.contextPath}/public/images/logo.jpg" alt="Logo">
            </a>
            <!-- End Logo -->

            <!-- Topbar -->
            <div class="topbar">
                <ul class="loginbar pull-right">
                    <li class="topbar-devider"></li>
                    <li><a href="/CatalogueMVC/catalogue/help">Aide</a></li>
                    <li class="topbar-devider"></li>
                    <li><a href="https://www.kickstarter.com/">Crowfounding</a></li>
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
                        <a href="/CatalogueMVC/catalogue/">
                            Catalogues
                        </a>
                    </li>
                    <!-- End Home -->

                    <!-- Blog -->
                    <li class="dropdown">
                        <a href="/CatalogueMVC/catalogue/team" class="dropdown-toggle" >
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