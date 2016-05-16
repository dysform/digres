package com.home.dr;

public class DocumentBuilder {
	SentenceTokenizer sentenceTokenizer = new SentenceTokenizer();
	
	WordTokenizer wordTokenizer = new WordTokenizer();

	public DocumentBuilder() {}
	
	public Document buildDocument(String text) {
		
		Document doc = new Document(text);
		
		doc.setSentences(sentenceTokenizer.getSentences(doc));
		
		for(Sentence s : doc.sentences) {
			s.setWords(wordTokenizer.getWords(s));
		}
		
		return doc;
	}
}
