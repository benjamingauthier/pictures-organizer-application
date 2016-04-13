package catalogue.dao;

import java.io.File;

import catalogue.bean.Catalogue;
import catalogue.bean.Bibliotheque;

/**
 * @author AMINE 
 * XmlCatalogueDAO implementation of the CatalogueDAO interface.
 * This class can contain all xml file operation.
 *
 */

public class XmlBibliothequeDAO implements BibliothequeDAO {

	private File xmlFile = null;
	private DAOFactory daoFactory = null;
	private static final String XML_FILE_NAME = "catalogue.xml";
	private BibliothequeXMLConverter converter ;

	public XmlBibliothequeDAO(DAOFactory daoFactory) {
		System.out.println("create bliblio");
		//this.xmlFile = new File("F:\\mes cours\\MIAGE\\XML\\TD_Projet\\catalogue.xml");
		this.daoFactory = daoFactory;
		converter = new BibliothequeXMLConverter(XML_FILE_NAME);
	}

	@Override
	public Bibliotheque createBibliotheque() throws Exception {
		// TODO Auto-generated method stub
		return converter.xmlToObject();
	}

	@Override
	public void addCatalogue(Catalogue c) {
		// TODO Auto-generated method stub
		
	}


	/*@Override
	public void addPhoto(Photo p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePhoto(Photo p) {
		// TODO Auto-generated method stub

	}

	@Override
	public Catalogue getPhoto(int Id) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
