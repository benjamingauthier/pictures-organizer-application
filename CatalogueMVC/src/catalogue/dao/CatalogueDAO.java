package catalogue.dao;

import catalogue.bean.Catalogue;
import catalogue.bean.Photo;

public interface CatalogueDAO {
	
	public Catalogue createCatalogue() throws Exception;
	
	public void deleteCatalogue(int Id);
	
	public void updateCatalogue();
	
	public void addPhoto(String fileUrl, Photo p, Catalogue cat);
	
	public void deletePhoto(String fileUrl, Catalogue cat, Photo p);
	
	public Photo getPhoto(int Id);
	
}
