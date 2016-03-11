package catalogue.service;

import java.util.HashMap;

import catalogue.bean.Photo;

public interface CatalogueManager {

	public void creerCatalogue();

	public void modifierCatalogue();

	public void supprimerCatalogue();

	public void ajouterPhoto(Photo ph);

	public void supprimerPhoto(Photo ph);

	public void modifierPhoto(Photo ph);

	public HashMap<Integer, Photo> getListPhoto();

	public int countCatalogues();

	public int countPhotos();

}
