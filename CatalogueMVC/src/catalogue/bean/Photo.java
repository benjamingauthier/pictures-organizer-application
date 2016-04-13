package catalogue.bean;

import java.util.Date;

public class Photo {

	private int id;
	private String source, extension, titre;
	private int taille;
	private boolean jaime, signale;
	private Date creationDate;

	public Photo(String src, String extension, String titre) {
		this.source = src;
		this.extension = extension;
		this.titre = titre;
	}

	

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}


	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public boolean isJaime() {
		return jaime;
	}

	public void setJaime(boolean jaime) {
		this.jaime = jaime;
	}

	public boolean isSignale() {
		return signale;
	}

	public void setSignale(boolean signale) {
		this.signale = signale;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
