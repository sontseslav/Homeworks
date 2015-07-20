package ua.com.iteducate.java.basic.homework.l0017.xmlprocessing;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxXMLParser extends DefaultHandler{

	private int elementsCount;
	private int attributesCount;
	
	@Override
	public void startDocument()throws SAXException{
		System.out.println("Start XML processing...");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.printf("URI: %s; localName: %s; element: %s; attribute: %s%n",uri,localName,qName,attributes);
		if (!qName.equals("")) elementsCount++;
		if (!attributes.equals("")) attributesCount++;
	}
	
	@Override
	public void endElement(String uri,String localName,String qName){
		System.out.println(qName + " finished");
	}
		
	@Override
	public void endDocument()throws SAXException{
		System.out.println("XML processing finished.");
		System.out.printf("Processed %d elements and %d attributes%n",elementsCount,attributesCount);
	}
}
