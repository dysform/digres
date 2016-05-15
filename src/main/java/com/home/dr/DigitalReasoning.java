package com.home.dr;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class DigitalReasoning {
	
	String outputDir;

	public DigitalReasoning(String outputDir) {
		this.outputDir = outputDir;
	}

	public void run() throws Exception {
		ClassLoader classLoader = getClass().getClassLoader();
		
		String inputFileName = classLoader.getResource("nlp_data.txt").toURI().getPath();
		String nerFileName = classLoader.getResource("NER.txt").toURI().getPath();
		
		Document doc = new DocumentBuilder().buildDocument(
				FileUtils.readFileToString(new File(inputFileName)),
				FileUtils.readLines(new File(nerFileName)));
		
		doc.printSentences();
		
		System.out.println("");
		System.out.println("");
		
		doc.printWords();
		
		System.out.println("");
		System.out.println("");
		
		doc.printNamedEntities();
		
		DocumentXML.printDocument(doc, outputDir+"/objectModel.xml");
	}
	
	public static void main(String[] args) throws Exception {
		DigitalReasoning dr = new DigitalReasoning(args[0]);
		dr.run();
	}
}
