package catalogue.dao;


import catalogue.bean.Bibliotheque;
import catalogue.bean.Catalogue;

public interface BibliothequeDAO {
	
	public Bibliotheque createBibliotheque() throws Exception;
	
	public void addCatalogue(Catalogue c);
	
}