package catalogue.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import catalogue.bean.Bibliotheque;
import catalogue.dao.DAOFactory;
import catalogue.manager.impl.BibliothequeManagerImpl;

@Controller
@RequestMapping("/rest")

public class RestController {
	
	
	
	private BibliothequeManagerImpl bibliothequeManagerImpl;

	public RestController() {

		
		this.bibliothequeManagerImpl = new BibliothequeManagerImpl(DAOFactory.XML);
	}
	

	public String getPath(HttpServletRequest request, HttpServletResponse arg1) 
			throws Exception {
		HttpSession session = request.getSession();
		ServletContext sc = session.getServletContext();
		return sc.getRealPath("/WEB-INF/data/catalogue.xml");
	}
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Bibliotheque list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String x = getPath(request, response);
		System.out.println(x);
		response.setHeader("Access-Control-Allow-Origin", "*");

		Bibliotheque b = bibliothequeManagerImpl.creerBibliotheque(x);
		return b;

	}


}
