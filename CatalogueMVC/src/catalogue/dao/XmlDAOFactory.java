package catalogue.dao;

public  class XmlDAOFactory extends DAOFactory{
	
	//public static  final String URLFile="F:\\mes cours\\MIAGE\\XML\\TD_Projet\\catalogue.xml";
	
	public CatalogueDAO getCatalogueDAO(){
		return null;
	}
	
	public static DAOFactory getInstance(){
		return new XmlDAOFactory();
	}
	
	 public BibliothequeDAO getBibliothequeDAO() {
			

		    return new XmlBibliothequeDAO(this);
		  }

	@Override
	public PhotoDAO getPhotoDAO() {
		// TODO Auto-generated method stub
		return null;
	}
}
