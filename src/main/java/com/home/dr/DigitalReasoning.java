package com.home.dr;

import java.io.File;

import org.apache.commons.io.FileUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class DigitalReasoning {
	
	public static void main(String[] args) throws Exception {
		DigitalReasoning dr = new DigitalReasoning();
		dr.run();
	}
	
	//String inputFileName = "c:\\users\\diman\\desktop\\NLP_test\\nlp_data.txt";
	
	String inputFileName = "c:\\users\\diman\\desktop\\NLP_test\\d10.txt";
	
	String outputFileName = "c:\\users\\diman\\desktop\\NLP_test\\output.txt";
	
	// Assumptions
	// Sentence ends if 
	// 1. There is a . or ? or !
	// 2. It is followed by one or more white space characters of white spaces
	// 3. the followed by a capital letter or a number.
	public void run() throws Exception {

		Document doc = new Document(FileUtils.readFileToString(new File(inputFileName)));
		
		doc.printSentences();
		
		System.out.println("");
		System.out.println("");
		
		doc.printWords();
		
		System.out.println("");
		System.out.println("");
		
		doc.printNamedEntities();
		
		outputToXML(doc);
	}

	private void outputToXML(Document doc) throws Exception {
		File file = new File("C:\\users\\diman\\file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(doc, file);
		//jaxbMarshaller.marshal(doc, System.out);
	}
}
