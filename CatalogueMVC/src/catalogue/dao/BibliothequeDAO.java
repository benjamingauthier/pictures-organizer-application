package catalogue.dao;


import catalogue.bean.Bibliotheque;
import catalogue.bean.Catalogue;

public interface BibliothequeDAO {
	
	public Bibliotheque createBibliotheque(String fileUrl) throws Exception;
	
	public void addCatalogue(Catalogue c);
	
}