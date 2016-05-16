package com.home.dr;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class DocumentXML {
	
	public static void printDocument(Document doc, String fileName) throws Exception {
		File file = null;
		if(fileName!=null) 
			file = new File(fileName);
		JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(doc, System.out);
		if(file!=null)
			jaxbMarshaller.marshal(doc, file);
	}
	
	public static void printDocuments(List<Document> docs, String fileName) throws Exception {
		File file = null;
		if(fileName!=null) 
			file = new File(fileName);
		JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(docs, System.out);
		if(file!=null)
			jaxbMarshaller.marshal(docs, file);
	}
}
