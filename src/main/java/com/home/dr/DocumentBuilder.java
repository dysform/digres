package com.home.dr;

import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class DocumentBuilder implements Runnable{
	SentenceTokenizer sentenceTokenizer = new SentenceTokenizer();
	
	WordTokenizer wordTokenizer = new WordTokenizer();
	
	NamedEntityExtractor namedEntityExtractor;
	
	public DocumentBuilder() {}
	
	InputStream in;
	
	List<String> entities;
	
	Document output;
	
	boolean error = false;
	
	public DocumentBuilder(InputStream in, List<String> entities) {
		this.in = in;
		this.entities = entities;
	}
	
	public void run() {
		try {
			String text = IOUtils.toString(in);
			output = buildDocument(text, entities);
		}
		catch(Exception e) {
			error = true;
		}
	}
	
	public Document buildDocument(String text, List<String> entities) {
		
		Document doc = new Document(text);
		namedEntityExtractor = new NamedEntityExtractor(entities);
		
		doc.setSentences(sentenceTokenizer.getSentences(doc));
		
		for(Sentence s : doc.sentences) {
			s.setWords(wordTokenizer.getWords(s));
			s.setNamedEntities(namedEntityExtractor.getNamedEntities(s));
		}
		
		return doc;
	}
}
