package catalogue.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import catalogue.bean.Photo;
import catalogue.dao.DAOFactory;
import catalogue.manager.impl.CatalogueManagerImpl;



public class HomeController extends AbstractController{

	/*
	 * INJECTION Spring d'un bean Service dans le controleur. 
	 * Le bean Service est configure dans objisapp-service.xml
	 */

	
	private CatalogueManagerImpl catalogueManagerImpl;
	
	public HomeController(){
		this.catalogueManagerImpl=new CatalogueManagerImpl(DAOFactory.XML);
	}
	
	
	public void setCatalogueManagerImpl(CatalogueManagerImpl catalogueManagerImpl){
		
		this.catalogueManagerImpl=catalogueManagerImpl;
		
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		// HashMap<Integer, Photo> listPhoto = catalogueManagerImpl.getListPhoto();
		
		 catalogueManagerImpl.creerCatalogue();
		 String Mess = "Abstract Controller Test"; 
		  ModelAndView modelAndView = new ModelAndView("home");
		  modelAndView.addObject("message", Mess); 
		  
		 return  modelAndView;
	}

}
