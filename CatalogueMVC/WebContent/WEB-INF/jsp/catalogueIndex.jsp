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
	
    <jsp:include page="/WEB-INF/jsp/element/css.jsp" />
    
<title>Les Cat'Logs</title>
</head>
<body class="header-fixed">
	<div class="wrapper">
		<jsp:include page="/WEB-INF/jsp/element/header.jsp" />
		<!--=== Breadcrumbs v3 ===-->
	    <div class="breadcrumbs-v3 img-v1">
	        <div class="container text-center">
	            <p>CATALOGUES</p><br>
	            <button type="button" class="back-green btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
		  				Ajouter<i style="padding-left: 10px;" class="fa fa-plus" aria-hidden="true"></i>
					</button>
	        </div><!--/end container-->
	    </div>
	    <!--=== End Breadcrumbs v3 ===-->

	    <!--=== Cube-Portfdlio ===-->
	    <div class="cube-portfolio container margin-bottom-60">
	    	<div class="content-xs">
	            <div id="filters-container" class="cbp-l-filters-text content-xs">

	            </div><!--/end Filters Container-->
        	</div>
	        <div id="grid-container" class="cbp-l-grid-agency">
	        	<c:forEach var="catalogue" items="${catalogues}"  varStatus="loop">
			            <div class="cbp-item identity">
			                <div class="cbp-caption margin-bottom-20">
			                    <div class="cbp-caption-defaultWrap">
			                        <img src="${pageContext.request.contextPath}/public/${sources[loop.index]}" alt="${catalogue.value.getTitre()}">
			                    </div>
			                    <div class="cbp-caption-activeWrap">
			                        <div class="cbp-l-caption-alignCenter">
			                            <div class="cbp-l-caption-body">
			                                <ul class="link-captions no-bottom-space">
			                                	<li><a href="#" data-href="delete/${catalogue.value.getId()}" data-toggle="modal" data-target="#confirm-delete"><i class="back-rouge red rounded-x fa fa-minus" aria-hidden="true"></i></a></li>
			                                    <li><a href="view/${catalogue.value.getId()}"><i class="back-green rounded-x fa fa-search"></i></a></li>
			                                </ul>
			                            </div>
			                        </div>
			                    </div>
			                </div>
			                <div class="cbp-title-dark">
			                    <div class="cbp-l-grid-agency-title"><a href="view/${catalogue.value.getId()}"><c:out value="${catalogue.value.getTitre()}"/></a></div>
			                </div>
			            </div>
	            </c:forEach>
	        </div><!--/end Grid Container-->
	    </div>
	    <!--=== End Cube-Portfdlio ===-->
	     
		<!--=== Start Modal ===-->	    
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title">Ajouter un catalogue</h4>
		      </div>
		      <div class="modal-body">
		        <form method="POST" action="add">
		        	<div class="form-group">
					  <label for="comment">Titre :</label>
					  <input class="form-control" id="titre" name="titre"></input>
					</div>
					<button type="submit"class="back-green btn btn-primary">Ajouter</button>
		        </form>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		<!--=== End Modal ===-->
		
		<!--=== start confirm Modal ===-->
		<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                Confirmation
		            </div>
		            <div class="modal-body">
		                Etes-vous sûr de vouloir supprimer ce catalogue ?
		            </div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
		                <a class="btn btn-danger btn-ok">Oui</a>
		            </div>
		        </div>
		    </div>
		</div>
		<!--=== start confirm Modal ===-->

	

		<jsp:include page="/WEB-INF/jsp/element/footer.jsp" />
	</div>
	<jsp:include page="/WEB-INF/jsp/element/js.jsp" />
	<script src="${pageContext.request.contextPath}/public/js/cube-portfolio-3.js"></script>
	
	<script>
	$('#confirm-delete').on('show.bs.modal', function(e) {
   	 $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
	});
    </script>
</body>
</html>