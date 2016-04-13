package catalogue.service;

import java.util.HashMap;

import catalogue.bean.Photo;
import catalogue.bean.Catalogue;

public interface CatalogueManager {

	public Catalogue creerCatalogue() throws Exception;

	public void modifierCatalogue();

	public void supprimerCatalogue();

	public void ajouterPhoto(Photo ph);

	public void supprimerPhoto(Catalogue cat, Photo ph) throws Exception;

	public void modifierPhoto(Photo ph);

	public HashMap<Integer, Photo> getListPhoto();

	public int countCatalogues();

	public int countPhotos();

}
