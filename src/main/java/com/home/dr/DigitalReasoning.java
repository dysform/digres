package com.home.dr;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.FileUtils;

public class DigitalReasoning {
	
	String outputDir;

	public DigitalReasoning(String outputDir) {
		this.outputDir = outputDir;
	}

	public void run() throws Exception {
		ExecutorService ex = Executors.newFixedThreadPool(1);
		
		ClassLoader classLoader = getClass().getClassLoader();
		
		String inputFileName = classLoader.getResource("nlp_data.zip").toURI().getPath();

		ZipFile zipFile = new ZipFile(inputFileName);

	    Enumeration<? extends ZipEntry> entries = zipFile.entries();
	    
	    String nerFileName = classLoader.getResource("NER.txt").toURI().getPath();
	    List<String> entities = FileUtils.readLines(new File(nerFileName));

	    List<DocumentBuilder> builders = new ArrayList<DocumentBuilder>();
	    
	    while(entries.hasMoreElements()){
	        ZipEntry entry = entries.nextElement();
	        
	        if(entry.getName().startsWith("nlp_data/d") && entry.getName().endsWith("txt")) {
	        	InputStream stream = zipFile.getInputStream(entry);
	        	
	        	DocumentBuilder builder = new DocumentBuilder(stream, entities);
	        	builders.add(builder);
	        	ex.execute(builder);
	        } 
	    }
	    
	    ex.shutdown();
	    
	    // simple, 
	    // instead a different mechanism could be used to actually wait until all tasks are finished
	    ex.awaitTermination(10, TimeUnit.SECONDS);
	    
	    zipFile.close();
	    
	    List<Document> results = new ArrayList<Document>();
	    
	    for(DocumentBuilder b : builders) {
	    	results.add(b.output);
	    }
	    
	    DocumentXML.printDocuments(new Documents(results), outputDir+"/objectModel.xml");
	}
	
	public static void main(String[] args) throws Exception {
		DigitalReasoning dr = new DigitalReasoning(args[0]);
		dr.run();
	}
}
