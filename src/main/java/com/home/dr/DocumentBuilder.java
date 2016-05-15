package com.home.dr;

import java.util.List;

public class DocumentBuilder {
	SentenceTokenizer sentenceTokenizer = new SentenceTokenizer();
	
	WordTokenizer wordTokenizer = new WordTokenizer();
	
	NamedEntityExtractor namedEntityExtractor;
	
	public DocumentBuilder() {}
	
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
