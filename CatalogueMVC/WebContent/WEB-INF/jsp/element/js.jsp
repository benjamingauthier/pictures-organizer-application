<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
<!-- JS Global Compulsory -->
<script src="${pageContext.request.contextPath}/public/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/public/js/jquery-migrate.min.js"></script>
<script src="${pageContext.request.contextPath}/public/js/bootstrap.min.js"></script>

<!-- JS Implementing Plugins -->
<script src="${pageContext.request.contextPath}/public/js/back-to-top.js"></script>
<script src="${pageContext.request.contextPath}/public/js/smoothScroll.js"></script>
<script src="${pageContext.request.contextPath}/public/js/jquery.cubeportfolio.min.js"></script>


<!-- JS Customization -->
<script src="${pageContext.request.contextPath}/public/js/custom.js"></script>

<!-- JS Page Level -->
<script src="${pageContext.request.contextPath}/public/js/app.js"></script>


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