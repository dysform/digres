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
	
	public Sentence() {}
	
	public Sentence(Document doc, int begin, int end) {
		this.doc = doc;
		this.begin = begin;
		this.end = end;
	}

	public Sentence(Document doc) {
		this.doc = doc;
	}
	
	@XmlElement
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
}
