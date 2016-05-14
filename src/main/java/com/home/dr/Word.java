package com.home.dr;

public class Word {
	
	Sentence sentence;
	
	public Word(Sentence s) {
		this.sentence = s;
	}
	
	public Word(Sentence s, int begin, int end) {
		this.sentence = s;
	}
	
	int begin;
	int characterBegin;
	int characterEnd;
	int end;
	
	public String toString() {
		return getText();
	}
	
	public String getText() {
		return sentence.getFullText().substring(begin, end);
	}
	
	public String getCharacterText() {
		return sentence.getFullText().substring(characterBegin, characterEnd);
	}
}
