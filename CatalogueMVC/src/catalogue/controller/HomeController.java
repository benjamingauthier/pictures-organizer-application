package catalogue.controller;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import catalogue.bean.Bibliotheque;
import catalogue.dao.DAOFactory;
import catalogue.manager.impl.BibliothequeManagerImpl;

@Controller
@RequestMapping("/catalogue")

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

	private String getRealPath(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		ServletContext sc = session.getServletContext();
		String x = sc.getRealPath("/WEB-INF/data/catalogue.xml");
		return x;
	}

	@Override
	@RequestMapping("/")
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse arg1)
			throws Exception {

		HttpSession session = request.getSession();
		ServletContext sc = session.getServletContext();
		String x = sc.getRealPath("/WEB-INF/data/catalogue.xml");
		System.out.println(x);
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

	@RequestMapping(value = "/list", method = RequestMethod.GET)
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
