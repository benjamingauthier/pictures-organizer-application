package catalogue.service;

import java.util.HashMap;

import catalogue.bean.Photo;
import catalogue.bean.Catalogue;

public interface CatalogueManager {

	public void ajouterPhoto(String fileUrl, Catalogue cat, Photo ph);

	public void supprimerPhoto(String fileUrl, Catalogue cat, Photo ph) throws Exception;

	public HashMap<Integer, Photo> getListPhoto();

	public int countPhotos();
	
	public int getMaxId(HashMap<Integer, Photo> photos);
}
