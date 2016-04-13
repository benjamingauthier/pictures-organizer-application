package catalogue.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import catalogue.bean.Photo;
import catalogue.bean.Catalogue;
import catalogue.bean.Bibliotheque;
import catalogue.dao.DAOFactory;
import catalogue.manager.impl.BibliothequeManagerImpl;



public class HomeController extends AbstractController{

	/*
	 * INJECTION Spring d'un bean Service dans le controleur. 
	 * Le bean Service est configure dans objisapp-service.xml
	 */

	
	private BibliothequeManagerImpl bibliothequeManagerImpl;
	
	public HomeController(){
		this.bibliothequeManagerImpl=new BibliothequeManagerImpl(DAOFactory.XML);
	}
	
	
	public void setCatalogueManagerImpl(BibliothequeManagerImpl bibliothequeManagerImpl){
		
		this.bibliothequeManagerImpl=bibliothequeManagerImpl;
		
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		// HashMap<Integer, Photo> listPhoto = catalogueManagerImpl.getListPhoto();
		
		 /*Catalogue cat = catalogueManagerImpl.creerCatalogue();
		 String Mess = "Abstract Controller Test"; 
		  ModelAndView modelAndView = new ModelAndView("home");
		  modelAndView.addObject("message", Mess); 
		  modelAndView.addObject("listPhoto", cat.getListPhoto());
		  modelAndView.addObject("imagePath", getServletContext().getInitParameter("imagePath"));
		  

		  
		  	catalogueManagerImpl.supprimerPhoto(cat, cat.getListPhoto().get(1));*/
		
		  Bibliotheque b = bibliothequeManagerImpl.creerBibliotheque();
		  String Mess = "Abstract Controller Test"; 
		  ModelAndView modelAndView = new ModelAndView("home");
		  modelAndView.addObject("b", b.getListCatalogue()); 
		
		  
		 return  modelAndView;
	}

}
