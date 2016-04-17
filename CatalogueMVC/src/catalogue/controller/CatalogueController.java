package catalogue.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import catalogue.bean.Bibliotheque;
import catalogue.bean.Catalogue;
import catalogue.bean.Photo;
import catalogue.dao.DAOFactory;
import catalogue.manager.impl.BibliothequeManagerImpl;
import catalogue.manager.impl.CatalogueManagerImpl;

@Controller
@RequestMapping("/catalogue")
@MultipartConfig
public class CatalogueController extends AbstractController implements ServletContextAware {

	/*
	 * INJECTION Spring d'un bean Service dans le controleur. 
	 */
	

	private BibliothequeManagerImpl bibliothequeManagerImpl;
	private CatalogueManagerImpl catalogueManagerImpl;

	public CatalogueController() {

		this.bibliothequeManagerImpl = new BibliothequeManagerImpl(DAOFactory.XML);
		this.catalogueManagerImpl = new CatalogueManagerImpl(DAOFactory.XML);
	}
	
	

	public void setCatalogueManagerImpl(CatalogueManagerImpl catalogueManagerImpl) {

		this.catalogueManagerImpl = catalogueManagerImpl;
	}
	
	public void setBibilothequeManagerImpl(BibliothequeManagerImpl bibliothequeManagerImpl) {

		this.bibliothequeManagerImpl = bibliothequeManagerImpl;
	}
	
	public String getPath(HttpServletRequest request, HttpServletResponse arg1) 
			throws Exception {
		HttpSession session = request.getSession();
		ServletContext sc = session.getServletContext();
		return sc.getRealPath("/WEB-INF/data/catalogue.xml");
	}
	
	@RequestMapping(value = "/view/{id}",  method=RequestMethod.GET)
	public ModelAndView view(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse arg1) 
			throws Exception {
			  Bibliotheque b = bibliothequeManagerImpl.creerBibliotheque(getPath(request, arg1));
			  System.out.println("Test "+id);
			  Integer catalogueId = Integer.parseInt(id);
			  Catalogue c = b.getListCatalogue().get(catalogueId);
			  
			  if (c == null) {
				  ModelAndView modelAndView = new ModelAndView("error_404");
				  return modelAndView;
			  } else
			  {
				  ModelAndView modelAndView = new ModelAndView("catalogueView");
				  modelAndView.addObject("titre", c.getTitre());
				  modelAndView.addObject("photos", c.getListPhoto());
				  modelAndView.addObject("catalogueId", c.getId());
				  return modelAndView;
			  }
	}
	
	@RequestMapping(value = "/team",  method=RequestMethod.GET)
	public ModelAndView viewTeam(HttpServletRequest request, HttpServletResponse arg1) 
			throws Exception {
			 
				  ModelAndView modelAndView = new ModelAndView("team");
				  return modelAndView;
			  
	}
	@RequestMapping(value = "/help",  method=RequestMethod.GET)
	public ModelAndView help(HttpServletRequest request, HttpServletResponse arg1) 
			throws Exception {
			 
				  ModelAndView modelAndView = new ModelAndView("help");
				  return modelAndView;
			  
	}
	
	@RequestMapping(value = "/",  method=RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpServletResponse arg1)
			throws Exception {
	
		Bibliotheque b = bibliothequeManagerImpl.creerBibliotheque(getPath(request, arg1));
		ModelAndView modelAndView = new ModelAndView("catalogueIndex");
		String[] src = new String[b.getListCatalogue().size()];
		String source = "";
		Integer i = 0;
		Integer j = 0;
		for(Integer idCatalogue:b.getListCatalogue().keySet()) {
			j = 0;
			Catalogue c = b.getListCatalogue().get(idCatalogue);
			if (c.getListPhoto().isEmpty()) {
				source = "images/no_image_available.jpeg";
			}
			else
			{
				for(Integer idPicture: c.getListPhoto().keySet())
				{
					if (j == 0) {
				    source = c.getListPhoto().get(idPicture).getSource();
				    j++;
				    break;
					}
				   //
				 }
			}
			src[i] = source;
			i++;			
		}
						  
		modelAndView.addObject("catalogues", b.getListCatalogue());
		modelAndView.addObject("sources", src);
		return modelAndView;
	}
	
	@RequestMapping(value = "/add",  method=RequestMethod.POST)
	public ModelAndView addCatalogue(HttpServletRequest request, HttpServletResponse arg1)
			throws Exception { 
			Catalogue c = new Catalogue(request.getParameter("titre"));
			Bibliotheque b = bibliothequeManagerImpl.creerBibliotheque(getPath(request, arg1));
			c.setId(bibliothequeManagerImpl.getMaxId(b.getListCatalogue())+1);
			bibliothequeManagerImpl.ajouterCatalogue(getPath(request, arg1), c, b);
		return new ModelAndView("redirect:/catalogue/");
	}
	
	@RequestMapping(value = "/delete/{id}",  method=RequestMethod.GET)
	public ModelAndView deleteCatalogue(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse arg1)
			throws Exception { 
			Bibliotheque b = bibliothequeManagerImpl.creerBibliotheque(getPath(request, arg1));
			Integer catalogueId = Integer.parseInt(id);
			bibliothequeManagerImpl.supprimerCatalogue(getPath(request, arg1), b.getListCatalogue().get(catalogueId), b);
		return new ModelAndView("redirect:/catalogue/");
	}
	
	@RequestMapping(value = "/add/{idCat}/photo/{titrePhoto}/extention/{extention}",  method=RequestMethod.GET)
	public ModelAndView addCatalogue(@PathVariable("idCat") String idCat, @PathVariable("titrePhoto") String titrePhoto, @PathVariable("extention") String extention, HttpServletRequest request, HttpServletResponse arg1)
			throws Exception { 
			Integer catalogueId = Integer.parseInt(idCat);
			Bibliotheque b = bibliothequeManagerImpl.creerBibliotheque(getPath(request, arg1));
			Photo p = new Photo("images/"+titrePhoto+"."+extention, extention, titrePhoto);
			p.setId(catalogueManagerImpl.getMaxId(b.getListCatalogue().get(catalogueId).getListPhoto())+1);
			catalogueManagerImpl.ajouterPhoto(getPath(request, arg1), b.getListCatalogue().get(catalogueId), p);
		return new ModelAndView("redirect:/catalogue/view/"+catalogueId);
	}
	
	@RequestMapping(value = "/delete/{idCat}/photo/{idPh}",  method=RequestMethod.GET)
	public ModelAndView deleteCatalogue(@PathVariable("idCat") String idCat, @PathVariable("idPh") String idPh, HttpServletRequest request, HttpServletResponse arg1)
			throws Exception { 
			Bibliotheque b = bibliothequeManagerImpl.creerBibliotheque(getPath(request, arg1));
			Integer catalogueId = Integer.parseInt(idCat);
			Integer photoId = Integer.parseInt(idPh);
			catalogueManagerImpl.supprimerPhoto(getPath(request, arg1), b.getListCatalogue().get(catalogueId), (b.getListCatalogue().get(catalogueId)).getListPhoto().get(photoId));
		return new ModelAndView("redirect:/catalogue/view/"+catalogueId);
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse arg1)
			throws Exception {

		HttpSession session = request.getSession();
		ServletContext sc = session.getServletContext();
		String x = sc.getRealPath("/WEB-INF/data/catalogue.xml");
		

		Bibliotheque b = bibliothequeManagerImpl.creerBibliotheque(x);
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("catalogue", b.getListCatalogue());
		

		return modelAndView;
	}

}