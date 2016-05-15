package com.home.dr;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Word {
	
	Sentence sentence;
	
	public Word(){}
	
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
		return getFullText();
	}
	
	@XmlElement
	public String getFullText() {
		return sentence.getFullText().substring(begin, end);
	}
	
	@XmlElement
	public String getCharacterText() {
		return sentence.getFullText().substring(characterBegin, characterEnd);
	}

	@XmlElement
	public int getBegin() {
		return begin;
	}

	@XmlElement
	public int getCharacterBegin() {
		return characterBegin;
	}

	@XmlElement
	public int getCharacterEnd() {
		return characterEnd;
	}

	@XmlElement
	public int getEnd() {
		return end;
	}
}
