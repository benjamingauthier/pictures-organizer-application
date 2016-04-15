package catalogue.service;

import java.util.HashMap;
import catalogue.bean.Bibliotheque;
import catalogue.bean.Catalogue;


public interface BibliothequeManager {
	
	public Bibliotheque creerBibliotheque(String fileUrl) throws Exception;	
	
	public void ajouterCatalogue(Catalogue c);

	public void supprimerCatalogue(Catalogue c);

	public void modifierCatalogue(Catalogue c);

	public HashMap<Integer, Catalogue> getListCatalogue();


}
