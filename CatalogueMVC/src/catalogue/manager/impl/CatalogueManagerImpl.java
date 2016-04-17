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
	public HashMap<Integer, Photo> getListPhoto() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void ajouterPhoto(String fileUrl, Catalogue cat, Photo ph) {
		getDOAFactory().getCatalogueDAO().addPhoto(fileUrl, ph, cat);
		cat.ajouterPhoto(ph);

	}

	@Override
	public void supprimerPhoto(String fileUrl, Catalogue cat, Photo ph) throws Exception {
		getDOAFactory().getCatalogueDAO().deletePhoto(fileUrl, cat, ph);
		cat.supprimerPhoto(ph);
	}
	
	@Override
	public int countPhotos() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int getMaxId(HashMap<Integer, Photo> photos) {
		if(photos.isEmpty())
			return 1;
		HashMap.Entry<Integer, Photo> maxEntry = null;
		
		for (HashMap.Entry<Integer, Photo> entry : photos.entrySet())
		{
		    if (maxEntry == null || entry.getValue().getId() .compareTo(maxEntry.getValue().getId()) > 0)
		    {
		        maxEntry = entry;
		    }
		}
		
		return maxEntry.getKey();
	}
}
