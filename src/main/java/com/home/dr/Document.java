package com.home.dr;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Document {

	String text;

	SentenceTokenizer sentenceTokenizer = new SentenceTokenizer();
	
	WordTokenizer wordTokenizer = new WordTokenizer();
	
	NamedEntityExtractor namedEntityExtractor = new NamedEntityExtractor();
	
	List<Sentence> sentences = new ArrayList<Sentence>();
	
	public Document() throws Exception {}
	
	public Document(String text) {
		this.text = text;
		
		sentences = sentenceTokenizer.getSentences(this);
		
		for(Sentence s : sentences) {
			s.words = wordTokenizer.getWords(s);
			s.namedEntities = namedEntityExtractor.getNamedEntities(s);
		}
	}
	
	public void printSentences() {
		for(Sentence s : sentences) {
			System.out.println(s);
		}
	}

	public void printWords() {
		for(Sentence s : sentences) {
			s.printWords();
		}
	}
	
	public void printNamedEntities() {
		for(Sentence s : sentences) {
			s.printNamedEntities();
		}
	}
	
	@XmlElement
	public String getText() {
		 return text;
	}
	
	@XmlElement
	public List<Sentence> getSentences() {
		return sentences;
	}

	
}
