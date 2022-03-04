package com.hemebiotech.analytics.xmlLoader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
//import java.io.InputStream;

public class XmlLoader {

	private String fileInput;
	private String fileOutput;
	private String filePath;
	private DocumentBuilderFactory dbf;
	
	public XmlLoader(String filePath)
	{
		this.filePath = filePath;
		this.dbf = DocumentBuilderFactory.newInstance();
	}
	
	public boolean parsing()
	{
		try {

	          // optional, but recommended
	          // process XML securely, avoid attacks like XML External Entities (XXE)
	          dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

	          // parse XML file
	          DocumentBuilder db = dbf.newDocumentBuilder();

	          Document doc = db.parse(new File(filePath));

	          // optional, but recommended
	          
	          doc.getDocumentElement().normalize();
	          
	          NodeList list = doc.getElementsByTagName("files");
	          
	          for (int temp = 0; temp < list.getLength(); temp++) {

	              Node node = list.item(temp);

	              if (node.getNodeType() == Node.ELEMENT_NODE) {

	                  Element element = (Element) node;

	                  // get files' attribute
	                  //String id = element.getAttribute("id");

	                  // get text
	                  this.fileInput = element.getElementsByTagName("inputFile").item(0).getTextContent();
	                  this.fileOutput = element.getElementsByTagName("outputFile").item(0).getTextContent();
	                  


	                  
	              }
	          }
	      } catch (ParserConfigurationException | SAXException | IOException e) {
	          e.printStackTrace();
	          return false;
	      }

		
		
		return true;
	}
	
	public String getOutputFile()
	{
		return this.fileOutput;
	}
	
	public String getInputFile()
	{
		return this.fileInput;
	}
	
}
