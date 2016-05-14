package com.home.dr;

import java.util.List;

public class Sentence {
	
	Document doc;

	int begin;
	int characterEnd;
	int end;
	
	List<Word> words;
	
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
}
