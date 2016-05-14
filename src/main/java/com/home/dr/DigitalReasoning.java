package com.home.dr;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class DigitalReasoning {
	
	public static void main(String[] args) throws Exception {
		DigitalReasoning dr = new DigitalReasoning();
		dr.run();
	}
	
	String inputFileName = "c:\\users\\diman\\desktop\\NLP_test\\nlp_data.txt";
	
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
		
	}
}
