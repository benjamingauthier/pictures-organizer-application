package catalogue.manager.impl;

import java.util.HashMap;


import org.springframework.stereotype.Component;

import catalogue.bean.Photo;
import catalogue.bean.Catalogue;
import catalogue.dao.DAOFactory;
import catalogue.dao.XmlDAOFactory;
import catalogue.service.CatalogueManager;


@Component  
public class CatalogueManagerImpl implements CatalogueManager {

	// private PersonneDao personneDao;

	private int mode = -1;

	public CatalogueManagerImpl(int mode) {
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
	public Catalogue creerCatalogue() throws Exception {
		return getDOAFactory().getCatalogueDAO().createCatalogue();
	}
	
	
	@Override
	public HashMap<Integer, Photo> getListPhoto() {
		// TODO Auto-generated method stub
		
		return null;
	}


	@Override
	public void modifierCatalogue() {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerCatalogue() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ajouterPhoto(Photo ph) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerPhoto(String fileUrl, Catalogue cat, Photo ph) throws Exception {
		getDOAFactory().getCatalogueDAO().deletePhoto(fileUrl, cat, ph);
		cat.supprimerPhoto(ph);
	}

	@Override
	public void modifierPhoto(Photo ph) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public int countCatalogues() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countPhotos() {
		// TODO Auto-generated method stub
		return 0;
	}

}
