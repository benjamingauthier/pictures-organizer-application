package catalogue.dao;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import catalogue.bean.*;

public class BibliothequeXMLConverter {

	private Marshaller marshaller;
	private Unmarshaller unmarshaller;
	
	private String file;
	
	public BibliothequeXMLConverter(String file){
		
		this.file=file;
		
	}
	
	
	private  Bibliotheque buildBibliotheque(String fileUrl) throws ParserConfigurationException, SAXException, IOException {
		
		//	HashMap<Integer, Photo> listPhoto=new HashMap<>();
		
			Bibliotheque maBiblio = new Bibliotheque();


			File inputFile = new File(fileUrl);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document doc = builder.parse(inputFile);
			doc.getDocumentElement().normalize();
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			
			NodeList nListCatalogue = doc.getElementsByTagName("catalogue");
					
			
			String src ="", extension="", titre="", taille="", catalogueTitre = "";
			Integer catalogueId = 0, photoId = 0;
			
			for (int t = 0; t < nListCatalogue.getLength(); t++) {
				
				Catalogue monCatalogue = new Catalogue();
				Node no = nListCatalogue.item(t);
				NodeList nList = no.getChildNodes();
				
				catalogueId = Integer.parseInt(no.getAttributes().getNamedItem("id").getNodeValue());
				catalogueTitre = no.getAttributes().getNamedItem("titre").getNodeValue();
				monCatalogue.setId(catalogueId);
				monCatalogue.setTitre(catalogueTitre);
				
				for (int temp = 0; temp < nList.getLength(); temp++) {
					
					Node nNode = nList.item(temp);
					NodeList refNodes = nNode.getChildNodes();
	
					for (int x = 0; x < refNodes.getLength(); x++) {
						Node n = refNodes.item(x);
					
						if (n.getNodeType() == Node.ELEMENT_NODE) {
	
							//System.out.println("node name " + n.getNodeName() + "\n" + n.getTextContent());
	
	
							switch (n.getNodeName()) {
							case "titre":
								titre = n.getTextContent();
								break;
	
							}
						}
						
						//Element e = (Element)n;
						src =nNode.getAttributes().getNamedItem("src").getNodeValue();
						taille = nNode.getAttributes().getNamedItem("taille").getNodeValue();
						
						extension =nNode.getAttributes().getNamedItem("extention").getNodeValue();
						
						Photo currentPhoto = new Photo(src, extension, titre);
						photoId = Integer.parseInt(nNode.getAttributes().getNamedItem("id").getNodeValue());
						//System.out.println("photoId : " + photoId);
						currentPhoto.setId(photoId);
						
						monCatalogue.ajouterPhoto(currentPhoto);
						
						
	
					}
	
				}
				
				maBiblio.ajouterCatalogue(monCatalogue);
			}
						
			return maBiblio;
		//	System.out.println(listPhoto.size());
		}
	
	public void deletePhoto(String fileUrl, Photo ph, Catalogue cat) throws ParserConfigurationException, SAXException, IOException {
		try {
		      File inputFile = new File("/Users/benjamingauthier/Documents/M1/S8/pictures-organizer-application/data/"+fileUrl); 	    	
		      DocumentBuilderFactory docFactory =
		      DocumentBuilderFactory.newInstance();
		      DocumentBuilder docBuilder = 
		      docFactory.newDocumentBuilder();
		      Document doc = docBuilder.parse(inputFile);
		      
		      Node catalogue = doc.getElementsByTagName("catalogue").item(cat.getId());
		      
		      NodeList photos = catalogue.getChildNodes();
		      for (int temp = 0; temp < photos.getLength(); temp++) {
		         Node photo = photos.item(temp);
		         Element photoElem = (Element) photo;
		         if(Integer.parseInt(photoElem.getAttribute("id")) == ph.getId())
		            catalogue.removeChild(photo);
		         }
		         // write the content on console
		         TransformerFactory transformerFactory = 
		         TransformerFactory.newInstance();
		         Transformer transformer = transformerFactory.newTransformer();
		         DOMSource source = new DOMSource(doc);
		         System.out.println("-----------Modified File-----------");
		         StreamResult consoleResult = new StreamResult(System.out);
		         transformer.transform(source, consoleResult);
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
	}

	public Bibliotheque xmlToObject() throws Exception {
		JAXBContext jc = JAXBContext.newInstance(Bibliotheque.class);
		unmarshaller = jc.createUnmarshaller();
		 File f = new File("/Users/benjamingauthier/Documents/M1/S8/pictures-organizer-application/data/catalogue.xml");

	//	Catalogue catalogue = (Catalogue) unmarshaller.unmarshal(f);
		 
		 
		 Bibliotheque bibliotheque = buildBibliotheque("/Users/benjamingauthier/Documents/M1/S8/pictures-organizer-application/data/catalogue.xml");
		
		
		return bibliotheque;
	}
}
