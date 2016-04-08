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
	private static final String XML_FILE_NAME = "catalogue.xml";
	private CatalogueXMLConverter converter ;

	public XmlCatalogueDAO(DAOFactory daoFactory) {
System.out.println("create catalogue");
	//	this.xmlFile = new File("F:\\mes cours\\MIAGE\\XML\\TD_Projet\\catalogue.xml");
		this.daoFactory = daoFactory;
		converter = new CatalogueXMLConverter(XML_FILE_NAME);
	}

	@Override
	public Catalogue createCatalogue() throws Exception {
		// TODO Auto-generated method stub
		return converter.xmlToObject();
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
