package catalogue.dao;

import catalogue.bean.Catalogue;
import catalogue.bean.Photo;

public interface CatalogueDAO {
	
	public void addPhoto(String fileUrl, Photo p, Catalogue cat);
	
	public void deletePhoto(String fileUrl, Catalogue cat, Photo p);
	
	public Photo getPhoto(int Id);
	
}
