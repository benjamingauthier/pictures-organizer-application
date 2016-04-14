package catalogue.dao;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletContext;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import catalogue.bean.*;

public class BibliothequeXMLConverter {


	public BibliothequeXMLConverter(String file){
		//System.out.println(context.getRealPath("/WEB-INF/data/catalogue.xml")); 
	}
	
	
	
		public String getRealPath(ServletContext context){
			return context.getRealPath("/WEB-INF/data/catalogue.xml");
		}
	
	
	private  Bibliotheque buildBibliotheque(String fileUrl) throws ParserConfigurationException, SAXException, IOException {

			Bibliotheque maBiblio = new Bibliotheque();


			File inputFile = new File(fileUrl);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document doc = builder.parse(inputFile);
			doc.getDocumentElement().normalize();
			
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
		      File inputFile = new File(fileUrl); 	    	
		      DocumentBuilderFactory docFactory =
		      DocumentBuilderFactory.newInstance();
		      DocumentBuilder docBuilder = 
		      docFactory.newDocumentBuilder();
		      Document doc = docBuilder.parse(inputFile);
		      
		      NodeList catalogues = doc.getElementsByTagName("catalogue");
		      
		      for (int temp = 0; temp < catalogues.getLength(); temp++) {
		    	  Node catalogue = catalogues.item(temp);
		          if (catalogue.getNodeType() == Node.ELEMENT_NODE) {
		               Element eCatalogue = (Element) catalogue;
		               if(Integer.parseInt(eCatalogue.getAttribute("id")) == cat.getId()) {
		            	   NodeList photos = catalogue.getChildNodes();
		            	   for (int tem = 0; tem < photos.getLength(); tem++) {
	            			  Node photo = photos.item(tem);
	        		          if (photo.getNodeType() == Node.ELEMENT_NODE) {
	        		        	  Element ePhoto = (Element) photo;
	        		        	  if(Integer.parseInt(ePhoto.getAttribute("id")) == ph.getId()) {
	        		        		  catalogue.removeChild(photo);
	        		        	  }
	        		          }
		            	   }
		               }
		      }
		      }

		         TransformerFactory transformerFactory = 
		         TransformerFactory.newInstance();
		         Transformer transformer = transformerFactory.newTransformer();
		         DOMSource source = new DOMSource(doc);
		         StreamResult result = new StreamResult(new File(fileUrl));
		         transformer.transform(source, result);
		         
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
	}
	
	public void deleteCatalogue(String fileUrl, Catalogue cat) throws ParserConfigurationException, SAXException, IOException {
		try {
		      File inputFile = new File(fileUrl); 	    	
		      DocumentBuilderFactory docFactory =
		      DocumentBuilderFactory.newInstance();
		      DocumentBuilder docBuilder = 
		      docFactory.newDocumentBuilder();
		      Document doc = docBuilder.parse(inputFile);
		      
		      System.out.println("First child "+doc.getElementsByTagName("bibliotheque").item(0));
		      
		      Node bibliotheque = doc.getElementsByTagName("bibliotheque").item(0);
		      
		      NodeList catalogues = doc.getElementsByTagName("catalogue");
		      
		      for (int temp = 0; temp < catalogues.getLength(); temp++) {
		    	  Node catalogue = catalogues.item(temp);
		          if (catalogue.getNodeType() == Node.ELEMENT_NODE) {
		               Element eCatalogue = (Element) catalogue;
		               if(Integer.parseInt(eCatalogue.getAttribute("id")) == cat.getId()) {
		            	   bibliotheque.removeChild(catalogue);
		               }
		          }
		      }

	         TransformerFactory transformerFactory = 
	         TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(doc);
	         StreamResult result = new StreamResult(new File(fileUrl));
	         transformer.transform(source, result);
		         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}

	public Bibliotheque xmlToObject(String fileUrl) throws Exception {
		
		 Bibliotheque bibliotheque = buildBibliotheque(fileUrl);
		
		return bibliotheque;
	}
}
