package catalogue.bean;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Catalogue {

	// private String fileUrl;
	private Integer id;
	private String titre;
	private HashMap<Integer, Photo> listPhoto = new HashMap<>();

	public Catalogue() {
		// this.fileUrl = fileUrl;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer _id) {
		id = _id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
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
