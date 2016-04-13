package catalogue.dao;

public abstract class DAOFactory {
	// List of DAO types supported by the factory
	public static final int ORACLE = 1;
	public static final int XML = 2;

	
	public abstract CatalogueDAO getCatalogueDAO();
	
	public abstract BibliothequeDAO getBibliothequeDAO();
	
	public abstract PhotoDAO getPhotoDAO();
	
	public static DAOFactory getDAOFactory(int whichFactory) {

		switch (whichFactory) {

		case XML:
			return new XmlDAOFactory();

		default:
			return null;
		}
	}
}
