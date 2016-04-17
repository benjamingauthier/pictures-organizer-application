<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
</head>
<body>
 <!--=== Footer Version 1 ===-->
    <div class="footer-v1">
        <div class="footer">
            <div class="container">
                <div class="row">
                    <!-- About -->
                    <div class="col-md-4 md-margin-bottom-40">
                        <a href="/"><img id="logo-footer" class="footer-logo" src="${pageContext.request.contextPath}/public/images/logo_cat.jpg" alt=""></a>
                    	<p>Fondé en 2005 par 4 miagistes, Cat'Log a su se démarquer fasse à ses concurrents tel que Flicker et ce grâce à un puissant outil de gestion de photos. 
                    	<br>
                    	Cat’Log est devenu en quelque temps l'outil indispensable pour gérer vos catalogues photos. We Love Cat’Log.
                    	<br></p>
                    </div><!--/col-md-3-->
                    <!-- End About -->

                    <!-- Link List -->
                    <div class="col-md-4 md-margin-bottom-40">
                        <div class="headline"><h2>Liens Utiles</h2></div>
                        <ul class="list-unstyled link-list">
                            <li><a href="/CatalogueMVC/catalogue/team">L'équipe</a><i class="fa fa-angle-right"></i></li>
                            <li><a href="https://github.com/benjamingauthier/pictures-organizer-application/tree/develop">Dépôt Github</a><i class="fa fa-angle-right"></i></li>
                            <li><a href="mailto:carval.audrey@gmail.com">Nous contacter</a><i class="fa fa-angle-right"></i></li>
                        </ul>
                    </div><!--/col-md-3-->
                    <!-- End Link List -->

                    <!-- Address -->
                    <div class="col-md-4 map-img md-margin-bottom-40">
                        <div class="headline"><h2>Nous contacter</h2></div>
                        <address class="md-margin-bottom-40">
                            <h4>Cat'LOG.</h4>
							<strong>Université bordeaux 1</strong><br>
							351 Cours de la Libération,<br>
							33400 Talence.<br>
							E-mail : <a href="mailto:carval.audrey@gmail.com" class="">carval.audrey@gmail.com</a>
                        </address>
                    </div><!--/col-md-3-->
                    <!-- End Address -->
                </div>
            </div>
        </div><!--/footer-->

        <div class="copyright">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <p>
                            2015 &copy; All Rights Reserved.
                        </p>
                    </div>

                    <!-- Social Links -->
                    <div class="col-md-6">
                        <ul class="footer-socials list-inline">
                            <li>
                                <a href="https://github.com/benjamingauthier/pictures-organizer-application/tree/develop" class="tooltips" data-toggle="tooltip" data-placement="top" title="" data-original-title="Github">
                                    <i class="fa fa-github"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <!-- End Social Links -->
                </div>
            </div>
        </div><!--/copyright-->
    </div>
    <!--=== End Footer Version 1 ===-->
</body>
</html>