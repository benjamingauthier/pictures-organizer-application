package catalogue.manager.impl;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import catalogue.bean.Bibliotheque;
import catalogue.bean.Catalogue;
import catalogue.dao.DAOFactory;
import catalogue.dao.XmlDAOFactory;
import catalogue.service.BibliothequeManager;


@Component  
public class BibliothequeManagerImpl implements BibliothequeManager {

	// private PersonneDao personneDao;

	private int mode = -1;

	public BibliothequeManagerImpl(int mode) {
		// TODO Auto-generated constructor stub

		this.mode = mode;
	}

	private DAOFactory getDOAFactory() {

		if (mode == DAOFactory.XML)

			return XmlDAOFactory.getInstance();
		else
			return null;
	}

	@Override
	public Bibliotheque creerBibliotheque() throws Exception {
		return getDOAFactory().getBibliothequeDAO().createBibliotheque();
	}
	
	
	@Override
	public HashMap<Integer, Catalogue> getListCatalogue() {
		// TODO Auto-generated method stub
		
		return null;
	}


	@Override
	public void ajouterCatalogue(Catalogue c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerCatalogue(Catalogue c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifierCatalogue(Catalogue c) {
		// TODO Auto-generated method stub

	}


}