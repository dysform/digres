package com.home.dr;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class DigitalReasoning {
	
	String inputDir;
	String outputDir;

	public DigitalReasoning(String inputDir, String outputDir) {
		this.inputDir = inputDir;
		this.outputDir = outputDir;
	}

	public void run() throws Exception {
		String inputFileName = inputDir+"/nlp_data.txt";
		String nerFileName = inputDir+"/NER.txt";
		
		Document doc = new DocumentBuilder().buildDocument(
				FileUtils.readFileToString(new File(inputFileName)),
				FileUtils.readLines(new File(nerFileName)));

		DocumentXML.printDocument(doc, outputDir+"/objectModel.xml");
	}
	
	public static void main(String[] args) throws Exception {
		DigitalReasoning dr = new DigitalReasoning(args[0], args[1]);
		dr.run();
	}
}
