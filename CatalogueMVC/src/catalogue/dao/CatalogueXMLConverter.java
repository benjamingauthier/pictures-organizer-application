package catalogue.dao;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import catalogue.bean.*;

public class CatalogueXMLConverter {

	private Marshaller marshaller;
	private Unmarshaller unmarshaller;
	
	private String file;
	
	public CatalogueXMLConverter(String file){
		
		this.file=file;
		
	}
	
	
	private  Catalogue buildCatalogue(String fileUrl) throws ParserConfigurationException, SAXException, IOException {
		
		//	HashMap<Integer, Photo> listPhoto=new HashMap<>();
			
			Catalogue monCatalogue= new Catalogue();


			File inputFile = new File(fileUrl);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(inputFile);
			doc.getDocumentElement().normalize();
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("photo");
			
			
			String src ="", extension="", titre="", commentaire="", htag="", taille="" ,resolution="", date_modif="", mentionJaime="", isSignale="";
			int photoID = 1;

			//System.out.println("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				photoID++;
				Node nNode = nList.item(temp);
			//	System.out.println("\nCurrent Element :" + nNode.getNodeName());

				NodeList refNodes = nNode.getChildNodes();

				for (int x = 0; x < refNodes.getLength(); x++) {
					Node n = refNodes.item(x);
				
					if (n.getNodeType() == Node.ELEMENT_NODE) {

						//System.out.println("node name " + n.getNodeName() + "\n" + n.getTextContent());


						switch (n.getNodeName()) {
						case "titre":
							titre = n.getTextContent();
							break;
						case "commentaire":
							commentaire = n.getTextContent();
							break;
						case "htag":
							htag = n.getTextContent();
							break;
						/*case "extension":
							extension = n.getTextContent();
							break;*/
						case "date_modif":
							date_modif = n.getTextContent();
							break;
						/*
						 * case "resolution": resolution = n.getTextContent();
						 * break; case "resolution": resolution =
						 * n.getTextContent(); break;
						 */

						}
					}
					
					//Element e = (Element)n;
					src =nNode.getAttributes().getNamedItem("src").getNodeValue();
					taille = nNode.getAttributes().getNamedItem("taille").getNodeValue();
					
					mentionJaime = nNode.getAttributes().getNamedItem("jaime").getNodeValue();
					extension =nNode.getAttributes().getNamedItem("extention").getNodeValue();
					isSignale= nNode.getAttributes().getNamedItem("extention").getNodeValue();
					resolution= nNode.getAttributes().getNamedItem("resolution").getNodeValue();
					
					Photo currentPhoto = new Photo(src, extension, titre, commentaire, htag, resolution);
					currentPhoto.setId(photoID);
					
					monCatalogue.ajouterPhoto(currentPhoto);
					
					

				}

			}
			
			System.out.println(monCatalogue.getListPhoto().get(2).getTitre());
			
			return monCatalogue;
		//	System.out.println(listPhoto.size());
		}

	public Catalogue xmlToObject() throws Exception {
		JAXBContext jc = JAXBContext.newInstance(Catalogue.class);
		unmarshaller = jc.createUnmarshaller();
		 File f = new File("F:\\mes cours\\MIAGE\\XML\\TD_Projet\\catalogue.xml");

	//	Catalogue catalogue = (Catalogue) unmarshaller.unmarshal(f);
		 
		 
		 Catalogue catalogue = buildCatalogue("F:\\mes cours\\MIAGE\\XML\\TD_Projet\\catalogue.xml");
		
		
		return catalogue;
	}
}
