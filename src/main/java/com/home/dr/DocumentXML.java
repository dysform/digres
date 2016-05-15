package com.home.dr;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class DocumentXML {
	public static void printDocument(Document doc, String fileName) throws Exception {
		File file = new File(fileName);
		JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(doc, System.out);
		jaxbMarshaller.marshal(doc, file);
	}
}