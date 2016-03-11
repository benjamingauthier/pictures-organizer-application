package catalogue.service;

import catalogue.bean.Photo;

public interface PhotoManager {
	public Photo creerPhoto();

	public void modifierPhoto();

	public Photo getPHoto(int Id);
}
