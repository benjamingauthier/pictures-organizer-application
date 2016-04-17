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
    <link rel="shortcut icon" href="../public/css/favicon.ico">

    <!-- Web Fonts -->
    <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600&amp;subset=cyrillic,latin">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	
    <!-- CSS Global Compulsory -->
    <link rel="stylesheet" href="../public/css/bootstrap.min.css">
    <link rel="stylesheet" href="../public/css/style.css">
    <link rel="stylesheet" href="../public/css/blocks.css">

    <!-- CSS Header and Footer -->
    <link rel="stylesheet" href="../public/css/header-default.css">
    <link rel="stylesheet" href="../public/css/footer-v1.css">

    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="../public/css/animate.css">
    <link rel="stylesheet" href="../public/css/line-icons.css">
    <link rel="stylesheet" href="../public/css/font-awesome.min.css">
    <link rel="stylesheet" href="../public/css/cubeportfolio.min.css">
    <link rel="stylesheet" href="../public/css/custom-cubeportfolio.css">
    
    <link rel="stylesheet" href="../public/css/ie8.css">
	<link rel="stylesheet" href="../public/css/plugin.css">
    <link rel="stylesheet" href="../public/css/app.css">
    <link rel="stylesheet" href="../public/css/style-switcher.css">
    
    <!-- CSS Customization -->
    <link rel="stylesheet" href="../public/css/custom.css">
    
<title>Insert title here</title>
</head>
<body class="header-fixed">
	<div class="wrapper">
		<jsp:include page="/WEB-INF/jsp/element/header.jsp" />
		<!--=== Breadcrumbs v3 ===-->
	    <div class="breadcrumbs-v3 img-v1">
	        <div class="container text-center">
	            <p>CATALOGUES</p>
	            <h1>SELECTIONNER LE CATALOGUE</h1>
	        </div><!--/end container-->
	    </div>
	    <!--=== End Breadcrumbs v3 ===-->

	    <!--=== Cube-Portfdlio ===-->
    <div class="cube-portfolio">
        <div class="content-xs">
            <div id="filters-container" class="cbp-l-filters-text content-xs">
                <div data-filter="*" class="cbp-filter-item-active cbp-filter-item"> All </div> |
                <div data-filter=".identity" class="cbp-filter-item"> Identity </div> |
                <div data-filter=".web-design" class="cbp-filter-item"> Web Design </div> |
                <div data-filter=".graphic" class="cbp-filter-item"> Graphic </div> |
                <div data-filter=".logos" class="cbp-filter-item"> Logo </div>
            </div><!--/end Filters Container-->
        </div>

        <div id="grid-container" class="cbp-l-grid-fullWidth">
        	<c:forEach var="photo" items="${photos}"  varStatus="loop">
	            <div class="cbp-item graphic">
	                <div class="cbp-caption">
	                    <div class="cbp-caption-defaultWrap">
	                        <img src="../public/${photo.value.getSource()}" alt="${photo.value.getTitre()}">
	                    </div>
	                    <div class="cbp-caption-activeWrap">
	                        <div class="cbp-l-caption-alignCenter">
	                            <div class="cbp-l-caption-body">
	                                <ul class="link-captions">
	                                	<li><a href="../delete/${catalogueId}/photo/${photo.value.getId()}" class=""><i class="back-rouge red rounded-x fa fa-minus" aria-hidden="true"></i></a></li>
			                            <li><a href="../public/${photo.value.getSource()}" class="cbp-lightbox"><i class="back-green rounded-x fa fa-search"></i></a></li>
	                                </ul>
	                                <div class="cbp-l-grid-agency-title"><c:out value="${photo.value.getTitre()}"/></div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
            </c:forEach>
        </div><!--/end Grid Container-->
    </div>
    <!--=== End Cube-Portfdlio ===-->

		<jsp:include page="/WEB-INF/jsp/element/footer.jsp" />
	</div>
<!-- JS Global Compulsory -->
<script src="../public/js/jquery.min.js"></script>
<script src="../public/js/jquery-migrate.min.js"></script>
<script src="../public/js/bootstrap.min.js"></script>

<!-- JS Implementing Plugins -->
<script src="../public/js/back-to-top.js"></script>
<script src="../public/js/smoothScroll.js"></script>
<script src="../public/js/jquery.cubeportfolio.min.js"></script>


<!-- JS Customization -->
<script src="../public/js/custom.js"></script>

<!-- JS Page Level -->
<script src="../public/js/app.js"></script>
<script src="../public/js/cube-portfolio-4-fw-ns.js"></script>

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