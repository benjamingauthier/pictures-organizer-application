package catalogue.bean;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Bibliotheque {

	// private String fileUrl;
	private HashMap<Integer, Catalogue> listCatalogue = new HashMap<>();

	public Bibliotheque() {
		// this.fileUrl = fileUrl;
	}
	
	
	public void ajouterCatalogue(Catalogue c) {
		listCatalogue.put(c.getId(), c);
	}

	public void supprimerCatalogue(Catalogue ph) {
		listCatalogue.remove(ph.getId());
	}

	public HashMap<Integer, Catalogue> getListCatalogue() {
		return listCatalogue;
	}

	public void setListCatalogue(HashMap<Integer, Catalogue> listCatalogue) {
		this.listCatalogue = listCatalogue;
	}
	

}