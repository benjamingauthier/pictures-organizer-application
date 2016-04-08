package catalogue.bean;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Catalogue {

	// private String fileUrl;
	private HashMap<Integer, Photo> listPhoto = new HashMap<>();

	public Catalogue() {
		// this.fileUrl = fileUrl;
	}

	public void ajouterPhoto(Photo ph) {
		listPhoto.put(ph.getId(), ph);
	}

	public void supprimerPhoto(Photo ph) {
		listPhoto.remove(ph.getId());
	}

	public HashMap<Integer, Photo> getListPhoto() {
		return listPhoto;
	}

	public void setListPhoto(HashMap<Integer, Photo> listPhoto) {
		this.listPhoto = listPhoto;
	}
	

}
