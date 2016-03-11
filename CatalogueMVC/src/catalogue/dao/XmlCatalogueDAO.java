package catalogue.dao;

import java.io.File;

import catalogue.bean.Catalogue;
import catalogue.bean.Photo;

/**
 * @author AMINE 
 * XmlCatalogueDAO implementation of the CatalogueDAO interface.
 * This class can contain all xml file operation.
 *
 */
public class XmlCatalogueDAO implements CatalogueDAO {

	private File xmlFile = null;
	private DAOFactory daoFactory = null;

	public XmlCatalogueDAO(DAOFactory daoFactory) {

		this.xmlFile = new File("F:\\mes cours\\MIAGE\\XML\\TD_Projet\\catalogue.xml");
		this.daoFactory = daoFactory;

	}

	@Override
	public Catalogue createCatalogue() {
		// TODO Auto-generated method stub
		if (xmlFile.exists()) {

		}
		return null;
	}

	@Override
	public void deleteCatalogue(int Id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCatalogue() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPhoto(Photo p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePhoto(Photo p) {
		// TODO Auto-generated method stub

	}

	@Override
	public Photo getPhoto(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
