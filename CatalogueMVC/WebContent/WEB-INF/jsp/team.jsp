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

    <jsp:include page="/WEB-INF/jsp/element/css.jsp" />
    
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
	                <img class="img-responsive" src="${pageContext.request.contextPath}/public/images/team/amine.jpg" alt="amine">
	                <span>Amine</span>
	            </div>
	            <div class="col-md-3 col-sm-6 md-margin-bottom-50">
	                <img class="img-responsive" src="${pageContext.request.contextPath}/public/images/team/ben.jpg" alt="ben">
	                <span>Benjamin</span>
	            </div>
	            <div class="col-md-3 col-sm-6 sm-margin-bottom-50">
	                <img class="img-responsive" src="${pageContext.request.contextPath}/public/images/team/aud.jpg" alt="audrey">
	                <span>Audrey</span>
	            </div>
	            <div class="col-md-3 col-sm-6">
	                <img class="img-responsive" src="${pageContext.request.contextPath}/public/images/team/rhita.jpg" alt="rihta">
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
<jsp:include page="/WEB-INF/jsp/element/js.jsp" />
</body>
</html>