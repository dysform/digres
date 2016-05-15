package com.home.dr;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sentence {

	Document doc;

	int begin;
	int characterEnd;
	int end;
	
	List<Word> words;
	
	List<NamedEntity> namedEntities;
	
	public Sentence() {}
	
	public Sentence(Document doc, int begin, int end) {
		this.doc = doc;
		this.begin = begin;
		this.end = end;
	}

	public Sentence(Document doc) {
		this.doc = doc;
	}
	
	public String getFullText() {
		return doc.text.substring(begin, end);
	}

	@XmlElement
	public String getText() {
		return doc.text.substring(begin, characterEnd);
	}
	
	public String toString() {
		return getText();
	}

	public void printWords() {
		for(Word w : words) {
			System.out.print(w.getCharacterText() + " ");
		}
		System.out.println();
	}
	
	public void printNamedEntities() {
		for(NamedEntity ent : namedEntities) {
			System.out.println(ent);
		}
	}
	
	@XmlElement
	public int getBegin() {
		return begin;
	}

	@XmlElement
	public int getCharacterEnd() {
		return characterEnd;
	}

	@XmlElement
	public int getEnd() {
		return end;
	}

	@XmlElement
	public List<Word> getWords() {
		return words;
	}
	
	@XmlElement
	public List<NamedEntity> getNamedEntities() {
		return namedEntities;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}

	public void setNamedEntities(List<NamedEntity> namedEntities) {
		this.namedEntities = namedEntities;
	}
}
