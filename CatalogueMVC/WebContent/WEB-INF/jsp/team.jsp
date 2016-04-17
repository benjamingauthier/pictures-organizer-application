<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>


	<!-- Meta -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Favicon -->
    <link rel="shortcut icon" href="favicon.ico">

    <!-- Web Fonts -->
    <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600&amp;subset=cyrillic,latin">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	
    <!-- CSS Global Compulsory -->
    <link rel="stylesheet" href="public/css/bootstrap.min.css">
    <link rel="stylesheet" href="public/css/style.css">
    <link rel="stylesheet" href="public/css/blocks.css">

    <!-- CSS Header and Footer -->
    <link rel="stylesheet" href="public/css/header-default.css">
    <link rel="stylesheet" href="public/css/footer-v1.css">

    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="public/css/animate.css">
    <link rel="stylesheet" href="public/css/line-icons.css">
    <link rel="stylesheet" href="public/css/font-awesome.min.css">
    <link rel="stylesheet" href="public/css/cubeportfolio.min.css">
    <link rel="stylesheet" href="public/css/custom-cubeportfolio.css">
    
    <link rel="stylesheet" href="public/css/ie8.css">
	<link rel="stylesheet" href="public/css/plugin.css">
    <link rel="stylesheet" href="public/css/app.css">
    <link rel="stylesheet" href="public/css/style-switcher.css">
    
    <!-- CSS Customization -->
    <link rel="stylesheet" href="public/css/custom.css">
    
<title>Insert title here</title>
</head>
<body class="header-fixed">
	<div class="wrapper">
		<jsp:include page="/WEB-INF/jsp/element/header.jsp" />
		
		<!--=== Breadcrumbs v3 ===-->
	    <div class="breadcrumbs-v3 img-v1">
	        <div class="container text-center">
	            <p>EQUIPE</p>
	            <h1>DECOUVREZ L'EQUIPE</h1>
	        </div><!--/end container-->
	    </div>
	    <!--=== End Breadcrumbs v3 ===-->

	    <hr class="margin-bottom-60">

	    <!--=== Team v6 ===-->
	    <div class="container">
	        <div class="headline-center margin-bottom-60">
	            <h2>LES MEMBRES</h2>
	            <p>Etudiants en formation MIAGE à l'Université de Bordeaux.<br>
	        </div>
	
	        <div class="row team-v6 margin-bottom-60">
	            <div class="col-md-3 col-sm-6 md-margin-bottom-50">
	                <img class="img-responsive" src="../public/amine.jpg" alt="amine">
	                <span>Amine</span>
	            </div>
	            <div class="col-md-3 col-sm-6 md-margin-bottom-50">
	                <img class="img-responsive" src="assets/img/team/img4-md.jpg" alt="ben">
	                <span>Benjamin</span>
	            </div>
	            <div class="col-md-3 col-sm-6 sm-margin-bottom-50">
	                <img class="img-responsive" src="assets/img/team/img2-md.jpg" alt="audrey">
	                <span>Audrey</span>
	            </div>
	            <div class="col-md-3 col-sm-6">
	                <img class="img-responsive" src="assets/img/team/img1-md.jpg" alt="rihta">
	                <span>Rihta</span>
	            </div>
	        </div><!--/end team v6-->
	    </div>
	    <!--=== End Team v6 ===-->
	
	    <!--=== Call To Action v2 ===-->
	    <div class="call-action-v2 parallaxBg">
	        <div class="container">
	            <h2>Nous rectrutons !</h2>
	            <p>Envoyez-nous votre candidature !</p>
	            <a href="mailto:carval.audrey@gmail.com" class="btn-u">Envoyer</a>
	        </div>
	    </div>
	    <!--=== End Call To Action v2 ===-->

		<jsp:include page="/WEB-INF/jsp/element/footer.jsp" />
	</div>
<!-- JS Global Compulsory -->
<script src="public/js/jquery.min.js"></script>
<script src="public/js/jquery-migrate.min.js"></script>
<script src="public/js/bootstrap.min.js"></script>

<!-- JS Implementing Plugins -->
<script src="public/js/back-to-top.js"></script>
<script src="public/js/smoothScroll.js"></script>
<script src="public/js/jquery.cubeportfolio.min.js"></script>


<!-- JS Customization -->
<script src="public/js/custom.js"></script>

<!-- JS Page Level -->
<script src="public/js/app.js"></script>
<script src="public/js/cube-portfolio-3.js"></script>

<script type="text/javascript">
    jQuery(document).ready(function() {
        App.init();
    });
</script>
<!--[if lt IE 9]>
    <script src="assets/plugins/respond.js"></script>
    <script src="assets/plugins/html5shiv.js"></script>
    <script src="assets/plugins/placeholder-IE-fixes.js"></script>
<![endif]-->
</body>
</html>