<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
<xsl:output 
        method="html"
        encoding="UTF-8"
        doctype-public="-//W3C//DTD HTML 4.01//EN"
        doctype-system="http://www.w3.org/TR/html4/strict.dtd"
        indent="yes" />
        
         <xsl:template match="/">
        <html>
			<head>
				<title>Catalogue photo</title>
				<style type="text/css">
					#thumbs {
	list-style: none outside none; /* On supprime le style de la liste par défaut */
	margin: 0 auto; /* La galerie est centrée horizontalement */
	padding: 0;
	width: 480px;
}
 
#thumbs li {
	float: left;
	height: 112px;
	margin: 0;
	padding: 5px;
	position: relative;
	width: 150px;
	z-index: 10;
	text-align: center; /* align the image to center */
    background-color:#282828 ; /* background color of each */
    font-family: "Trebuchet MS", Helvetica, sans-serif; 
    /*border-radius: 10px; /* rounded borders effect */
  /*  border: 2px solid #585858; /* border and color */
}
 
#thumbs li:hover {
	z-index: 100; /* Nécessaire pour Firefox */
/*	height: 400px;
	width:400px;*/
}
 
#thumbs li img {
	border: 5px solid #fff;
	z-index: 100;
	transition: transform 0.25s ease-in-out;
	-moz-transition: -moz-transform 0.25s ease-in-out;
	-o-transition: -o-transform 0.25s ease-in-out;
	-webkit-transition: -webkit-transform 0.25s ease-in-out;
	transform: scale(0.75); /* On réduit l'image à 75% */
	-moz-transform: scale(0.75);
	-o-transform: scale(0.75);
	-webkit-transform: scale(0.75);
}

#thumbs:hover li img {
	opacity: 0.5; /* Au survol de la galerie, toute les images auront une opacité de 50% */
}
 
#thumbs li:hover img {
	opacity: 1; /* L'image survolée aura une opacité de 100% */
	z-index: 100;
	transform: scale(1); /* On affiche l'image à sa taille normale */
	-moz-transform: scale(1);
	-o-transform: scale(1);
	-webkit-transform: scale(1);
	box-shadow: 1px 1px 10px #000; /* On ajoute une ombre */
	-moz-box-shadow: 1px 1px 10px #000;
	-o-box-shadow: 1px 1px 10px #000;
	-webkit-box-shadow: 1px 1px 10px #000;
}
				</style>
			</head>
			<body bgcolor="#181818">
				<ul id="thumbs">	
					
					<xsl:for-each select="catalogue/photo">
						<li>
							<img alt="{titre}" style="width:100%">
								<xsl:attribute name="src">
									<xsl:value-of select="@src"/>
							   </xsl:attribute>
							 
							</img>
							<a href="#" style="color:white">    
								<!--<h4><xsl:value-of select="titre"></xsl:value-of></h4>
								<p><xsl:value-of select="commentaire"></xsl:value-of></p>-->
							</a>
						</li>
					</xsl:for-each>
					<li>
							<img alt="{titre}" style="width:100%" src="images/autowp.ru_lamborghini_diablo_47.jpg"/>
								
							 
							<a href="#" style="color:white">    
								<!--<h4><xsl:value-of select="titre"></xsl:value-of></h4>
								<p><xsl:value-of select="commentaire"></xsl:value-of></p>-->
							</a>
						</li>
				</ul>
				<ul id="thumbs">
					<xsl:for-each select="catalogue/photo[4]">
						<li>
							<img alt="{titre}" style="width:100%">
								<xsl:attribute name="src">
									<xsl:value-of select="@src"/>
							   </xsl:attribute>
							 
							</img>
							<a href="#" style="color:white">    
								4eme element 
								<!--<h4><xsl:value-of select="titre"></xsl:value-of></h4>
								<p><xsl:value-of select="commentaire"></xsl:value-of></p>-->
							</a>
						</li>
					</xsl:for-each>						
				</ul>
				<ul id="thumbs">
					<xsl:for-each select="catalogue/photo[contains(commentaire,'_3')]">
						<li>
							<img alt="{titre}" style="width:100%">
								<xsl:attribute name="src">
									<xsl:value-of select="@src"/>
							   </xsl:attribute>
							 
							</img>
							<a href="#" style="color:white">    
								image trouvée avec commentaire _3
							
							</a>
						</li>
					</xsl:for-each>						
				</ul>
			</body>
	</html>			
    </xsl:template>
   
</xsl:stylesheet>
