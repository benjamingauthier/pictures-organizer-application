/**
 * 
 */

var _ListCatalogue = [];

var _Url = 'http://localhost:9080';

function getList(){

		$.ajax({
			url : _Url+'/CatalogueMVC/rest/list',
			dataType : "json",
			type : "GET",
			 crossDomain: true,
			
			success : function(result) {
				buildCatalogue(result);
			},

			error : function(jqXHR, textStatus, errorThrown) {
				alert(" status "+jqXHR.status+" error thrown "+textStatus);
				return false;

			},

		});

	}



$(document).ready(function(){
	var url = prompt("Please enter your host name,par exemple:", 'http://localhost:9080');

if (url != null) {
 
   _Url=url;
   
   getList(); 
}
else{
return false;
}
	
	
});


function buildCatalogueMenue(catalogueItem){
	var _listItem = '';
	 
	  for (var prop in catalogueItem) {
		  
		  _listItem = _listItem+'<li><a onclick="buildGaleryCatalogue('+prop+')">'+ catalogueItem[prop].titre+'</a></li>' ;
	  }
	  
	  
	  $("#catalogueItem").html(  _listItem );

}

function buildCatalogue(listCatalogue){
	
	var img = '';
	for (var key in listCatalogue) {
		   var catalogueItem =listCatalogue[key];
		   for (var prop in catalogueItem) {
		    
		      _ListCatalogue.push(catalogueItem[prop]);
		      
		}
	}	   
		   buildCatalogueMenue(_ListCatalogue);
		   loadCarsoulItem(_ListCatalogue);

}


function loadCarsoulItem(carsoulItem){
	
	_listItem='';
	
	var _active = 'active';
	
	 for (var prop in carsoulItem) {
		  
		 var listPhoto= carsoulItem[prop].listPhoto;
		 for (var photo in listPhoto) {
		 
		 	var img=_Url+"/CatalogueMVC/public/data/"+listPhoto[photo].source;
		 	var titre =listPhoto[photo].titre;
		  _listItem =  _listItem+ '<div class="item '+_active+'">'+
		  
		 
          '<img alt="" src="'+img+'">'+
          		'<div class="carousel-caption">'+
          			titre
          		+'</div> </div>' ;
		  
		  _active = ' ';
		  
		 }
	  }
	 
	 $("#carsoulItemInner").html(_listItem);
}


function buildGaleryCatalogue(id){
	
	var _htmlListPhoto = '';
	var _ListPhoto = _ListCatalogue[id].listPhoto;
	var _ContainerItem = '<div class="row  margin-bottom-30">';
	var html = '';
	
	var compteur = 0;
	var index = 0;
	
	var size = Object.size(_ListCatalogue[id].listPhoto);
	
	 $("#catalogue_title").html( _ListCatalogue[id].titre);
	 
	for (var item in _ListPhoto ) {
	 	 var img=_Url+"/CatalogueMVC/public/data/"+_ListPhoto[item].source;
	 	 var title = '';
		 
		 var galery ="gallery"+index;
	 	
	     _htmlListPhoto =_htmlListPhoto+'<div class="col-sm-3 sm-margin-bottom-30">'
		 	+'<a href='+img+' rel='+galery+' class="fancybox img-hover-v1" title='+title+'>'
	 	    	+'<span><img class="img-responsive" src='+img+'  alt=""></span>'
			+'</a></div>';
	 	
	     compteur++;
		 
	 	if(compteur==4 || compteur ==size){
	 		html =html+ _ContainerItem +_htmlListPhoto+'</div>';
	 		_htmlListPhoto  = '';
	 		compteur=0;
	 	}
	 	

	 	 $("#galeryContainer").css("display","block");
	 	 $("#photoContainer").html( html);
	 	
	 	
	}
	
}


function hideBlock(){
	 $("#galeryContainer").css("display","none");
}


Object.size = function(obj) {
    var size = 0, key;
    for (key in obj) {
        if (obj.hasOwnProperty(key)) size++;
    }
    return size;
};





