package catalogue.service;

import java.util.HashMap;

import catalogue.bean.Bibliotheque;
import catalogue.bean.Catalogue;


public interface BibliothequeManager {
	
	public Bibliotheque creerBibliotheque(String fileUrl) throws Exception;	
	
	public void ajouterCatalogue(String fileUrl, Catalogue c, Bibliotheque b);

	public void supprimerCatalogue(String fileUrl, Catalogue c, Bibliotheque b);
	
	public HashMap<Integer, Catalogue> getListCatalogue();
	
	public int getMaxId(HashMap<Integer, Catalogue> catalogues);
}
