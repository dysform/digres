package com.home.dr;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Document {

	String text;

	List<Sentence> sentences = new ArrayList<Sentence>();
	
	public Document() {}
	
	public Document(String text) {
		this.text = text;
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
	public void setSentences(List<Sentence> sentences) {
		this.sentences = sentences;
	}
}
