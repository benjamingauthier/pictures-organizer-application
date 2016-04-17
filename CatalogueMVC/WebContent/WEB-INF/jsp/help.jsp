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
	            <p>Description du projet</p>
	        </div><!--/end container-->
	    </div>
	    <!--=== End Breadcrumbs v3 ===-->

	    <hr class="margin-bottom-60">

	    <!--=== Team v6 ===-->
	    <div class="container">
	        <div class="headline-center margin-bottom-60">
	            <h1>Cahier des charges</h1><br>
				<h2>Fonctionnalités de base :</h2>
					<li>Visualisation des photos (contextualisée ou non)</li>
					<li>Ajout de Photo</li>
					<li>Suppression de Photo</li>
				<h2>Fonctionnalités supplémentaires :</h2>
					<li>Visualisation des catalogues non contextualisé </li>
					<li>Ajout catalogue</li>
					<li>Suppression catalogues</li>
					<li>WebService</li>
					<li>Modification photo</li>
					<li>Modification catalogue</li>
					<li>Gestion des utilisateurs</li>
					<li>Gestion des commentaires</li>
					<br><br><br>
				<h1>Réalisé</h1><br>
				<h2>Fonctionnalités de base :</h2>
					<li>Visualisation des photos (contextualisée ou non) ✔</li>
					<li>Ajout de Photo ✔</li>
					<li>Suppression de Photo ✔</li>
				<h2>Fonctionnalités supplémentaires :</h2>
					<li>Visualisation des catalogues non contextualisé ✔</li>
					<li>Ajout catalogue ✔</li>
					<li>Suppression catalogues ✔</li>
					<li>WebService ✔</li>
					<li>Modification photo</li>
					<li>Modification catalogue</li>
					<li>Gestion des utilisateurs</li>
					<li>Gestion des commentaires</li>
				
				<br><br><br>
				
				<h1>Nos choix techniques :</h1><br>
				
				<h2>Architecture IOC</h2>
				<p><strong>Bean</strong> : le bean représente notre modèle. On y retrouve tous ses attributs ainsi que l’ensemble de ses accesseurs et mutateurs.</p>
				<p><strong>DAO</strong> : le DAO est la couche en relation directe avec la data. On y retrouve toutes les méthodes d’interactions avec cette dernière. La force de cette architecture est le fait qu’elle nous permet d’avoir que très peu de modification dans le projet, lors d’un changement de technologies de stockage de cette dernière. Un passage de XML à SQL par exemple.</p>
				<p><strong>Service</strong> : le service est l’interface de notre manager.</p>
				<p><strong>Manager</strong> : le manager joue un rôle essentiel dans notre architecture. Pour toutes les méthodes d’interaction avec les objets, il est chargé de mettre à jour, à la fois la couche applicative (dans le bean), mais aussi la couche data (dans le DAO).</p>
				<p><strong>Controller</strong> : le controller est en relation directe avec le client. Son rôle est de faire le lien entre la vue et la data. A travers le protocole GET il renvoie la donnée nécessaire, et inversement, à travers le protocole POST, il enregistre la data fournie par la vue.</p>
	        </div>
	        
	        
	
		</div>
	    <!--=== End Call To Action v2 ===-->

		<jsp:include page="/WEB-INF/jsp/element/footer.jsp" />
	</div>
<jsp:include page="/WEB-INF/jsp/element/js.jsp" />
</body>
</html>