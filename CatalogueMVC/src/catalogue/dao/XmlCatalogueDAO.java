package catalogue.dao;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

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
	private BibliothequeXMLConverter converter ;

	public XmlCatalogueDAO(DAOFactory daoFactory) {
		//System.out.println("create catalogue");
		//this.xmlFile = new File("F:\\mes cours\\MIAGE\\XML\\TD_Projet\\catalogue.xml");
		this.daoFactory = daoFactory;
		converter = new BibliothequeXMLConverter(XML_FILE_NAME);
	}

	@Override
	public Catalogue createCatalogue() throws Exception {
		// TODO Auto-generated method stub
		
			return new Catalogue();
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
	public void addPhoto(String fileUrl, Photo p, Catalogue cat) {
		// TODO Auto-generated method stub
		try {
			converter.instertPhoto(fileUrl, p, cat);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deletePhoto(String fileUrl, Catalogue cat, Photo p) {
		try {
			converter.deletePhoto(fileUrl, p, cat);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Photo getPhoto(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
