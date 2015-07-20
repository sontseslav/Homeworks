package ua.com.iteducate.java.basic.homework.l0017.xmlprocessing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

	public static void main(String[] args) throws Exception{
		File file = new File("robot2.xml");
		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxFactory.newSAXParser();
		SaxXMLParser saxXml = new SaxXMLParser();
		saxParser.parse(file, saxXml);
		saxXml = null;
		saxParser = null;
		saxFactory = null;
		
		DocumentBuilderFactory docBuildFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBldr = docBuildFactory.newDocumentBuilder();
		Document doc = docBldr.parse(file);
		
		Element root = doc.getDocumentElement();
		NodeList nodeList = root.getChildNodes();
		for(int i = 0; i < nodeList.getLength(); i++){
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE){
				Element element = (Element)node;
				if (element.getElementsByTagName("shape_name").item(0)
						.getChildNodes().item(0).getNodeValue().equals("Circle")){
					element.getElementsByTagName("point").item(0).getChildNodes().item(1).setTextContent("10");;
					element.getElementsByTagName("point").item(0).getChildNodes().item(3).setTextContent("20");;
				}
			}
		}
		//ht edit xml using DOM
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(file);
		transformer.transform(source, result);
		System.out.println("Done.");
	}

}
