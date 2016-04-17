package catalogue.controller;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import catalogue.dao.DAOFactory;
import catalogue.manager.impl.BibliothequeManagerImpl;

@Controller
@RequestMapping("/home")

public class HomeController extends AbstractController implements ServletContextAware {

	/*
	 * INJECTION Spring d'un bean Service dans le controleur. Le bean Service
	 * est configure dans objisapp-service.xml
	 */
	

	private BibliothequeManagerImpl bibliothequeManagerImpl;

	public HomeController() {

		//System.out.println(this.getServletContext().getRealPath(("/WEB-INF/data/catalogue.xml")));
	//	System.out.println(context.getRealPath("/WEB-INF/data/catalogue.xml"));
		this.bibliothequeManagerImpl = new BibliothequeManagerImpl(DAOFactory.XML);
	}
	
	
	

	public void setCatalogueManagerImpl(BibliothequeManagerImpl bibliothequeManagerImpl) {

		this.bibliothequeManagerImpl = bibliothequeManagerImpl;

	}

	
	@RequestMapping(value = "/view/{id}",  method=RequestMethod.GET)
	public ModelAndView viewCatalogue(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse arg1) 
			throws Exception {
			  Bibliotheque b = bibliothequeManagerImpl.creerBibliotheque(getPath(request, arg1));
			  Integer catalogueId = Integer.parseInt(id);
			  Catalogue c = b.getListCatalogue().get(catalogueId);
			  
			  if (c == null) {
				  ModelAndView modelAndView = new ModelAndView("error_404");
				  return modelAndView;
			  } else
			  {
				  ModelAndView modelAndView = new ModelAndView("catalogue");
				  modelAndView.addObject("titre", c.getTitre());
				  modelAndView.addObject("photos", c.getListPhoto());
				  return modelAndView;
			  }
	}
	public String getPath(HttpServletRequest request, HttpServletResponse arg1) 
			throws Exception {
		HttpSession session = request.getSession();
		ServletContext sc = session.getServletContext();
		return sc.getRealPath("/WEB-INF/data/catalogue.xml");
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse arg1)
			throws Exception {

		HttpSession session = request.getSession();
		ServletContext sc = session.getServletContext();
		String x = sc.getRealPath("/WEB-INF/data/catalogue.xml");
		
		
			
		
		// HashMap<Integer, Photo> listPhoto =
		// catalogueManagerImpl.getListPhoto();

		/*
		 * Catalogue cat = catalogueManagerImpl.creerCatalogue(); String Mess =
		 * "Abstract Controller Test"; ModelAndView modelAndView = new
		 * ModelAndView("home"); modelAndView.addObject("message", Mess);
		 * modelAndView.addObject("listPhoto", cat.getListPhoto());
		 * modelAndView.addObject("imagePath",
		 * getServletContext().getInitParameter("imagePath"));
		 * 
		 * 
		 * 
		 * catalogueManagerImpl.supprimerPhoto(cat, cat.getListPhoto().get(1));
		 */

		Bibliotheque b = bibliothequeManagerImpl.creerBibliotheque(x);
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("catalogue", b.getListCatalogue());
		

		return modelAndView;
	}

	
	@RequestMapping(value = "/list/", method = RequestMethod.GET)
	@ResponseBody
	public Bibliotheque list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		ServletContext sc = session.getServletContext();
		String x = sc.getRealPath("/WEB-INF/data/catalogue.xml");
		System.out.println(x);

		Bibliotheque b = bibliothequeManagerImpl.creerBibliotheque(x);
		return b;

	}

}
